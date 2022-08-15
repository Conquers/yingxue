package com.cqupt.service;

import com.cqupt.entity.Video;


import java.util.List;

/**
 * 视频(Video)表服务接口
 *
 * @author makejava
 * @since 2022-08-15 14:06:05
 */
public interface VideoService {

    List<Video> findAllByKeywords(int offset, int limit, String id, String name, String categoryId, String username);

    Long findTotalCountsByKeywords(String id, String name, String categoryId, String username);
}

