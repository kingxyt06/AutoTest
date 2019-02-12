package com.tester.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesforPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
//        读取配置文件
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
//        获取配置文件中的url
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
//        拼接url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);


//        获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList= store.getCookies();

        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookies name:"+name+"; Cookies value:"+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        String testUrl = this.url+uri;
        String result;
//        创建一个post对象
        HttpPost post = new HttpPost(testUrl);
//        创建一个client
        DefaultHttpClient client = new DefaultHttpClient();
//        传入参数,参数是json格式
        JSONObject object = new JSONObject();
        object.put("name","zhangsan");
        object.put("age","18");
        StringEntity entity = new StringEntity(object.toString(),"utf-8");
        post.setEntity(entity);
//        设置headers信息
        post.setHeader("content-type","application/json");
//        设置cookies
        client.setCookieStore(this.store);
//        执行请求
        HttpResponse response = client.execute(post);
//        建立对象接受响应信息
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        JSONObject resultJson = new JSONObject(result);
        String success = (String) resultJson.get("zhangsan");
        String status = (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
