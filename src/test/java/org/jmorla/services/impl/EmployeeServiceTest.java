package org.jmorla.services.impl;

import org.jmorla.models.Employee;
import org.jmorla.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.jmorla.ApplicationTestConfiguration.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class EmployeeServiceTest {

    @Autowired private EmployeeService employeeService;


    @Test
    public void shouldAddEmployeeToDB(){
        Employee e = new Employee(USERID,EMPLOYE_FIRST_NAME,EMPLOYE_LAST_NAME);
        employeeService.deleteEmployee(e);
        employeeService.addEmployee(e);
    }

    @Test
    public void shouldUpdateEmployeeFrom(){
        Employee e = new Employee(USERID,EMPLOYE_FIRST_NAME,EMPLOYE_LAST_NAME,null);
        employeeService.updateEmployee(e);
    }

    @Test
    public void shouldBeListedAllEmployeeFromDB(){
        List list = employeeService.findAllEmployees();
        assertNotNull(list);
    }

    @Test
    public void shouldBeReturnedEmployeeByIdFromDB(){
        Employee emp = employeeService.findEmployeeById(USERID);
        assertNotNull(emp);
    }

    @Test
    public void shouldBeDeletedEmployeeFromDB(){
        Employee e = new Employee(USERID,EMPLOYE_FIRST_NAME,EMPLOYE_LAST_NAME);
        employeeService.deleteEmployee(e);
        employeeService.addEmployee(e);
    }

}
