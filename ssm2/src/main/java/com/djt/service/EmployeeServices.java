package com.djt.service;

import com.djt.domain.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeServices {
    public List<Employee> getAllEmployee();

    int deleteByEmployId(Integer id);
    PageInfo<Employee> getEmployeeList(Integer pageNum);
    Employee findById(Integer id);
    int updateById(Employee employee);
}
