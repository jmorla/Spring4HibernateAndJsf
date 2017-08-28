package org.jmorla.daos.impl;

import org.hibernate.SessionFactory;
import org.jmorla.daos.DepartmentDAO;
import org.jmorla.models.Department;
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
public class DepartmentDAOImp implements DepartmentDAO {

    @Autowired private SessionFactory sessionFactory;

    public void save(Department department) {
        sessionFactory.getCurrentSession().save(department);
    }

    public void update(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    public void delete(Department department) {
        sessionFactory.getCurrentSession().delete(department);
    }

    public Department findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Department.class,id);
    }

    public List<Department> findAll() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Department> query = builder.createQuery(Department.class);
        Root<Department> root = query.from(Department.class);
        return sessionFactory.getCurrentSession().createQuery(query).getResultList();
    }
}
