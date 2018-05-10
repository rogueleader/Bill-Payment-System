package com.bps.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

import com.bps.to.CustomerRegistrationTo;
import com.bps.to.StateTO;

import com.bps.constants.ErrorConstants;
import com.bps.dao.CustomerRegistrationDAO;
import com.bps.dao.RegisterVendorDAO;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;



public class CustomerRegistrationBO {
	
	 private List<String> errorList = new ArrayList();
     private boolean errorFlag = false;
	
	public List<String> getCountryList() {
	 CustomerRegistrationDAO customerRegistrationDao=new CustomerRegistrationDAO();
	// System.out.println(customerRegistrationDao.getCountryList());
		return customerRegistrationDao.getCountryList();
		}

		public List<StateTO> getStateList(String countryName)
		throws ApplicationException {
			CustomerRegistrationDAO customerRegistrationDao=new CustomerRegistrationDAO();
		return customerRegistrationDao.getStateList(countryName);
		}
		
		public List<String> getidentificationDocumentList() {
			 CustomerRegistrationDAO customerRegistrationDao=new CustomerRegistrationDAO();
		//	 System.out.println(customerRegistrationDao.getidentificationDocumentList());
				return customerRegistrationDao.getidentificationDocumentList();
				}
		public String getprefixFormat(String identificationDocumentName)
		throws ApplicationException {
			CustomerRegistrationDAO customerRegistrationDao=new CustomerRegistrationDAO();
		//	System.out.println(customerRegistrationDao.getprefixFormat(identificationDocumentName));
		return customerRegistrationDao.getprefixFormat(identificationDocumentName);
		}
		
		public String getStateName(String country_id, String country)
		throws ApplicationException {
	RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
	return registerVendorDao.getStateName(country_id, country);
}

   
   

	public boolean validateCustomer(CustomerRegistrationTo customerRegistrationTo) throws BusinessException,ApplicationException
	{
		String customerName=customerRegistrationTo.getCustomerName();
		String address=customerRegistrationTo.getAddress();
		String contactNumber=customerRegistrationTo.getContactNumber();
		String country=customerRegistrationTo.getCountry();
		String state=customerRegistrationTo.getState();
		String mailId=customerRegistrationTo.getMailId();
		String identificationDocument=customerRegistrationTo.getIdentificationDocument();
		String documemtDetailNumber=customerRegistrationTo.getDocumemtDetailNumber();
		String registrationDate=customerRegistrationTo.getRegistrationDate();
		String typeOfVendor=customerRegistrationTo.getTypeOfVendor();
		String cardNo=customerRegistrationTo.getCardNo();
		String balance=customerRegistrationTo.getBalance();
		
//		if(customerName==null||customerName.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_CUSTOMERNAME);
//		}
//		String custCheck=customerName.replaceAll("[a-zA-Z ]", "");
//		if(!(custCheck==null||custCheck.isEmpty()))
//		{
//			throw new BusinessException(ErrorConstants.INVALID_CUSTOMERNAME);
//		}
//		if(address==null||address.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_ADDRESS);
//		}
//		if(contactNumber==null||contactNumber.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_CONTACTNUMBER);
//		}
//		if(country==null||country.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_COUNTRY);
//		}
//		if(state==null||state.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_STATE);
//		}
//		if(mailId==null||mailId.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_MAILID);
//		}
////		if(!mailId.matches("*@*.com"))
////        {
////			throw new BusinessException(ErrorConstants.INVALID_MAILID);
////			}
//
//		if(identificationDocument==null||identificationDocument.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_IDENTIFICATIONDOCUMENT);
//		}
//		if(documemtDetailNumber==null||documemtDetailNumber.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_DOCUMENTDETAILNUMBER);
//		}
//		if(registrationDate==null||registrationDate.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_REGISTRATIONDATE);
//		}
//		if(typeOfVendor==null||typeOfVendor.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_TYPEOFVENDOR);
//		}
//		if(cardNo==null||cardNo.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_CARDNO);
//		}
//		String cardCheck=cardNo.replaceAll("[0-9]","");
//		
//	     if(cardNo.length()!=16 && cardCheck!=null)
//	     {
//	    	 throw new BusinessException(ErrorConstants.INVALID_CARDNO);
//	     }
//		if(balance==null||balance.isEmpty())
//		{
//			throw new BusinessException(ErrorConstants.EMPTY_BALANCE);
//		}
		 for (int i = 0; i < 12; i++)
         {
          errorList.add("");
                        
         }
		 if (!isValueEmpty(customerName, 0, ErrorConstants.EMPTY_CUSTOMERNAME))
         {
          String str = customerName.replaceAll("[A-Za-z]", "");
          if (str.length() > 0)
           {
            errorFlag = true;
            errorList.set(0, ErrorConstants.INVALID_CUSTOMERNAME);
           }
         }
		 isValueEmpty(address, 1, ErrorConstants.EMPTY_ADDRESS);
		 if (!isValueEmpty(contactNumber, 2, ErrorConstants.EMPTY_CONTACTNUMBER))
         {
          if (contactNumber.length() != 10|| !contactNumber.matches("[1-9]{1}[0-9]{9}"))
           {
               errorList.set(2, ErrorConstants.INVALID_CONTACTNUMBER);
           }
         }
		 if ("-".equals(country))
		 {
			 errorFlag = true;
			 errorList.set(3, ErrorConstants.EMPTY_COUNTRY);
		 }
	     if ("-".equals(state))
	     {
			 errorFlag = true;
			 errorList.set(4, ErrorConstants.EMPTY_STATE);
		 }
		 if (!isValueEmpty(mailId, 5, ErrorConstants.EMPTY_MAILID))
         {
           if (!(mailId.endsWith(".com")&& mailId.indexOf('@') > 0 && mailId.indexOf('@') < mailId.length() - 5))
             {
               errorFlag = true;
               errorList.set(5, ErrorConstants.INVALID_MAILID);
             }
         }
		 if ("-".equals(identificationDocument)) 
		 {
			 errorFlag = true;
			 errorList.set(6, ErrorConstants.EMPTY_IDENTIFICATIONDOCUMENT);
		 }
		 if (!isValueEmpty(documemtDetailNumber, 7, ErrorConstants.EMPTY_DOCUMENTDETAILNUMBER))
		 {
			 if (!documemtDetailNumber.matches("[0-9]"))
             {
               errorList.set(7, ErrorConstants.INVALID_DOCUMENTDETAILNUMBER);
             }
		 }
		 isValueEmpty(registrationDate, 8, ErrorConstants.EMPTY_REGISTRATIONDATE);
		 if ("-".equals(typeOfVendor))
		 {
			 errorFlag = true;
			 errorList.set(9, ErrorConstants.EMPTY_TYPEOFVENDOR);
		 }
		 if (!isValueEmpty(cardNo,10, ErrorConstants.EMPTY_CARDNO))
         {
           if (cardNo.length() != 16|| !cardNo.matches("[0-9]{16}"))
             {
               errorList.set(11, ErrorConstants.INVALID_CARDNO);
             }
         }	 
		 if (!isValueEmpty(balance,11, ErrorConstants.EMPTY_BALANCE))
         {
           if (!balance.matches("[0-9]"))
             {
               errorList.set(11, ErrorConstants.INVALID_BALANCE);
             }
         }
		 
		 if (errorFlag) {
			 BusinessException bExp = new BusinessException();
			 bExp.setErrorList(errorList);
			 throw bExp;
			 }
		return true;	
	}
	  public boolean isValueEmpty(String fieldName, int pos, String errorMessage)
      {
                      boolean error = false;
                      if (fieldName == null || fieldName.isEmpty())
                      {
                                      errorFlag = true;
                                      error = true;
                                      errorList.set(pos, errorMessage);
                      }
                      return error;
      }
		 
         public void customerAdd(CustomerRegistrationTo customerRegistrationTo) throws ApplicationException, BusinessException {
             // TODO Auto-generated method stub
        	 CustomerRegistrationDAO customerRegistrationDao=new CustomerRegistrationDAO();
             //APD.addPilot(userToAP);
        	 
        	 StringTokenizer  st = new StringTokenizer(customerRegistrationTo.getIdentificationDocument(), "-");
        	 customerRegistrationTo.setIdentificationDocument(st.nextToken());
             int result=customerRegistrationDao.addingCustomer(customerRegistrationTo);
             if(result==0)
             {
                   //          System.out.println("bussiness exception");
                             throw new BusinessException(ErrorConstants.INVALID_CUSTOMER_DETAILS);
             }
}


		
	
	
}
