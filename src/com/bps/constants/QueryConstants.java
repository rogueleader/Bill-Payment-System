package com.bps.constants;

public class QueryConstants
{
	
	public static final String	SEARCH_VENDOR					= "select * from bps.vendor where vendorId=?";
	public static final String	UPDATE_VENDOR					= "update bps.vendor set countryName=?,state=?,address=?,contactNo=?,email=?,website=?,employeeCount=?,customerCount=? where vendorId=?";
	public static final String	UPDATE_VENDOR1					= "update bps.vendor set certificate=? where vendorId=?";
	
	public static final String	SEARCH_CUSTOMER					= "select * from bps.customer where customerId=?";
	
	public static final String	UPDATE_CUSTOMER					= "update bps.customer set address=?,contactNo=?,email=?,cardNo=?,balance=? where customerId=?";
	public static final String	CHECK_CUSTOMERID				= "Select customerId from bps.customer";
	public static final String	ENTER_CUSTOMER					= "insert into bps.customer(customerName,countryId,address,contactNo,countryName,state,email,identificationDocument,documemtDetailNumber,regDate,vendorType,cardNo,balance)  values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String	GET_COUNTRY_NAME				= "select distinct countryName from bps.country";
	public static final String	GET_ALL_STATE					= "select  countryId,state from   bps.country  where  countryName=?";
	public static final String	GET_IDENTIFICATIONDOCUMENT_NAME	= "select distinct Identificationdocument,prefixformat from bps.documentdetails";
	public static final String	GET_PREFIXFORMAT				= "select Prefixformat from bps.documentdetails where Identificationdocument=?";
	
	public static final String	GET_VENDOR_NAME					= "select vendorName,vendorType from company where companyRegno=?";
	public static final String	GET_STATE						= "select state from country where countryid=? and countryName=?";
	
	public static final String	GET_REG_NO						= "select distinct companyRegno from company";
	public static final String	REGISTER_VENDOR					= "insert into vendor(companyRegno,countryId,vendorName,vendorType,certificate,certIssueDate,certValDate,yearOfEstablish,countryName,address,state,email,contactNo,website,employeeCount,customerCount) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String	GET_CUSTOMER_ID					= "select customerId from bps.customer where customerId=?";
	public static final String	GET_BALANCE						= " select balance from customer where customerId=?";
	public static final String	UPDATE_BALANCE					= "update customer set balance=? where customerId=?  ";
	public static final String	UPDATE_AMOUNT					= "update amount set amount=? where vendorType=?  ";
	public static final String	GET_CARDNO						= "select cardNo from customer where customerId=? ";
	public static final String	GET_AMOUNT						= "select amount from bps.amount where vendorType=?";
	public static final String	GET_VENDOR_T					= " select distinct(vendorType) from bps.vendor";
	public static final String	GET_VENDOR_N					= "select distinct(vendorName) from bps.vendor where vendorType=?";
	public static final String	GET_VENDOR_ALL					= "select * from vendor";
	public static final String	GET_VENDOR_AMOUNT				= "select a.amount,v.vendorName from vendor v join amount a on v.vendorType=a.vendorType where v.vendorType=?";
	
}
