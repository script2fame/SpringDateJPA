package com.hungteshun;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 16:20
 */
public class SpringDateTest {
    private ApplicationContext ctx = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println("初始化操作拿到spring上下文");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("将spring上线文销毁操作");
    }

    @Test
    public void testEntityManagerFactory(){

    }
}
