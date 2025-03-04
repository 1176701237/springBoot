package com.example.webapp.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.cordemo.model.mapper.AdminMapper;
import com.example.cordemo.model.mapper.TblPayBillinfoMapper;
import com.example.cordemo.model.model.Admin;
import com.example.cordemo.model.model.AdminExample;
import com.example.cordemo.model.model.TblPayBillinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @author： LiChenHao
 * @date： 2025/3/3 下午11:36
 * @description：
 * @modifiedBy：
 * @version: 1.0.1
 */
@RestController
public class testConller {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private AdminMapper adminMapper;
    @Autowired
    private TblPayBillinfoMapper tblPayBillinfoMapper;



    @RequestMapping("/test")
    public String test() {
        System.out.println("te");
        stringRedisTemplate.opsForValue().set("hello", "world");
        String hello = stringRedisTemplate.opsForValue().get("hello");
        System.out.println(hello);

        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setId(1);
        admin.setAdmintype(1);
        stringRedisTemplate.opsForValue().set("admin", JSON.toJSONString(admin));
        String adminString = stringRedisTemplate.opsForValue().get("admin");
        System.out.println(adminString);



        AdminExample example = new AdminExample();
        // 创建 Criteria 对象，用于设置具体的查询条件
        AdminExample.Criteria criteria = example.createCriteria();
        // 设置查询条件，例如查询 username 为 "admin" 的记录
        criteria.andUsernameEqualTo("admin");
        List<Admin> adminList = adminMapper.selectByExample(example);



        return adminList.toString();
    }

}
