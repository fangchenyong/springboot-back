package com.joey.springboot.controller;

import com.joey.springboot.mapper.DepartmentMapper;
import com.joey.springboot.mapper.EmployeeMapper;
import com.joey.springboot.model.Department;
import com.joey.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 〈员工管理控制器〉
 *
 * @author Joey
 * @create 2018-12-18
 * @since 1.0.0
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    /**查询所有员工返回列表页面*/
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.getAll();
        model.addAttribute("emps",employees);
        //返回前缀 classpath:/templates/ 后缀emp/list
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("depts",departments);
        //跳转至添加页面
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("输出员工信息："+employee);
        employeeMapper.save(employee);
        //redirect 表示重定向到一个地址
        //forward  表示转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeMapper.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改员工信息："+employee);
        employeeMapper.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeMapper.delete(id);
        return "redirect:/emps";
    }
}
