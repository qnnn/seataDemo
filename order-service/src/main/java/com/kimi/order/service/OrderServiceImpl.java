package com.kimi.order.service;

import com.kimi.order.entity.Order;
import com.kimi.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 郭富城
 */
@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(String userId,String commodityCode,Long count,Long money){
        Order order = new Order();
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        order.setCount(count);
        order.setMoney(money);
        orderRepository.save(order);
    }
}
