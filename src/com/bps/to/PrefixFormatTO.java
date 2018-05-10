package com.bps.to;

public class PrefixFormatTO {
	
	private String identificationDocument;
    private String prefixformat;
	public PrefixFormatTO() {
		super();
	}
	public PrefixFormatTO(String identificationDocument, String prefixformat) {
		super();
		this.identificationDocument = identificationDocument;
		this.prefixformat = prefixformat;
	}
	public String getIdentificationDocument() {
		return identificationDocument;
	}
	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}
	public String getPrefixformat() {
		return prefixformat;
	}
	public void setPrefixformat(String prefixformat) {
		this.prefixformat = prefixformat;
	}
    
    

}
