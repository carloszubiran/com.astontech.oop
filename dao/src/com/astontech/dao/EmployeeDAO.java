package com.astontech.dao;

import com.astontech.bo.Employee;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface EmployeeDAO {

    //notes:    GET Methods

    public Employee getEmployeeById(int employeeId);
    public List<Employee> getEmployeeList();

    //notes:    Execute Methods

    public int insertEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(int employeeId);



}
