package com.kingxyt.testng.dependsOnGroups;

import org.testng.annotations.Test;

@Test(groups = "Server")
public class TestServer {

    @Test
    public void deployServer(){
        System.out.println("Deploying Server... ");
    }
    @Test(dependsOnMethods = "deployServer")
    public void deployBackupServer(){
        System.out.println("Deploying Backup Server...");
    }
}
