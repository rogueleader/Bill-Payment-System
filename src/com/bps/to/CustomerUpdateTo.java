package com.bps.to;

import java.util.Date;

public class CustomerUpdateTo {
	private int customerId;
	private String customerName;
	private String vendorType;
	private String countryName;
	private String countryId;
	private String state;
	private String email;
	private long contactNo;
	private String address;
	private long cardNo;
	private int balance;
	private String idNo;
	private String idDoc;
	private String regDate;
	@Override
	public String toString() {
		return "CustomerUpdateTo [customerId=" + customerId + ", customerName="
				+ customerName + ", vendorType=" + vendorType
				+ ", countryName=" + countryName + ", countryId=" + countryId
				+ ", state=" + state + ", email=" + email + ", contactNo="
				+ contactNo + ", address=" + address + ", cardNo=" + cardNo
				+ ", balance=" + balance + ", idNo=" + idNo + ", IdDoc="
				+ idDoc + ", regDate=" + regDate + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	

}