package com.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment.bean.FileImportInfo;

@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setSessionFactory(SessionFactory sf) {
	  this.sessionFactory = sf;
	 }

	@Override
	public int addFile(FileImportInfo file) {
		// TODO Auto-generated method stub
		  System.out.println("inside addFileInfo dao");
		  Session session = this.sessionFactory.getCurrentSession();
		  session.persist(file);
		  session.flush();
		  return file.getFile_id();
		
	}

	@Override
	public FileImportInfo getFile(String filename) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <FileImportInfo> list = session.createQuery("from FileImportInfo F where F.filename = :filename").setParameter("filename", filename).list();
		if (list.size() > 0) {
		    return list.get(0);
		  }
		  return null;
	}
	 

	@Override
	public FileImportInfo getFile(int file_id) {
		Session session = sessionFactory.getCurrentSession();
		FileImportInfo file = (FileImportInfo) session.load(FileImportInfo.class, new Integer(file_id));
		return file;
	}
	 

	@Override
	public void updateInvalidDataCount(int file_id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Before File Update");
		FileImportInfo file = (FileImportInfo) session.load(FileImportInfo.class, new Integer(file_id));
		System.out.println("The new count is" + file.getCount_of_InvalidData() + 1 );
		if(file.getCount_of_InvalidData() == null)
		file.setCount_of_InvalidData(new Integer(0));
		file.setCount_of_InvalidData(file.getCount_of_InvalidData() + 1 );
		session.update(file);
	}
	
	@Override
	public void updateTotalDataCount(int file_id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Before File Update");
		FileImportInfo file = (FileImportInfo) session.load(FileImportInfo.class, new Integer(file_id));
		System.out.println("The new count is" + file.getCount_of_total_deals() + 1 );
		if(file.getCount_of_total_deals() == null)
		file.setCount_of_total_deals(new Integer(0));
		file.setCount_of_total_deals(file.getCount_of_total_deals() + 1 );
		session.update(file);
	}
	
	@Override
	public void updateTimeToProcess(int file_id, Long time) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Before File Update");
		FileImportInfo file = (FileImportInfo) session.load(FileImportInfo.class, new Integer(file_id));
		file.setTime_taken_to_process(time.toString());
		session.update(file);
	}
	
}
