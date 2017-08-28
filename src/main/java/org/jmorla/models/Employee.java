package org.jmorla.models;

import javax.persistence.*;

/**
 * Created by jmorla on 27/08/17.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name="employee_id")
    public String employeeId;

    @Column(name="first_name",nullable = false)
    public String firstName;

    @Column(name="last_name",nullable = false)
    public String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = true)
    public Department department;

    public Employee(){

    }

    public Employee(String employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String employeeId, String firstName, String lastName, Department department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
