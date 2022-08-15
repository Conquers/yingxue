package com.cqupt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(User)实体类
 *
 * @author makejava
 * @since 2022-08-12 16:56:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -92162551649590213L;
    
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 头像链接
     */
    private String avatar;
    /**
     * 简介
     */
    private String intro;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 是否绑定手机号
     */
    private Integer phoneLinked;
    /**
     * 微信openid
     */
    private String openid;
    /**
     * 是否绑定微信
     */
    private Integer wechatLinked;
    /**·
     * 关注数
     */
    private Integer followingCount;
    /**
     * 粉丝数
     */
    private Integer followersCount;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;

}

