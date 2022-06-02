package com.example.domain.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends SuperMapper<User> {

    /**
     * 主键查询用户信息
     *
     * @param uid
     * @return
     */
    User findById(@Param("uid") long uid);

    /**
     * 用户分页查询
     *
     * @param user
     * @return
     */
    Page<User> page(Page<User> page, @Param("user") User user);


}