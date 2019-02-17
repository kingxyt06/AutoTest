package com.tester.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我所有的get方法")
public class MyGetMethod {
//    设置访问路径,定义请求方式GET
    @RequestMapping(value = {"/getCookies"},method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法获得cookies",httpMethod ="GET")
    public String getCookies(HttpServletResponse response){
//        HttpServletRequest 装请求信息的类
//        HttpServletResponse 装响应信息的类
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("login","true");
        response.addCookie(cookie);
        return "成功获取到cookies啦";
    }

//    一个必须携带cookie信息访问的get请求接口
    @RequestMapping(value = {"/get/with/cookies"},method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookie信息来访问";
        }
        for (javax.servlet.http.Cookie cookie:cookies){
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                return "这是一个携带cookie信息访问的get请求！";
            }
        }
        return "你必须携带cookie信息来访问";
    }

    /**
     * 一个必须携带参数的get请求
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "getWithParam",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带cookies信息才能访问的get请求,第一种方法",httpMethod = "GET")
    public Map<String,Integer> getWithParam(@RequestParam Integer start,
                                            @RequestParam Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("鞋子",800);
        mylist.put("手机",8000);
        mylist.put("午餐",80);
        return mylist;
        }

    /**
     * 携带参数的get请求，另外一种方式
     * url:ip:port/myGetList/{start}/{end}
     */
    @RequestMapping(value = "myGetList/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带cookies信息才能访问的get请求,第二种方法",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("鞋子",800);
        mylist.put("手机",8000);
        mylist.put("午餐",80);
        return mylist;
    }
}

