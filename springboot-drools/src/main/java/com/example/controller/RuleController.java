package com.example.controller;

import com.example.entity.Order;
import com.example.domain.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lj.michale
 * @date 2022-01-24
 */
@RestController
public class RuleController {

    @Autowired
    RuleService ruleService;

    @GetMapping("/saveOrder")
    public Order saveOrder(Order order) {
        return ruleService.executeRule(order);
    }

}
