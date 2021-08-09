# seataDemo
seata+nacos 模拟下单之后减库存和账户余额

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
1. 虽然seata服务器的版本是1.4.2，seata-starter依赖不符的原因是，同样的配置在1.4.2版本的依赖反而RM注册不上去，降低版本后解决
