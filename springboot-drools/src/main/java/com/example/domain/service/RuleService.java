package com.example.domain.service;

import com.example.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lj.michale
 * @date 2022-01-24
 */
@Service
@Slf4j
public class RuleService {

    @Autowired
    KieBase kieBase;

    public Order executeRule(Order order) {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
        return order;
    }

}
