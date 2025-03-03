package com.example.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
