package com.heaboy.consumer;

import com.heaboy.consumer.controller.AuthController;
import com.heaboy.service.sys.entity.SysUser;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

    @Reference
    AuthController authController;
    @Test
    public void contextLoads() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword("123456");
        System.out.println(authController.login(sysUser));
    }

}
