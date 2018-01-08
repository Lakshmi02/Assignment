package com.assignment.model;

import java.util.List;

public class FileModel {

	private String filename;
	
	private List<DataModel> dataModel;

	public FileModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileModel(String filename, List<DataModel> dataModel) {
		super();
		this.filename = filename;
		this.dataModel = dataModel;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<DataModel> getDataModel() {
		return dataModel;
	}

	public void setDataModel(List<DataModel> dataModel) {
		this.dataModel = dataModel;
	}
	
	
}
