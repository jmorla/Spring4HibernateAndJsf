package org.jmorla.controllers;

import org.jmorla.models.Employee;
import org.jmorla.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@Controller
@ManagedBean
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

    private List<Employee> employees;
    private List<Employee> employeesFilter;
    private Employee employee;

    public void init(){
        initNew();
    }

    public void initNew(){
        employees = employeeService.findAllEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployeesFilter() {
        return employeesFilter;
    }

    public void setEmployeesFilter(List<Employee> employeesFilter) {
        this.employeesFilter = employeesFilter;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
