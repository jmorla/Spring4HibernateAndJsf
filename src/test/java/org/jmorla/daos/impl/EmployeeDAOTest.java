package org.jmorla.daos.impl;

import org.jmorla.daos.EmployeeDAO;
import org.jmorla.models.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.jmorla.ApplicationTestConfiguration.*;
import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class EmployeeDAOTest {

    @Autowired private EmployeeDAO employeeDAO;

    @Test
    @Transactional
    public void shouldInsertEmployeeFromDB(){
        Employee e = new Employee(USERID,EMPLOYE_FIRST_NAME,EMPLOYE_LAST_NAME);
        employeeDAO.save(e);
    }

    @Test
    @Transactional
    public void shouldUpdateEmployeFromDB(){
        Employee e = new Employee(USERID,EMPLOYE_FIRST_NAME+"test",EMPLOYE_LAST_NAME+"test",null);
        employeeDAO.update(e);
    }

    @Test
    @Transactional
    public void shouldReturnListOfEmployeesFromDB(){
        List<Employee>  list= employeeDAO.findAll();
        assertNotNull(list);

        for(Employee e :list){
            System.out.println(e.getEmployeeId());
        }
    }

    @Test
    @Transactional
    public void shouldFindEmployeById(){
        Employee e = employeeDAO.findById(USERID);
        assertNotNull(e);
        assertEquals(e.getEmployeeId(),USERID);
    }

    @Test
    @Transactional
    public void shouldDeleteEmployeeFromDB(){
        Employee e = new Employee(USERID,EMPLOYE_FIRST_NAME,EMPLOYE_LAST_NAME);
        employeeDAO.delete(e);
    }
}
