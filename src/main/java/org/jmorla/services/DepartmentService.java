package org.jmorla.services;

import org.jmorla.models.Department;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
public interface DepartmentService {

    public void addDepartment(Department dep);

    public void updateDepartment(Department dep);

    public void deleteDepartment(Department dep);

    public List<Department> findAllDepartments();

    public Department findDepartmentById(Integer id);
}
