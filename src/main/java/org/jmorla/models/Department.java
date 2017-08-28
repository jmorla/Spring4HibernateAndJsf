package org.jmorla.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jmorla on 27/08/17.
 */
@Entity
@Table(name="departments")
public class Department implements Serializable{

    @Id
    @Column(name = "department_id")
    public int departmentId;

    @Column(name = "department_name",nullable = false,unique = true)
    public String departmentName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    public Set<Employee> employees = new HashSet<Employee>(0);

    public Department() {
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
