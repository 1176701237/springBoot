package com.example.webapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpURLConnectionExample {
    public static void main(String[] args) {
        int i  = 0;
        String url; // 替换为实际的请求地址
        while (true) {
            try {

                url = "http://tstpaysit.11185.cn/pupp-cas-webapp/mobileH5.getClient/01000001/20250311125401899375174823448576lichenhao1206**"+i;
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // 设置请求方法为 GET
                con.setRequestMethod("GET");

                // 获取响应码
                int responseCode = con.getResponseCode();
                System.out.println("Response Code : " + responseCode);

                // 读取响应内容
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                i++;
                System.out.println("请求次数：" + i);
                // 打印响应内容
//                    System.out.println(response.toString());
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}