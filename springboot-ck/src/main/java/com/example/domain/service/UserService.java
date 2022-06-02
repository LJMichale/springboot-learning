package com.example.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bean.User;
import com.example.infrastructure.utils.PageResult;
import org.springframework.stereotype.Service;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2022-05-31
 */
@Service
public interface UserService extends IService<User> {

    /**
     * 主键查询
     * @param uid
     * @return
     */
    User findById(long uid);


    /**
     * 分页查询
     * @param user
     * @param limit
     * @return
     */
    PageResult<User> page(User user, Integer current, Integer limit);

    /**
     * 创建
     * @param user
     * @return
     */
    boolean create(User user);


    /**
     * 创建
     *
     * @param user
     * @return
     */
    boolean update(User user);


    /**
     * 删除
     * @param id
     * @return
     */
    void delete(Long id);

}