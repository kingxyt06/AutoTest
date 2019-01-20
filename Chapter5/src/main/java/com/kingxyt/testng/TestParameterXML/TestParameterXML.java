package com.kingxyt.testng.TestParameterXML;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestParameterXML {
    Connection con;

    @Test
    @Parameters({"dbconfig", "poolsize"})
    public void createConnection(String dbconfig, int poolsize) {
        System.out.println("dbconfig:" + dbconfig);
        System.out.println("poolsize:" + poolsize);

        Properties prop = new Properties();
        InputStream input = null;

        try {
            String path = System.getProperty("user.dir") + "\\" + dbconfig;

            System.out.println("path =>" + path);
            prop.load(new FileInputStream(dbconfig));

            String drivers = prop.getProperty("jdbc.driver");
            String connectionURL = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");

            System.out.println("drivers:"+drivers);
            System.out.println("url:"+connectionURL);
            System.out.println("username:"+username);
            System.out.println("password:"+password);

            Class.forName(drivers);
            con = DriverManager.getConnection(connectionURL,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (input != null){
                try{
                    input.close();
                }catch (IOException e){

                }
            }
        }
    }
}
