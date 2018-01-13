package com.assignment.model;

/*
 * Class from which response object to user is mapped to.
 */
public class ReturnModel {

	private String time_to_process;
	
	private int total_deals_count;
	
	private int invalid_data_count;

	public ReturnModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReturnModel(String time_to_process, int total_deals_count, int invalid_data_count) {
		super();
		this.time_to_process = time_to_process;
		this.total_deals_count = total_deals_count;
		this.invalid_data_count = invalid_data_count;
	}

	public String getTime_to_process() {
		return time_to_process;
	}

	public void setTime_to_process(String time_to_process) {
		this.time_to_process = time_to_process;
	}

	public int getTotal_deals_count() {
		return total_deals_count;
	}

	public void setTotal_deals_count(int total_deals_count) {
		this.total_deals_count = total_deals_count;
	}

	public int getInvalid_data_count() {
		return invalid_data_count;
	}

	public void setInvalid_data_count(int invalid_data_count) {
		this.invalid_data_count = invalid_data_count;
	}
	
	
}
