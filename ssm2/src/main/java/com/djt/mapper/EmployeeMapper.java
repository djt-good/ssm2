package com.djt.mapper;

import com.djt.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {


        int deleteEmployeeByid(int id);
        List<Employee> getEmployeeList();
        int updateByid(@Param("employee") Employee employee);
        Employee findbyId(int id);
//        List<Employee> pageEmployee(Integer pageNum);
}
