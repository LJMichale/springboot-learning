package com.example.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2022-05-31
 */
@Data
public class Order implements Serializable {
    private Long Id;
    private Long userId;
    private String title;
    private Float price;
    private Date createTime;
    private Date updateTime;
}