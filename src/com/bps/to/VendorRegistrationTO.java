package com.bps.to;

public class VendorRegistrationTO {
	// private String vendorId;
	private String companyRegNo;
	private String countryId;
	private String vendorName;
	private String vendorType;
	private String certificate;
	private String certIssueDate;
	private String certValDate;
	private String yearOfEstablish;
	private String country;
	private String address;
	private String state;
	private String email;
	private String contactNo;
	private String website;
	private String employeeCount;
	private String customerCount;

	public VendorRegistrationTO() {
		// TODO Auto-generated constructor stub
	}

	public VendorRegistrationTO(String companyRegNo, String countryId,
			String vendorName, String vendorType, String certIssueDate,
			String certValDate, String yearOfEstablish, String country,
			String address, String state, String email, String contactNo,
			String website, String employeeCount, String customerCount) {
		super();
		// this.vendorId = vendorId;
		this.companyRegNo = companyRegNo;
		this.countryId = countryId;
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		// this.certificate = certificate;
		this.certIssueDate = certIssueDate;
		this.certValDate = certValDate;
		this.yearOfEstablish = yearOfEstablish;
		this.country = country;
		this.address = address;
		this.state = state;
		this.email = email;
		this.contactNo = contactNo;
		this.website = website;
		this.employeeCount = employeeCount;
		this.customerCount = customerCount;
	}

	// public String getVendorId() {
	// return vendorId;
	// }
	//
	// public void setVendorId(String vendorId) {
	// this.vendorId = vendorId;
	// }

	public String getCompanyRegNo() {
		return companyRegNo;
	}

	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCertIssueDate() {
		return certIssueDate;
	}

	public void setCertIssueDate(String certIssueDate) {
		this.certIssueDate = certIssueDate;
	}

	public String getCertValDate() {
		return certValDate;
	}

	public void setCertValDate(String certValDate) {
		this.certValDate = certValDate;
	}

	public String getYearOfEstablish() {
		return yearOfEstablish;
	}

	public void setYearOfEstablish(String yearOfEstablish) {
		this.yearOfEstablish = yearOfEstablish;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(String customerCount) {
		this.customerCount = customerCount;
	}
}
