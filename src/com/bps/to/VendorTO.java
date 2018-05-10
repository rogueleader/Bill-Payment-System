package com.bps.to;

public class VendorTO {
	private String vendorName;
	private String vendorType;

	public VendorTO() {
		// TODO Auto-generated constructor stub
	}

	public VendorTO(String vendorName, String vendorType) {
		super();
		this.vendorName = vendorName;
		this.vendorType = vendorType;
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

}
