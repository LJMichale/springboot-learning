package com.example.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lj.michale
 * @date 2022-01-24
 */
@Slf4j
@Data
public class Order {

    private long amount;

    private int score;

}
