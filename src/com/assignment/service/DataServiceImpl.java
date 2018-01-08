package com.assignment.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.bean.FileImportInfo;
import com.assignment.bean.InvalidData;
import com.assignment.bean.ValidData;
import com.assignment.dao.FileDao;
import com.assignment.dao.ValidDataDao;
import com.assignment.dao.InvalidDataDao;
import com.assignment.model.DataModel;
import com.assignment.model.FileModel;



@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	ValidDataDao validDataDao;

	@Autowired
	InvalidDataDao invalidDataDao;
	
	@Autowired
	FileDao fileDao;
	
	@Transactional
	public Boolean validateFileExists( String filename)
	{
		if(fileDao.getFile(filename) == null)
		return false;
		return true;
	}
	
	
	@Transactional
	public void validateData(DataModel dataModel, int file_id) {
		FileImportInfo file = fileDao.getFile(file_id);
		if(dataModel.getFrom_currency_ISO_code() != null && dataModel.getTo_currency_ISO_code() !=null
				&& dataModel.getDeal_timestamp() != null && dataModel.getDeal_amount() != null) {
			ValidData deal = new ValidData(dataModel.getDeal_unique_id(), dataModel.getFrom_currency_ISO_code(),dataModel.getTo_currency_ISO_code(), dataModel.getDeal_timestamp(),dataModel.getDeal_amount());
			deal.setFile(file);
			System.out.println("Inside ValidData loop");
			validDataDao.addDeal(deal);
		}
		else
		{
			System.out.println("Inside InvalidData loop");
			InvalidData deal = new InvalidData();
			deal.setDeal_unique_id(dataModel.getDeal_unique_id());
			if(dataModel.getFrom_currency_ISO_code() != null) {
				deal.setFrom_currency_ISO_code(dataModel.getFrom_currency_ISO_code());
			}
			if(dataModel.getTo_currency_ISO_code() != null) {
				deal.setTo_currency_ISO_code(dataModel.getTo_currency_ISO_code());
			}
			if(dataModel.getDeal_timestamp() != null) {
				deal.setDeal_timestamp(dataModel.getDeal_timestamp());
			}
			if(dataModel.getDeal_amount() != null) {
				deal.setDeal_amount(dataModel.getDeal_amount());
			}
			deal.setFile(file);
			invalidDataDao.addDeal(deal);
			System.out.println("Before Updating Count");
			fileDao.updateInvalidDataCount(file.getFile_id());
			System.out.println("After Updating Count");
		}
		
	}
	
	@Override
	@Transactional
	public void addData(FileModel file) {
		// TODO Auto-generated method stub
		System.out.println("Inside Add Data Service class");
        long startTime = System.currentTimeMillis();
		String filename = file.getFilename();
		Boolean fileExists = validateFileExists(filename);
		if (!fileExists){
			System.out.println("Inside file doesnt Exist");
			FileImportInfo newFile = new FileImportInfo();
			newFile.setFilename(filename);
			int file_id = fileDao.addFile(newFile);
			System.out.println("Added File in FileImportInfo Table");
			for( int i = 0; i < file.getDataModel().size(); i++)
			{
				System.out.println("Dta Madel " + i);
				validateData(file.getDataModel().get(i), file_id);
			}
	        long endTime = System.currentTimeMillis();
	        System.out.println("Seconds take for execution is:"+(endTime-startTime)/1000);
	        fileDao.updateTimeToProcess(file_id,(endTime-startTime)/1000);
		}
		else
			System.out.println("File Already Exists");
		
	}

}
