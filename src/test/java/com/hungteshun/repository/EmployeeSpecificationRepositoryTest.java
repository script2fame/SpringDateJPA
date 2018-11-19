package com.hungteshun.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 22:59
 */
public class EmployeeSpecificationRepositoryTest {
    private ApplicationContext ctx = null;

    private EmployeeSpecificationRepository employeeSpecificationRepository = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("application-context.xml");
        employeeSpecificationRepository = (EmployeeSpecificationRepository) ctx
                .getBean("employeeSpecificationRepository");
        System.out.println("初始化操作拿到spring上下文");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("将spring上线文销毁操作");
    }

    /**
     * 1、查询条件
     * 2、排序
     * 3、分页
     */
    @Test
    public void testSpecificationQuery() {
    }
}
