package com.djt.controller;

import com.djt.domain.Employee;
import com.djt.service.EmployeeServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/employee")
    public String getAll(Model model){
        model.addAttribute("list",employeeServices.getAllEmployee());
        return "employee";
    }



    @RequestMapping("/delete/{id}/{pageNum}")
    public String delete(@PathVariable("id") Integer id,@PathVariable("pageNum") Integer pageNum){
      int  c =  employeeServices.deleteByEmployId(id);
      if (c >0){
          return "forward:/employee/page/"+pageNum;
      }
      else {
          return "error";
      }
    }

    @GetMapping(value = "/employee/page/{pageNum}")
    public String getEmployeeList(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Employee> page = employeeServices.getEmployeeList(pageNum);
        model.addAttribute("page", page);
        return "employee";
    }

    @GetMapping("/employee/{id}/{pageNum}")
    public String getById(Model model,@PathVariable("id") Integer id,
                          @PathVariable("pageNum") Integer pageNum){
        model.addAttribute("li",employeeServices.findById(id));
        model.addAttribute("pageNum",pageNum);
        return "employee_update";
    }

    @PutMapping(value = "/update/{pageNum}")
    public String updateById(Employee employee,@PathVariable("pageNum") Integer pageNum,Model model){
        model.addAttribute("li",employeeServices.updateById(employee));
        return "forward:/employee/page/"+pageNum;
    }
    @PutMapping(value = "/employee/page/{pageNum}")
    public String getEmployeeList2(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Employee> page = employeeServices.getEmployeeList(pageNum);
        model.addAttribute("page", page);
        return "employee";
    }

}
