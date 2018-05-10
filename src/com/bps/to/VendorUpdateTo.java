package com.bps.to;

public class VendorUpdateTo
{
	private int		vendorId;
	private String	vendorName;
	private String	vendorType;
	private String	companyRegNo;
	private String	countryId;
	private String	countryName;
	private String	state;
	private String	email;
	private long	contactNo;
	private String	website;
	private String	address;
	private int		employeeCount;
	private int		customerCount;
	private String	yearOfEstablish;
	private String	certificate;
	private String	certIssueDate;
	private String	certValDate;
	
	@Override
	public String toString()
	{
		return "VendorUpdateTo [vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", vendorType=" + vendorType + ", companyRegNo="
				+ companyRegNo + ", countryId=" + countryId + ", countryName="
				+ countryName + ", state=" + state + ", email=" + email
				+ ", contactNo=" + contactNo + ", website=" + website
				+ ", address=" + address + ", employeeCount=" + employeeCount
				+ ", customerCount=" + customerCount + ", yearOfEstablish="
				+ yearOfEstablish + ", certificate=" + certificate
				+ ", certIssueDate=" + certIssueDate + ", certValDate="
				+ certValDate + "]";
	}
	
	public int getVendorId()
	{
		return vendorId;
	}
	
	public void setVendorId(int vendorId)
	{
		this.vendorId = vendorId;
	}
	
	public String getVendorName()
	{
		return vendorName;
	}
	
	public void setVendorName(String vendorName)
	{
		this.vendorName = vendorName;
	}
	
	public String getVendorType()
	{
		return vendorType;
	}
	
	public void setVendorType(String vendorType)
	{
		this.vendorType = vendorType;
	}
	
	public String getCompanyRegNo()
	{
		return companyRegNo;
	}
	
	public void setCompanyRegNo(String companyRegNo)
	{
		this.companyRegNo = companyRegNo;
	}
	
	public String getCountryId()
	{
		return countryId;
	}
	
	public void setCountryId(String countryId)
	{
		this.countryId = countryId;
	}
	
	public String getCountryName()
	{
		return countryName;
	}
	
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public long getContactNo()
	{
		return contactNo;
	}
	
	public void setContactNo(long contactNo)
	{
		this.contactNo = contactNo;
	}
	
	public String getWebsite()
	{
		return website;
	}
	
	public void setWebsite(String website)
	{
		this.website = website;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public int getEmployeeCount()
	{
		return employeeCount;
	}
	
	public void setEmployeeCount(int employeeCount)
	{
		this.employeeCount = employeeCount;
	}
	
	public int getCustomerCount()
	{
		return customerCount;
	}
	
	public void setCustomerCount(int customerCount)
	{
		this.customerCount = customerCount;
	}
	
	public String getYearOfEstablish()
	{
		return yearOfEstablish;
	}
	
	public void setYearOfEstablish(String yearOfEstablish)
	{
		this.yearOfEstablish = yearOfEstablish;
	}
	
	public String getCertificate()
	{
		return certificate;
	}
	
	public void setCertificate(String certificate)
	{
		this.certificate = certificate;
	}
	
	public String getCertIssueDate()
	{
		return certIssueDate;
	}
	
	public void setCertIssueDate(String certIssueDate)
	{
		this.certIssueDate = certIssueDate;
	}
	
	public String getCertValDate()
	{
		return certValDate;
	}
	
	public void setCertValDate(String certValDate)
	{
		this.certValDate = certValDate;
	}
	
}