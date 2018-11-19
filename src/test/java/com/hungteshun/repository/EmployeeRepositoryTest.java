package com.hungteshun.repository;

import java.util.Arrays;
import java.util.List;

import com.hungteshun.dao.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 16:49
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("application-context.xml");
        employeeRepository = (EmployeeRepository) ctx.getBean("employeeRepository");
        System.out.println("初始化操作拿到spring上下文");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("将spring上线文销毁操作");
    }

    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("张三");
        System.out.println(employee);
    }

    @Test
    public void testFindByAgeIn() {
        System.out.println(employeeRepository);
        List<Employee> employees = employeeRepository.findByAgeIn(Arrays.asList(20, 21));
        System.out.println(employees);
    }

    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee);
    }

    @Test
    public void testQueryParams1() {
        List<Employee> employees = employeeRepository.queryParams1("张三", 20);
        System.out.println(employees);
    }

    @Test
    public void testQueryParams2() {
        List<Employee> employees = employeeRepository.queryParams2("张三", 20);
        System.out.println(employees);
    }

    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("张三");
        System.out.println(employees);
    }

    @Test
    public void testQueryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("张三");
        System.out.println(employees);
    }

    @Test
    public void testGetCount() {
        Integer count = employeeRepository.getCount();
        System.out.println(count);
    }

    @Test
    public void testPage() {
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> page = employeeRepository.findAll(pageable);
        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前第几页：" + (page.getNumber() + 1));
        System.out.println("查询的当前页面的集合：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 5, sort);
        Page<Employee> page = employeeRepository.findAll(pageable);
        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前第几页：" + (page.getNumber() + 1));
        System.out.println("查询的当前页面的集合：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());
    }

    @Test
    public void testExists(){
        Employee employee = employeeRepository.findOne(1);
        System.out.println(employee);
        boolean exists = employeeRepository.exists(1);
        System.out.println("id为1的记录是否存在：" + exists);
    }
}