package com.example;

import com.example.entity.User;
import com.example.domain.mapper.bigdata.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Resource
    UserMapper userMapper;

    @DisplayName("测试Mybatis-plus操作")
    @Test
    void contextLoads() {
        // query
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        // update
    }


}
