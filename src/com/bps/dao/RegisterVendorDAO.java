package com.bps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bps.constants.QueryConstants;
import com.bps.dbutil.DbUtil;
import com.bps.exceptions.ApplicationException;
import com.bps.to.StateTO;
import com.bps.to.VendorRegistrationTO;
import com.bps.to.VendorTO;

public class RegisterVendorDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement pstmt;

	public List<String> getCountryList() {
		List<String> countryList = new ArrayList<String>();
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstants.GET_COUNTRY_NAME);
			while (resultSet.next()) {
				String countryName = resultSet.getString("countryName");
				countryList.add(countryName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return countryList;
	}

	public List<String> getRegNoList() {
		List<String> regNoList = new ArrayList<String>();
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstants.GET_REG_NO);
			while (resultSet.next()) {
				String companyRegNo = resultSet.getString("companyRegno");
				regNoList.add(companyRegNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return regNoList;
	}

	private void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public List<StateTO> getStateList(String countryName)
			throws ApplicationException {
		List<StateTO> stateList = new ArrayList<StateTO>();
		try {
			connection = DbUtil.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.GET_ALL_STATE);
			pstmt.setString(1, countryName);
			resultSet = pstmt.executeQuery();
			StateTO stateTo;
			while (resultSet.next()) {

				String countryId = resultSet.getString("countryid");
				String state = resultSet.getString("state");
				stateTo = new StateTO(countryId, state);
				stateList.add(stateTo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				throw new ApplicationException(e);
			}
		}
		return stateList;
	}

	public VendorTO getVendorName(int companyRegno) throws ApplicationException {
		VendorTO vendorTo;
		try {
			connection = DbUtil.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.GET_VENDOR_NAME);
			pstmt.setInt(1, companyRegno);
			// System.out.println(pstmt);

			String vendorName = null, vendorType = null;
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				vendorName = resultSet.getString("vendorName");
				vendorType = resultSet.getString("vendorType");
			}

			// System.out.println("error resultset");
			vendorTo = new VendorTO(vendorName, vendorType);

		} catch (SQLException e) {
		//	System.out.println(e);
			throw new ApplicationException(e);
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				throw new ApplicationException(e);
			}
		}
		return vendorTo;

	}

	public String getStateName(String country_id, String country)
			throws ApplicationException {
		List<StateTO> stateList = new ArrayList<StateTO>();
		String state = null;
		try {
			connection = DbUtil.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.GET_STATE);
			pstmt.setString(1, country_id);
			pstmt.setString(2, country);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				state = resultSet.getString("state");

			}
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				throw new ApplicationException(e);
			}
		}

		return state;
	}

	public void addVendorDetails(VendorRegistrationTO venRegTo)
			throws ApplicationException {
		String companyRegNo = venRegTo.getCompanyRegNo();
		int regNo = Integer.parseInt(companyRegNo);
		String vendorName = venRegTo.getVendorName();
		String vendorType = venRegTo.getVendorType();
		String address = venRegTo.getAddress();
		String country = venRegTo.getCountry();
		String country_id = venRegTo.getCountryId();
		String state = venRegTo.getState();
		String yoe = venRegTo.getYearOfEstablish();
		String certIssueDate = venRegTo.getCertIssueDate();
		String certValDate = venRegTo.getCertValDate();
		String email = venRegTo.getEmail();
		String contactNo = venRegTo.getContactNo();
		Long contact = Long.parseLong(contactNo);
		String website = venRegTo.getWebsite();
		String eCount = venRegTo.getEmployeeCount();
		String cCount = venRegTo.getCustomerCount();
		String certificate = venRegTo.getCertificate();
	//	System.out.println(" certificate issue date : " + certIssueDate);

		try {
			connection = DbUtil.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.REGISTER_VENDOR);
			pstmt.setInt(1, regNo);
			pstmt.setString(2, country_id);
			pstmt.setString(3, vendorName);
			pstmt.setString(4, vendorType);
			pstmt.setString(5, certificate);
			pstmt.setString(6, certIssueDate);
			pstmt.setString(7, certValDate);
			pstmt.setString(8, yoe);
			pstmt.setString(9, country);
			pstmt.setString(10, address);
			pstmt.setString(11, state);
			pstmt.setString(12, email);
			pstmt.setLong(13, contact);
			pstmt.setString(14, website);
			pstmt.setInt(15, Integer.parseInt(eCount));
			pstmt.setInt(16, Integer.parseInt(cCount));
		//	System.out.println(pstmt);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}

	}
}
