package com.hedon.controller;

import com.hedon.bean.OrderInfo;
import com.hedon.bean.PriceInfo;
import com.hedon.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hedon Wang
 * @create 2020-10-05 16:10
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    private RestTemplate restTemplate = new RestTemplate();

    //创建订b'n单
    @PostMapping("/create")
    //public PriceInfo create(@RequestBody OrderInfo orderInfo , @AuthenticationPrincipal User user) 要整个用户的信息，需要配置令牌转换器
    //public PriceInfo create(@RequestBody OrderInfo orderInfo , @AuthenticationPrincipal String username) 只要用户名，不需要配置
    //只要其中一个属性的话，需要先配置令牌转换器，然后用 expression 表达式来取出
    public PriceInfo create(@RequestBody OrderInfo orderInfo , @AuthenticationPrincipal(expression = "#this.id") Integer id){
        System.out.println("userId is " + id);

        PriceInfo priceInfo = restTemplate.getForObject("http://localhost:9080/price/" + orderInfo.getId(), PriceInfo.class);

        System.out.println("price is "+priceInfo.getPrice());

        return priceInfo;
    }

    //读
    @GetMapping("/{id}")
    public OrderInfo getInfo(@PathVariable("id")Integer id){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(id);
        return orderInfo;
    }

}
