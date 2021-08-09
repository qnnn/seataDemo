# seataDemo-AT模式
seata+nacos 基于AT模式，模拟下单之后减库存和账户余额

**依赖**


|              依赖              |     版本      |
| :----------------------------: | :-----------: |
|          spring-boot           | 2.3.2.RELEASE |
|  spring-boot-starter-data-jpa  | 2.3.2.RELEASE |
|      spring-cloud-alibaba      | 2.2.1.RELEASE |
|  nacos-registry\nacos-config   | 2.2.1.RELEASE |
|   seata-spring-boot-starter    |     1.3.0     |
| spring-cloud-starter-openfeign | 2.2.5.RELEASE |
|             lombok             |    1.18.20    |

**注：**
1. 虽seata服务器的版本是1.4.2，与seata-starter依赖不符，原因是同样的配置在1.4.2版本的依赖反而RM注册不上去，降低版本后解决。
2. seata-server的数据库连接池如果设为hikari报错，且springboot服务中的数据库连接池也不能为hikari，不然resourceIds显示为空。
3. 在第二阶段提交或回滚时，如果RM宕机，将会产生脏数据，在分支事务状态表上二阶段提交失败对应状态码7，二阶段回滚失败对应状态码10，可根据状态码和undo_log进行补偿。
### 简略原理图
![image-20210809184407445](https://github.com/qnnn/seataDemo/blob/main/photo/%E5%8E%9F%E7%90%86%E5%9B%BE.png?raw=true)


## AT模式用到的表解析和解决的问题
### global_table

![image-20210809193810933](https://github.com/qnnn/seataDemo/blob/main/photo/global_table.png?raw=true)

+ xid：全局事务id。
+ status：1为全局事务开始。（[官网事务状态查询](http://seata.io/zh-cn/docs/user/appendix/global-transaction-status.html)）
+ transaction_service_group：事务分组，类似于服务实例，作为资源的逻辑隔离单位，发送故障时可快速failover。
+ transaction_name：调用方法



### branch_table

![image-20210809193829781](https://github.com/qnnn/seataDemo/blob/main/photo/branch_table.png?raw=true)

+ branch_id：分支事务id。

+ transaction_id：全局事务id。

  解决TCC中的**悬挂问题**，即由于网络拥堵造成超时，可能回滚完成后，try请求才到达，而一个try请求预留的业务资源也就没人能够处理。在执行一阶段事务时判断是否已有二阶段事务记录，如果有则不执行。

  > Could not found global transaction xid = 192.168.229.1:8091:8097636272062160897, may be has finished.

+ status：事务状态，此处为未知状态。

  作用：保证TCC第二阶段confirm和cancel**接口的幂等**，每次执行前都查询该状态，避免数据不一致。



### lock_table（全局事务锁）

![image-20210809193843600](https://github.com/qnnn/seataDemo/blob/main/photo/lock_table.png?raw=true)

避免脏读脏写，主要是解决写隔离和读隔离。

[官方对写隔离和读隔离的讲解](http://seata.io/zh-cn/docs/overview/what-is-seata.html)





### undolog

![image-20210809193909218](https://github.com/qnnn/seataDemo/blob/main/photo/undo_log.png?raw=true)

**rollback_info中：**

记录了该本地事务的前镜像和后镜像，根据前镜像和后镜像进行回滚和提交操作。
