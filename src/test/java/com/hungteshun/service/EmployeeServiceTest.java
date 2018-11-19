package com.hungteshun.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 22:17
 */
public class EmployeeServiceTest {

    private ApplicationContext ctx = null;

    private EmployeeService employeeService = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("application-context.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("初始化操作拿到spring上下文");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("将spring上线文销毁操作");
    }

    @Test
    public void update() {
        employeeService.update(1,20);
    }

    @Test
    public void delete() {
        employeeService.delete(3);
    }
}