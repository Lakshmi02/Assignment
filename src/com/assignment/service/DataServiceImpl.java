package com.assignment.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.bean.CountOfDealsPerCurrency;
import com.assignment.bean.FileImportInfo;
import com.assignment.bean.InvalidData;
import com.assignment.bean.ValidData;
import com.assignment.dao.CountOfDealsDao;
import com.assignment.dao.FileDao;
import com.assignment.dao.ValidDataDao;
import com.assignment.dao.InvalidDataDao;
import com.assignment.model.DataModel;
import com.assignment.model.FileModel;
import com.assignment.model.ReturnModel;



@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	ValidDataDao validDataDao;

	@Autowired
	InvalidDataDao invalidDataDao;
	
	@Autowired
	FileDao fileDao;
	
	@Autowired
	CountOfDealsDao countOfDealsDao;
	
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
			int id = countOfDealsDao.getEntry(dataModel.getFrom_currency_ISO_code());
			if ( id != 0) 
				countOfDealsDao.incrementCount(id);
			else
				countOfDealsDao.addEntry(new CountOfDealsPerCurrency (dataModel.getFrom_currency_ISO_code(), new Integer(1)));
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
		
		fileDao.updateTotalDataCount(file.getFile_id());
	}
	
	@Override
	@Transactional
	public ReturnModel addData(FileModel file) {
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
	        FileImportInfo info = fileDao.getFile(file_id);
	        if (info.getTime_taken_to_process() == null)
	        	info.setTime_taken_to_process("0");
	        if (info.getCount_of_total_deals() == null)
	        	info.setCount_of_total_deals(new Integer(0));
	        if(info.getCount_of_InvalidData() == null)
	        	info.setCount_of_InvalidData(new Integer(0));

	        return new ReturnModel(info.getTime_taken_to_process(),info.getCount_of_total_deals(),info.getCount_of_InvalidData());
		}
		else
			System.out.println("File Already Exists");
		return null;
		
	}

}
