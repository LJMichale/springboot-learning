package com.example.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2022-05-31
 */
@SuppressWarnings("all")
public interface SuperMapper<T> extends BaseMapper<T> {

    /**
     * @Description: 删除并填充删除人信息
     * @param: id 主键id
     */
    boolean updateByIdClickHouse(@Param("et") T entity);


    /**
     * @Description: 删除并填充删除人信息
     * @param: id 主键id
     */
    boolean updateClickHouse(@Param("et") T entity, @Param("ew") Wrapper<T> updateWrapper);

    /**
     * 主键删除
     *
     * @param id
     * @return
     */
    int deleteByIdClickHouse(Serializable id);

}