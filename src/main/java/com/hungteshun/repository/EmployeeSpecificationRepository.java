package com.hungteshun.repository;

import com.hungteshun.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 22:56
 */
public interface EmployeeSpecificationRepository
        extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

}
