package org.jmorla.services.impl;

import org.jmorla.daos.EmployeeDAO;
import org.jmorla.models.Employee;
import org.jmorla.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired private EmployeeDAO employeeDAO;

    @Transactional(readOnly = true)
    public Employee findEmployeeById(String uuid) {
        return employeeDAO.findById(uuid);
    }

    @Transactional
    public void addEmployee(Employee emp) {
        employeeDAO.save(emp);
    }

    @Transactional
    public void updateEmployee(Employee emp) {
        employeeDAO.update(emp);
    }

    @Transactional
    public void deleteEmployee(Employee emp) {
        employeeDAO.delete(emp);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {

        return employeeDAO.findAll();
    }
}
