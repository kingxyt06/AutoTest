package com.tester.server;

import com.tester.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我所有的post方法")
public class MyPostMethod {
    //设定变量来装cookie信息
    public static javax.servlet.http.Cookie cookie;

    //用户登录成功后获取到cookies,之后再去访问其他接口获取到列表信息
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录成功后获得cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response ,
                        @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){
            if(username.equals("zhangsan")&&password.equals("123456")){
                cookie = new Cookie("login","true");
                response.addCookie(cookie);
                return "恭喜登陆成功!";
            }
            return "用户名或者密码错误!";
    }

    //用户携带cookie访问获取用户列表信息
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
//        获取cookies
        javax.servlet.http.Cookie[] cookies = request.getCookies();
//        验证cookies是否合法
        for(javax.servlet.http.Cookie c :cookies){
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUsername().equals("zhangsan")
                    &&u.getPassword().equals("123456")){
                User user = new User();
                user.setName("kiki");
                user.setAge("18");
                user.setSex("women");
                return user.toString();
            }

        }
        return "参数不合法!";
    }

}
