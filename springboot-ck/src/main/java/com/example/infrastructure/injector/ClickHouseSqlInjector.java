package com.example.infrastructure.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.example.infrastructure.methds.DeleteClickHouse;
import com.example.infrastructure.methds.UpdateByIdClickHouse;
import com.example.infrastructure.methds.UpdateClickHouse;

import java.util.List;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2022-05-31
 */
public class ClickHouseSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {

        /**
         * 这里很重要，先要通过父类方法，获取到原有的集合，不然会自带的通用方法会失效的
         */
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);

        /***
         * 添加自定义方法类
         */
        methodList.add(new UpdateByIdClickHouse());
        methodList.add(new UpdateClickHouse());
        methodList.add(new DeleteClickHouse());

        return methodList;
    }

}