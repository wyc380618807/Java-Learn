package com.example.javalearn;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: wangyucheng19
 * @date: 2022/8/10
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavalearnApplication.class)
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

}
