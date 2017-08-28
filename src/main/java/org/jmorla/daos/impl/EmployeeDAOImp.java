package org.jmorla.daos.impl;

import org.hibernate.SessionFactory;
import org.jmorla.daos.EmployeeDAO;
import org.jmorla.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
@Repository
public class EmployeeDAOImp implements EmployeeDAO {

    @Autowired public SessionFactory sessionFactory;

    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public void update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    public void delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public Employee findById(String s) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.where(builder.equal(root.get("employeeId"),s));
        Employee emp = sessionFactory.getCurrentSession().createQuery(query).uniqueResult();

        return emp;
    }

    public List<Employee> findAll() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        List<Employee> emp = sessionFactory.getCurrentSession().createQuery(query).list();

        return emp;
    }
}
