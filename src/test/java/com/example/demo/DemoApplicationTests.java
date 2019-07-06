package com.example.demo;

import com.example.demo.Dao.EmpDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.Emp;
import com.example.demo.Entity.User;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        int len = UserDao.insertUser(new User(null,1234567L,"123","宝贝",0,null,null));
        System.out.println(len);
    }


}
