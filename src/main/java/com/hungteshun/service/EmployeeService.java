package com.hungteshun.service;

import javax.transaction.Transactional;

import com.hungteshun.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 22:14
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }

    @Transactional
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }

}
