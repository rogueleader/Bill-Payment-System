package com.bps.to;

public class VenTO {
	private String ventype;
	private String venname;

	public VenTO(String type)
	{
	this.ventype=type;
	//this.venname=name;
	}
	public String getVentype() {
		return ventype;
	}
	public void setVentype(String ventype) {
		this.ventype = ventype;
	}
	public String getVenname() {
		return venname;
	}
	public void setVenname(String venname) {
		this.venname = venname;
	}
	

}
