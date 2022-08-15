package com.cqupt.controller;

import com.cqupt.entity.Video;
import com.cqupt.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频(Video)表控制层
 *
 * @author makejava
 * @since 2022-08-15 14:06:05
 */
@RestController
@RequestMapping("/videos")
public class VideoController {
    /**
     * 服务对象
     */
    @Resource
    private VideoService videoService;


    @GetMapping
    public Map<String, Object> videos(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "pre_page", defaultValue = "5") Integer rows,
                                      String id,    //视频id
                                      String name,  //视频名称
                                      @RequestParam(value = "category_id", required = false) String categoryId,  //类别id
                                      @RequestParam(value = "uploader_name", required = false) String username   //根据up主 根据用户名查
    ) {
        HashMap<String, Object> map = new HashMap<>();
        //根据条件搜索的服务条件的记录
        Long totalCounts = videoService.findTotalCountsByKeywords(id, name, categoryId, username);
        //根据条件搜索的结果集合
        List<Video> items = videoService.findAllByKeywords(page, rows, id, name, categoryId, username);
        map.put("items", items);
        map.put("totals", totalCounts);
        return map;
    }
}

