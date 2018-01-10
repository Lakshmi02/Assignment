package com.assignment.dao;

import com.assignment.bean.CountOfDealsPerCurrency;

public interface CountOfDealsDao {

	public void addEntry(CountOfDealsPerCurrency c);

	public void incrementCount(int id);
	
	public int getEntry( String currencyCode);
}
