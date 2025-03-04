package com.example.webapp.Redis;

import com.alibaba.fastjson.JSON;
import com.example.cordemo.model.mapper.AdminMapper;

import com.example.cordemo.model.model.Admin;
import com.example.cordemo.model.model.AdminExample;
import com.example.redisdemo.stringRedisTemplate.service.myRedisTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Discription:
 * @User: LiChenHao
 * @Date: 2025/3/4 下午4:29
 */
@SpringBootTest
public class redisQuesion {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private myRedisTemplateService myRedisTemplateServiceDao;

    @Resource
    private AdminMapper adminMapper;
    @Test
    public void caches() throws InterruptedException {
        Admin  adminBefore = new Admin() ;
        adminBefore.setUsername("admin");

        AdminExample adminExample = new AdminExample() ;
        AdminExample.Criteria  criteria = adminExample.createCriteria() ;
        criteria.andUsernameEqualTo(adminBefore.getUsername());

        System.out.println(JSON.toJSON(adminExample));
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (ObjectUtils.isEmpty(admins)) {
            System.out.println("adminsIsEmpty");
            adminBefore.setUsername("adminAfter");
            Admin adminAfterEmpty = new Admin();
            adminAfterEmpty.setUsername("admin");
            AdminExample adminExample1 = new AdminExample() ;
            AdminExample.Criteria criteria1 = adminExample1.createCriteria();
            criteria1.andUsernameEqualTo(adminBefore.getUsername());
            int i = adminMapper.updateByExampleSelective(adminAfterEmpty, adminExample1);

            admins = adminMapper.selectByExample(adminExample);
        }
        if (admins.size() > 1) {
            System.out.println("adminsSize>1");
            return ;
        }
        //把查出来的数据放到缓存中
        Admin adminOne = admins.get(0);
        myRedisTemplateServiceDao.set("admin", JSON.toJSONString(adminOne));
        String adminRedis = myRedisTemplateServiceDao.get("admin");
        System.out.println("adminRedis"+adminRedis);
        Thread.sleep(1000);

        /**
         * 延迟双删
         */
        //删除缓存
        myRedisTemplateServiceDao.delete("admin");
        String adminRedisDelete = myRedisTemplateServiceDao.get("admin");
        System.out.println("adminRedisDelete"+adminRedisDelete);

        //更新数据库
        Admin adminAfter = new Admin();
        adminAfter.setUsername("adminAfter");
        AdminExample adminExample1 = new AdminExample() ;
        AdminExample.Criteria criteria1 = adminExample1.createCriteria();
        criteria1.andUsernameEqualTo(adminBefore.getUsername());
        int i = adminMapper.updateByExampleSelective(adminAfter, adminExample1);
        if (i != 1) {

            System.out.println("updateFail");
            return ;
        }
        //延迟一段时间
        Thread.sleep(1000);
        //查询数据库
        criteria1.andUsernameEqualTo(adminAfter.getUsername());

        AdminExample adminExample2 = new AdminExample() ;
        adminExample2.createCriteria().andUsernameEqualTo(adminAfter.getUsername());
        List<Admin> adminsAfter = adminMapper.selectByExample(adminExample2);
        System.out.println("adminAfter:"+ JSON.toJSON(adminsAfter));
        ;
        //更新缓存
        Admin adminRedisAfter = adminsAfter.get(0);
        myRedisTemplateServiceDao.set("admin", JSON.toJSONString(adminRedisAfter));
        System.out.println("adminAfterRedis:"+myRedisTemplateServiceDao.get("admin"));


    }
}
