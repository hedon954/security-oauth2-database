package com.hedon.controller;

import com.hedon.bean.PriceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Hedon Wang
 * @create 2020-10-05 16:13
 */
@RestController
@RequestMapping("/price")
public class PriceController {


    @GetMapping("/{id}")
    public PriceInfo getPrice(@PathVariable("id") Integer id){
        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setId(id);
        priceInfo.setPrice(new BigDecimal(100));
        return priceInfo;
    }

}
