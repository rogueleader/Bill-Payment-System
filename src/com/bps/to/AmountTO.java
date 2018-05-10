package com.bps.to;

public class AmountTO {
	
	private double amount;
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	private String venName;
	
	public AmountTO(Double amount,String name) {
		this.amount=amount;
		this.venName=name;
	}

}
