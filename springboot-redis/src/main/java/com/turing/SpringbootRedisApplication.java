package com.turing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @descr Springboot Redis
 *
 * @author lj.michale
 * @date 2022/5/31 23:17
 */
@ComponentScan(basePackages = {"com.turing.component"})
@SpringBootApplication
public class SpringbootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }

}
