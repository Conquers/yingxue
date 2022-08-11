package com.cqupt.controller;

import com.cqupt.dto.AdminDto;
import com.cqupt.entity.Admin;
import com.cqupt.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * (Admin)表控制层
 *
 * @author kioo
 * @since 2022-08-11 15:53:59
 */
@RestController
public class AdminController {

    private final AdminService adminService;
    private final RedisTemplate redisTemplate;

    @Autowired
    public AdminController(AdminService adminService, RedisTemplate redisTemplate) {
        this.adminService = adminService;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 管理员登录
     */
    @PostMapping("/tokens")
    public Map<String, String> tokens(@RequestBody Admin admin, HttpSession session) {
        Map<String, String> result = new HashMap<>();
        // 登录
        Admin adminDB = adminService.login(admin);
        // 登录成功,获取token
        String token = session.getId();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(token, adminDB, 30, TimeUnit.MINUTES);
        result.put("token", token);
        return result;
    }

    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable("token") String token) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(token);
    }

    /**
     * 已登录用户信息接口
     */
    @GetMapping("/admin-user")
    public AdminDto adminDto(String token){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Admin admin = (Admin) redisTemplate.opsForValue().get(token);
        AdminDto adminDto = new AdminDto();
        /*
        简化代码，用下面的BeanUtils.copyProperties
        adminDto.setUsername(admin.getUsername());
        adminDto.setAvatar(admin.getAvatar());
        */
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }
}
