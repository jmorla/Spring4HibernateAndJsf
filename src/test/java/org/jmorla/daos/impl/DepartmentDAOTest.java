package org.jmorla.daos.impl;

import org.jmorla.daos.DepartmentDAO;
import org.jmorla.models.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.jmorla.ApplicationTestConfiguration.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DepartmentDAOTest {

    @Autowired private DepartmentDAO departmentDAO;

    @Test
    @Rollback(false)
    @Transactional
    public void shouldSaveDepartmentFromDatabase(){
        departmentDAO.save(new Department(DEPARTMENT_ID,DEPARTMENT_NAME));
    }

    @Test
    @Transactional
    public void shouldUpdateDepartmentFromDatabase(){
        departmentDAO.update(new Department(DEPARTMENT_ID,DEPARTMENT_NAME+"test"));
    }

    @Test
    @Transactional
    public void shouldReturnListOfDepartments(){
        List list = departmentDAO.findAll();
        assertNotNull(list);
    }

    @Test
    @Transactional
    public void shouldReturnDepartmentById(){
        Department dep = departmentDAO.findById(DEPARTMENT_ID);
        assertNotNull(dep);
        assertEquals(dep.getDepartmentId(),DEPARTMENT_ID+0);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void shouldDeleteDepartment(){
        departmentDAO.delete(new Department(DEPARTMENT_ID,DEPARTMENT_NAME));
    }
}
