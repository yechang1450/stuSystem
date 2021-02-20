package com.heaboy.consumer.service;


import com.heaboy.consumer.domain.ResponseUserToken;
import com.heaboy.consumer.domain.UserDetail;
import com.heaboy.service.sys.entity.SysUser;

/**
 * @author: Wangzhen
 * createAt: 2020/5/29
 */
public interface IAuthService {
    /**
     * 注册用户
     * @param sysUser
     * @return
     */
    Boolean register(SysUser sysUser);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    ResponseUserToken login(String username, String password);

    /**
     * 登出
     * @param token
     */
    void logout(String token);

    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    ResponseUserToken refresh(String oldToken);

    /**
     * 根据Token获取用户信息
     * @param token
     * @return
     */
    UserDetail getUserByToken(String token);
}
