package com.cqupt.service;

import com.cqupt.entity.User;

import java.util.List;

/**
 * 用户(User)表服务接口
 *
 * @author makejava
 * @since 2022-08-12 16:56:27
 */
public interface UserService {

    public List<User> findAllByKeywords(int offset, int limit, String id, String name, String phone);

    public Long findTotalCountsByKeywords(String id, String name, String phone);
}
