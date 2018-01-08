package com.assignment.dao;

import com.assignment.bean.InvalidData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvalidDataDaoImpl implements InvalidDataDao {

	@Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	 
	@Override
	public void addDeal(InvalidData data) {
		// TODO Auto-generated method stub
		System.out.println("Inside Invalid Data Dao Class");
		Session session = sessionFactory.getCurrentSession();	
		session.persist(data);
		
	}

	
}
