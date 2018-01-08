package com.assignment.dao;

import com.assignment.bean.FileImportInfo;

public interface FileDao {

	public int addFile(FileImportInfo file);
	
	public FileImportInfo getFile(String filename);
	
	public FileImportInfo getFile(int file_id);
	
	public void updateInvalidDataCount(int file_id);
	
	public void updateTimeToProcess(int file_id, Long time);
}
