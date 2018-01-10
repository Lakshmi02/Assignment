package com.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.assignment.bean.CountOfDealsPerCurrency;

@Repository
public class CountOfDealsDaoImpl implements CountOfDealsDao {

	@Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }
	 
	@Override
	public void addEntry(CountOfDealsPerCurrency c) {
		  System.out.println("inside addEntry of CountOfDealsPerCurrency dao");
		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(c);
	}

	@Override
	public void incrementCount(int id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Before File Update");
		CountOfDealsPerCurrency c = (CountOfDealsPerCurrency) session.load(CountOfDealsPerCurrency.class, new Integer(id));
		if(c.getCount_of_deals() == null)
		c.setCount_of_deals(new Integer(1));
		else
		c.setCount_of_deals(c.getCount_of_deals() + 1 );
		session.update(c);
		
	}

	@Override
	public int getEntry(String currencyCode) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <CountOfDealsPerCurrency> list = session.createQuery("from CountOfDealsPerCurrency C where C.from_currency_ISO_code = :currencyCode").setParameter("currencyCode", currencyCode).list();
		if (list.size() > 0) {
		    return list.get(0).getId();
		  }
		  return 0;
	}

}
