package com.djt.service.impl;

import com.djt.domain.Employee;
import com.djt.mapper.EmployeeMapper;
import com.djt.service.EmployeeServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getEmployeeList();
    }

    @Override
    public int deleteByEmployId(Integer id) {
        int i = employeeMapper.deleteEmployeeByid(id);
        return i;
    }

    @Override

        public PageInfo<Employee> getEmployeeList(Integer pageNum) {
            PageHelper.startPage(pageNum, 4);
            List<Employee> list = employeeMapper.getEmployeeList();
        System.out.println(list);
            PageInfo<Employee> page = new PageInfo<>(list, 5);
            return page;

    }

    @Override
    public Employee findById(Integer id) {
      return employeeMapper.findbyId(id);

    }

    @Override
    public int updateById(Employee employee) {
        int i = employeeMapper.updateByid(employee);
        return i;
    }
}
