package org.jmorla.services.impl;

import org.jmorla.daos.DepartmentDAO;
import org.jmorla.models.Department;
import org.jmorla.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired private DepartmentDAO departmentDAO;

    @Transactional
    public void addDepartment(Department dep) {
        departmentDAO.save(dep);
    }

    @Transactional
    public void updateDepartment(Department dep) {
        departmentDAO.update(dep);
    }

    @Transactional
    public void deleteDepartment(Department dep) {
        departmentDAO.delete(dep);
    }

    @Transactional(readOnly = true)
    public List<Department> findAllDepartments() {
        return departmentDAO.findAll();
    }

    @Transactional(readOnly = true)
    public Department findDepartmentById(Integer id) {
        return departmentDAO.findById(id);
    }
}
