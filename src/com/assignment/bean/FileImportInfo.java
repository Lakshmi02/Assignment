package com.assignment.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table ( name = "FileImportInfo") @Proxy ( lazy = false)
public class FileImportInfo {

	@Column ( name = "file_id")
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Integer file_id;
	
	@Column( name = "filename")
	private String filename;
	
	@Column( name = "time_taken_to_process")
	private String time_taken_to_process;
	
	@Column( name = "count_of_InvalidData")
	private Integer count_of_InvalidData;

	@Column ( name = "count_of_total_deals")
	private Integer count_of_total_deals;
	
	 @JsonIgnore
	 @OneToMany(cascade=CascadeType.ALL, mappedBy="file", fetch = FetchType.EAGER)
	 private List<ValidData> validData = new ArrayList<ValidData>(0);
	 
	 @JsonIgnore
	 @OneToMany(cascade=CascadeType.ALL, mappedBy="file", fetch = FetchType.EAGER)
	 private List<InvalidData> invalidData = new ArrayList<InvalidData>(0);
	 
	public FileImportInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileImportInfo(Integer file_id, String filename, String time_taken_to_process,
			Integer count_of_InvalidData, Integer count_of_total_deals) {
		super();
		this.file_id = file_id;
		this.filename = filename;
		this.time_taken_to_process = time_taken_to_process;
		this.count_of_InvalidData = count_of_InvalidData;
		this.count_of_total_deals = count_of_total_deals;
	}

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTime_taken_to_process() {
		return time_taken_to_process;
	}

	public void setTime_taken_to_process(String time_taken_to_process) {
		this.time_taken_to_process = time_taken_to_process;
	}

	public Integer getCount_of_InvalidData() {
		return count_of_InvalidData;
	}

	public void setCount_of_InvalidData(Integer count_of_InvalidData) {
		this.count_of_InvalidData = count_of_InvalidData;
	}

	public Integer getCount_of_total_deals() {
		return count_of_total_deals;
	}

	public void setCount_of_total_deals(Integer count_of_total_deals) {
		this.count_of_total_deals = count_of_total_deals;
	}
	
	
	
}
