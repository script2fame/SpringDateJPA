package com.hungteshun.repository;

import java.util.List;

import com.hungteshun.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author hungteshun
 * @description:
 * @date 2018/11/18 16:47
 */

//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
//public interface EmployeeRepository {
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findByName(String name);

    public List<Employee> findByAgeIn(List<Integer> ages);

    @Query("select o from Employee o where o.id = (select max(id) from Employee )")
    public Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name = ?1 and o.age = ?2")
    public List<Employee> queryParams1(String name, Integer age);

    @Query("select o from Employee o where o.name = :name and o.age = :age")
    public List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    public List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    public List<Employee> queryLike2(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(1) from spring_data_jpa_employee")
    public Integer getCount();

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    public void update(@Param("id") Integer id, @Param("age") Integer age);

    @Modifying
    @Query("delete from Employee o where o.id = :id")
    public void delete(@Param("id") Integer id);
}

