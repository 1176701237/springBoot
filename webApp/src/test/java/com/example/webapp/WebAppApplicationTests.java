package com.example.webapp;

import com.alibaba.fastjson.JSON;
import com.example.cordemo.model.mapper.AdminMapper;

import com.example.cordemo.model.model.Admin;
import com.example.cordemo.model.model.AdminExample;
import com.example.redisdemo.stringRedisTemplate.service.myRedisTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class WebAppApplicationTests {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private myRedisTemplateService myRedisTemplateService;

    @Resource
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {


        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setId(1);
        admin.setAdmintype(1);
        stringRedisTemplate.opsForValue().set("admin", JSON.toJSONString(admin));
        String adminString = stringRedisTemplate.opsForValue().get("admin");
        System.out.println(adminString);

        myRedisTemplateService.set("adminMyredis", JSON.toJSONString(admin));
        String adminMyredis = myRedisTemplateService.get("adminMyredis");
        System.out.println(adminMyredis);

        AdminExample example = new AdminExample();
        // 创建 Criteria 对象，用于设置具体地查询条件
        AdminExample.Criteria criteria = example.createCriteria();
        // 设置查询条件，例如查询 username 为 "admin" 的记录
        criteria.andUsernameEqualTo("admin");
        List<Admin> adminList = adminMapper.selectByExample(example);
        System.out.println(adminList);


    }

}
