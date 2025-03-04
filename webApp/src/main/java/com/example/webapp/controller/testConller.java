package com.example.webapp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.cordemo.model.mapper.TblPayBillinfoMapper;
import com.example.cordemo.model.model.TblPayBillinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;


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
//    @Resource
//    private AdminMapper adminDAO;
    @Autowired
    private TblPayBillinfoMapper tblPayBillinfoMapper;



    @RequestMapping("/test")
    public String test() {
        System.out.println("te");
        stringRedisTemplate.opsForValue().set("hello", "world");
        String hello = stringRedisTemplate.opsForValue().get("hello");
        System.out.println(hello);

//        Admin admin = new Admin();
//        admin.setUsername("admin");
//        admin.setPassword("admin");
//        admin.setId(1);
//        admin.setAdmintype(1);
//        stringRedisTemplate.opsForValue().set("admin", JSON.toJSONString(admin));
//        String adminString = stringRedisTemplate.opsForValue().get("admin");
//        System.out.println(adminString);
//

        TblPayBillinfo tblPayBillinfo = new TblPayBillinfo();
        tblPayBillinfo.setBillNo("1");
        tblPayBillinfo.setOrgCode("1");
        tblPayBillinfo.setOrderId("1");
        tblPayBillinfo.setShyzAmt(1L);
        tblPayBillinfo.setSubSeq((short) 1);
        tblPayBillinfo.setDateSsn(LocalDate.now());
        tblPayBillinfo.setSsnPlt("1");
        tblPayBillinfo.setMailCity("1");




        int one = tblPayBillinfoMapper.insert(tblPayBillinfo);

        tblPayBillinfoMapper.selectList(null);
        QueryWrapper<TblPayBillinfo> wrapper = new QueryWrapper<>();
        wrapper.eq("billNo", "1");
        TblPayBillinfo tblPayBillinfo1 = tblPayBillinfoMapper.selectOne(wrapper);
        System.out.println(tblPayBillinfo1);


        return "TEST";
    }

}
