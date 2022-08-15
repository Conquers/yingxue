package com.cqupt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 视频(Video)实体类
 *
 * @author makejava
 * @since 2022-08-15 14:06:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video implements Serializable {
    private static final long serialVersionUID = 344638056193444348L;
    
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介
     */
    private String intro;
    /**
     * up主id
     */
    private Integer uid;
    /**
     * 视频封面链接
     */
    private String cover;
    /**
     * 视频播放链接
     */
    private String link;
    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 分类
     */
    private String category;

    /**
     * 分类
     */
    private User uploader;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;
}

