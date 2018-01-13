package com.assignment.dao;

import com.assignment.bean.ValidData;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ValidDataDaoImpl implements ValidDataDao {

	@Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	/*
	 *  (non-Javadoc)
	 * @see com.assignment.dao.ValidDataDao#addDeal(com.assignment.bean.ValidData)
	 * Method to insert valid data into database.
	 */
	@Override
	public void addDeal(ValidData data) {
		// TODO Auto-generated method stub
		System.out.println("Inside Valid Data Dao Class");
		Session session = sessionFactory.getCurrentSession();	
		session.persist(data);
		
	}

	
}
