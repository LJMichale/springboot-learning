package com.turing.application.service;

import com.gitee.fastmybatis.core.support.IService;
import com.turing.bean.TUser;
import org.springframework.stereotype.Service;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2022-04-19
 */
// 实现通用接口
@Service
public class UserService implements IService<TUser/*实体类*/, Integer/*主键类型*/> {

}