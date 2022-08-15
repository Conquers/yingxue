package com.cqupt.service.impl;

import com.cqupt.entity.Video;
import com.cqupt.dao.VideoDao;
import com.cqupt.service.VideoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 视频(Video)表服务实现类
 *
 * @author makejava
 * @since 2022-08-15 14:06:05
 */
@Service("videoService")
@Transactional
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoDao videoDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Video> findAllByKeywords(int offset, int limit, String id, String name, String categoryId, String username) {
        int start = (offset - 1) * limit;
        return videoDao.findAllByKeywords(start, limit, id, name, categoryId, username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotalCountsByKeywords(String id, String name, String categoryId, String username) {
        return videoDao.findTotalCountsByKeywords(id, name, categoryId, username);
    }
}
