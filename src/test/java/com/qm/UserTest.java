package com.qm;

import com.qm.jpa.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/26 23:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserDao userDao;

    @Test
    public void findUserTest() {

        System.out.println(userDao.findByName("hello"));
    }

    @Test
    public void findUserTest1() {
        System.out.println(userDao.findUserByQuery("a"));
    }

}
