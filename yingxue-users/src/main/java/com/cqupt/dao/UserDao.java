package com.cqupt.dao;


import com.cqupt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-12 16:56:27
 */
public interface UserDao {
    /**
     * 根据分页查询
     */
    List<User> findAllByKeywords(@Param("offset") int offset, @Param("limit") int limit, @Param("id") String id, @Param("name") String name, @Param("phone") String phone);

    /**
     * 根据条件查询总条数
     */
    Long findTotalCountsByKeywords(@Param("id") String id, @Param("name") String name, @Param("phone") String phone);

}
