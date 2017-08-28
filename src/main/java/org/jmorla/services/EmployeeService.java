package org.jmorla.services;

import org.jmorla.models.Employee;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
public interface EmployeeService {

    public Employee findEmployeeById(String uuid);

    public void addEmployee(Employee emp);

    public void updateEmployee(Employee emp);

    public void deleteEmployee(Employee emp); // never use in this

    public List<Employee> findAllEmployees();
}
