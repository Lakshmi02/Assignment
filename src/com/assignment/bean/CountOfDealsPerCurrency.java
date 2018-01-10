package com.assignment.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table (  name = "count_of_deals_per_currency") @Proxy ( lazy = false)
public class CountOfDealsPerCurrency {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@Column (name = "from_currency_ISO_code")
	private String from_currency_ISO_code;
	
	@Column ( name = "count_of_deals")
	private Integer count_of_deals;

	public CountOfDealsPerCurrency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountOfDealsPerCurrency(String from_currency_ISO_code, Integer count_of_deals) {
		super();
		this.from_currency_ISO_code = from_currency_ISO_code;
		this.count_of_deals = count_of_deals;
	}

	public String getFrom_currency_ISO_code() {
		return from_currency_ISO_code;
	}

	public void setFrom_currency_ISO_code(String from_currency_ISO_code) {
		this.from_currency_ISO_code = from_currency_ISO_code;
	}

	public Integer getCount_of_deals() {
		return count_of_deals;
	}

	public void setCount_of_deals(Integer count_of_deals) {
		this.count_of_deals = count_of_deals;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
