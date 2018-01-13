package com.assignment.model;


public class DataModel {


	private Integer deal_unique_id;

	private String from_currency_ISO_code;

	private String to_currency_ISO_code;
	
	private String deal_timestamp;
	
	private Integer deal_amount;

	public DataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataModel(Integer deal_unique_id, String from_currency_ISO_code, String to_currency_ISO_code,
			String deal_timestamp, Integer deal_amount) {
		super();
		this.deal_unique_id = deal_unique_id;
		this.from_currency_ISO_code = from_currency_ISO_code;
		this.to_currency_ISO_code = to_currency_ISO_code;
		this.deal_timestamp = deal_timestamp;
		this.deal_amount = deal_amount;
	}

	public Integer getDeal_unique_id() {
		return deal_unique_id;
	}

	public void setDeal_unique_id(Integer deal_unique_id) {
		this.deal_unique_id = deal_unique_id;
	}

	public String getFrom_currency_ISO_code() {
		return from_currency_ISO_code;
	}

	public void setFrom_currency_ISO_code(String from_currency_ISO_code) {
		this.from_currency_ISO_code = from_currency_ISO_code;
	}

	public String getTo_currency_ISO_code() {
		return to_currency_ISO_code;
	}

	public void setTo_currency_ISO_code(String to_currency_ISO_code) {
		this.to_currency_ISO_code = to_currency_ISO_code;
	}

	public String getDeal_timestamp() {
		return deal_timestamp;
	}

	public void setDeal_timestamp(String deal_timestamp) {
		this.deal_timestamp = deal_timestamp;
	}

	public Integer getDeal_amount() {
		return deal_amount;
	}

	public void setDeal_amount(Integer deal_amount) {
		this.deal_amount = deal_amount;
	}
	
	
}
