package com.bps.to;

public class CustomerRegistrationTo {

	//private String customerId;
	private  String customerName;
	private String address;
	private String contactNumber;
	private String country;
	private String countryId;
	private String state;
	private String mailId;
	private String identificationDocument;
	private String prefixFormat;
	private String documemtDetailNumber;
	private String registrationDate;
	private String typeOfVendor;
	private String cardNo;
	private String balance;
	
	public CustomerRegistrationTo() {
		super();
		
		
	}

	public CustomerRegistrationTo(String customerName, String address,
			String contactNumber, String country,String countryId, String state, String mailId,
			String identificationDocument, String documemtDetailNumber,
			String registrationDate, String typeOfVendor, String cardNo,
			String balance) {
		super();
		//this.customerId=customerId;
		this.customerName = customerName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.country = country;
		this.countryId = countryId;
		this.state = state;
		this.mailId = mailId;
		this.identificationDocument = identificationDocument;
		this.documemtDetailNumber = documemtDetailNumber;
		this.registrationDate = registrationDate;
		this.typeOfVendor = typeOfVendor;
		this.cardNo = cardNo;
		this.balance = balance;
	}

	
//	public String getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(String customerId) {
//		this.customerId = customerId;
//	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getIdentificationDocument() {
		return identificationDocument;
	}

	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}
	

	public String getPrefixFormat() {
		return prefixFormat;
	}

	public void setPrefixFormat(String prefixFormat) {
		this.prefixFormat = prefixFormat;
	}

	public String getDocumemtDetailNumber() {
		return documemtDetailNumber;
	}

	public void setDocumemtDetailNumber(String documemtDetailNumber) {
		this.documemtDetailNumber = documemtDetailNumber;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getTypeOfVendor() {
		return typeOfVendor;
	}

	public void setTypeOfVendor(String typeOfVendor) {
		this.typeOfVendor = typeOfVendor;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CustomerRegistrationTo [ customerName=" + customerName + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", country=" + country
				+ ", state=" + state + ", mailId=" + mailId
				+ ", identificationDocument=" + identificationDocument
				+ ", documemtDetailNumber=" + documemtDetailNumber
				+ ", registrationDate=" + registrationDate + ", typeOfVendor="
				+ typeOfVendor + ", cardNo=" + cardNo + ", balance=" + balance
				+ "]";
	}
	
	
}
