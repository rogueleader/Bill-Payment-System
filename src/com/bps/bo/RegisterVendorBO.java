package com.bps.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import com.bps.constants.ErrorConstants;
import com.bps.dao.RegisterVendorDAO;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.to.StateTO;
import com.bps.to.VendorRegistrationTO;
import com.bps.to.VendorTO;

public class RegisterVendorBO {
	private static final String EMPTY_ADDRESS = null;
	List<String> errorList = new ArrayList<String>();
	boolean errorFlag = false;

	public List<String> getCountryList() {
		RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
		return registerVendorDao.getCountryList();
	}

	public List<String> getRegNoList() {
		RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
		return registerVendorDao.getRegNoList();
	}

	public List<StateTO> getStateList(String countryName)
			throws ApplicationException {
		RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
		return registerVendorDao.getStateList(countryName);
	}

	public VendorTO getVendorName(int companyRegno) throws ApplicationException {
		RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
		return registerVendorDao.getVendorName(companyRegno);
	}

	public String getStateName(String country_id, String country)
			throws ApplicationException {
		RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
		return registerVendorDao.getStateName(country_id, country);
	}

	public boolean validateVendor(VendorRegistrationTO vendorRegistrationTo)
			throws BusinessException {
		String companyRegNo = vendorRegistrationTo.getCompanyRegNo();
		String vendorName = vendorRegistrationTo.getVendorName();
		String vendorType = vendorRegistrationTo.getVendorType();
		String address = vendorRegistrationTo.getAddress();
		String country = vendorRegistrationTo.getCountry();
		String state = vendorRegistrationTo.getState();
		String contactNo = vendorRegistrationTo.getContactNo();

		String email = vendorRegistrationTo.getEmail();
		String website = vendorRegistrationTo.getWebsite();
		// String certIssueDate = vendorRegistrationTo.getCertIssueDate();
		// String certValDate = vendorRegistrationTo.getCertValDate();
		String employee_count = vendorRegistrationTo.getEmployeeCount();
		String cCount = vendorRegistrationTo.getCustomerCount();
		String yearOfEstablishment = vendorRegistrationTo.getYearOfEstablish();
		// System.out.println("ggggggg" + yearOfEstablishment);

		/*
		 * if (vendorName == null || vendorName.isEmpty()) { throw new
		 * BusinessException(ErrorConstants.EMPTY_VENDOR_NAME); } boolean valid
		 * = false; char ch; for (int i = 0; i < vendorName.length(); i++) { ch
		 * = vendorName.charAt(i); if (Character.isLetter(ch) || ch == ' ') {
		 * valid = true; } if (valid == false) { throw new
		 * BusinessException(ErrorConstants.VALID_VENDOR_NAME); }
		 * 
		 * } boolean m = vendorName.substring(0, 1).matches("[A-Z]"); if (m ==
		 * false) { throw new
		 * BusinessException(ErrorConstants.CAPT_VENDOR_NAME); } if (email ==
		 * null || email.isEmpty()) { throw new
		 * BusinessException(ErrorConstants.EMPTY_EMAIL); } String EMAIL_REGEX =
		 * "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; boolean b =
		 * email.matches(EMAIL_REGEX); if (b == false) { throw new
		 * BusinessException(ErrorConstants.INVALID_EMAIL); }
		 * 
		 * boolean valid_no = contactNo.matches("[0-9]{10}"); if (valid_no ==
		 * false) { throw new
		 * BusinessException(ErrorConstants.INVALID_CONTACT_NO); }
		 * StringTokenizer st = new StringTokenizer(website, "."); String token1
		 * = st.nextToken();
		 * 
		 * @SuppressWarnings("unused") String token2 = st.nextToken(); String
		 * token3 = st.nextToken(); if (website == null || website.isEmpty()) {
		 * throw new BusinessException(ErrorConstants.EMPTY_WEBSITE); } boolean
		 * web = false; if (token1.equals("www")) { if (token3.equals("com")) {
		 * web = true; } } if (web == false) { throw new
		 * BusinessException(ErrorConstants.INVALID_WEB); } // if (certValDate
		 * == null || certValDate.isEmpty()) { // throw new
		 * BusinessException(ErrorConstants.EMPTY_VALDATE); // } //
		 * SimpleDateFormat sdf = new //
		 * SimpleDateFormat("MMM-dd-yyyy hh:mm:ss a"); // Date date = new
		 * Date(); // Date d1; // Date d2; // String d; // try { // d1 =
		 * sdf.parse(certValDate); // d = sdf.format(date); // d2 =
		 * sdf.parse(d); // if (d1.compareTo(d2) < 0) { // throw new
		 * BusinessException(ErrorConstants.INVALID_VAL_DATE); // } // } catch
		 * (ParseException e) { // // TODO Auto-generated catch block // }
		 * 
		 * if (yearOfEstablishment == null || yearOfEstablishment.isEmpty()) {
		 * throw new BusinessException(ErrorConstants.EMPTY_YOE); } if
		 * (!yearOfEstablishment.matches("[0-9]{4}")) { throw new
		 * BusinessException(ErrorConstants.INVALID_YOE); }
		 */

		for (int i = 0; i < 12; i++) {
			errorList.add("");

		}

		if (companyRegNo == null || "-".matches(companyRegNo)) {

			errorFlag = true;
			errorList.set(0, ErrorConstants.EMPTY_REGNO);

		}

		isValueEmpty(vendorName, 1, ErrorConstants.EMPTY_VENDOR_NAME);
		isValueEmpty(vendorType, 2, ErrorConstants.EMPTY_TYPE);
		isValueEmpty(address, 3, ErrorConstants.EMPTY_ADDRESS);
		if ("-".equals(country)) {
			errorFlag = true;
			errorList.set(4, ErrorConstants.EMPTY_COUNTRY);
		}
		if (state == null || "-".equals(state)) {
			errorFlag = true;
			errorList.set(5, ErrorConstants.EMPTY_STATE);
		}
		if (!isValueEmpty(email, 6, ErrorConstants.EMPTY_EMAIL)) {
			String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			if (!email.matches(EMAIL_REGEX)) {
				errorFlag = true;
				errorList.set(6, ErrorConstants.INVALID_EMAIL);
			}
		}
		if (!isValueEmpty(contactNo, 7, ErrorConstants.EMPTY_CONTACT)) {
			if (contactNo.length() != 10
					|| !contactNo.matches("[1-9]{1}[0-9]{9}")) {
				errorFlag = true;
				errorList.set(7, ErrorConstants.INVALID_CONTACT_NO);
			}
		}
		if (!isValueEmpty(website, 8, ErrorConstants.EMPTY_WEBSITE)) {
			StringTokenizer st = new StringTokenizer(website, ".");
			String token1 = st.nextToken();
			@SuppressWarnings("unused")
			String token2 = st.nextToken();
			String token3 = st.nextToken();
			boolean web = false;
			if (token1.equals("www")) {
				if (token3.equals("com")) {
					web = true;
				}
			}
			if (web == false) {
				errorFlag = true;
				errorList.set(8, ErrorConstants.INVALID_WEB);
			}

		}

		if (!isValueEmpty(employee_count, 9, ErrorConstants.EMPTY_ECOUNT)) {
			try{
				int eCount=Integer.parseInt(employee_count);
			}catch(NumberFormatException ex){
				errorFlag = true;
				errorList.set(9, ErrorConstants.INVALID_ECOUNT);
			}
		}

		if (!isValueEmpty(cCount, 10, ErrorConstants.EMPTY_CCOUNT)) {
			try{
				int custCount=Integer.parseInt(cCount);
			}catch(NumberFormatException ex){
				errorFlag = true;
				errorList.set(10, ErrorConstants.INVALID_CCOUNT);
			}
		}

		if (!isValueEmpty(yearOfEstablishment, 11, ErrorConstants.EMPTY_YOE)) {
			if (!yearOfEstablishment.matches("[0-9]{4}")) {
				errorFlag = true;
				errorList.set(11, ErrorConstants.INVALID_YOE);
			}
		}

		if (errorFlag) {
			BusinessException bExp = new BusinessException();
			bExp.setErrorList(errorList);
			throw bExp;
		}
		return true;

	}

	public boolean isValueEmpty(String fieldName, int pos, String errorMessage) {
		boolean error = false;
		if (fieldName == null || fieldName.isEmpty()) {
			errorFlag = true;
			error = true;
			errorList.set(pos, errorMessage);
		}
		return error;
	}

	public void addVendorDetails(VendorRegistrationTO venRegTo)
			throws ApplicationException {
		String eCount = venRegTo.getEmployeeCount();
		String yoe = venRegTo.getYearOfEstablish();
		String certificate = "";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int emp_count = Integer.parseInt(eCount);
		int yos = year - Integer.parseInt(yoe);
		if (yos >= 1 && yos < 5) {
			if (emp_count >= 30 && emp_count < 50) {
				certificate += "A+";
			}
		} else if (yos == 5) {
			if (emp_count >= 30 && emp_count < 50) {
				certificate += "A+";
			} else if (emp_count >= 50 && emp_count < 75) {
				certificate += "B+";
			}
		} else if (yos > 5 && yos < 10) {

			if (emp_count >= 50 && emp_count < 75) {
				certificate += "B+";
			}
		} else if (yos == 10) {
			if (emp_count >= 50 && emp_count < 75) {
				certificate += "B+";
			} else if (emp_count >= 75 && emp_count < 100) {
				certificate += "C+";
			}
		} else if (yos > 10 && yos < 15) {
			if (emp_count >= 75 && emp_count < 100) {
				certificate += "C+";
			}
		} else if (yos == 15) {
			if (emp_count >= 75 && emp_count < 100) {
				certificate += "C+";
			} else if (emp_count >= 100 && emp_count < 200) {
				certificate += "D+";
			}
		} else if (yos > 15 && yos < 25) {
			if (emp_count >= 100 && emp_count < 200) {
				certificate += "D+";
			}
		} else if (yos == 25) {
			if (emp_count >= 100 && emp_count < 200) {
				certificate += "D+";
			} else if (emp_count >= 200 && emp_count < 500) {
				certificate += "E+";
			}
		} else if (yos > 25 && yos <= 50) {
			if (emp_count >= 200 && emp_count < 500) {
				certificate += "E+";
			}
		} else if (yos > 50) {
			if (emp_count > 500) {
				certificate += "F+";
			}
		}

		venRegTo.setCertificate(certificate);
		if (venRegTo.getCertificate() == null) {
			venRegTo.setCertIssueDate(null);
		}
		RegisterVendorDAO registerVendorDao = new RegisterVendorDAO();
		registerVendorDao.addVendorDetails(venRegTo);
	}
}
