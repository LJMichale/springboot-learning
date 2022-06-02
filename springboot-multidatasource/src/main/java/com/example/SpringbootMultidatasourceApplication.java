package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @descr
 *
 * @author
 * @date 2022/1/22 22:29
 */
@EnableTransactionManagement
@SpringBootApplication
public class SpringbootMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMultidatasourceApplication.class, args);
    }

}
