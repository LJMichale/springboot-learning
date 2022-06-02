package com.ck;

import com.example.SpringbootCkApplication;
import com.example.config.ClickHouseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2022-05-31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCkApplication.class)
public class SqlTest {

    @Test
    public void select_Test() {
        String sql="select cluster,shard_num from clusters where  cluster like '%test%'";
        List<Map<String,String>> result= ClickHouseConfig.exeSql(sql);
        System.out.println(result);
    }
}