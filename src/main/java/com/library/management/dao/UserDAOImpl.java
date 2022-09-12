package com.library.management.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.model.Login;

@Repository("employeeDao")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Login findById(String username) {
		Session session = sessionFactory.getCurrentSession();
		Login login = session.byId(Login.class).load(username);
		return login;
	}
	
	@Override
	@Transactional
	public Login findUserByUserName(String username) {
        
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Login> cr = cb.createQuery(Login.class);
        Root <Login> root = cr.from(Login.class);
        cr.select(root);
        Query<Login> query = session.createQuery(cr);
        List<Login> results = query.getResultList();
        return results.get(0);
    }
}
