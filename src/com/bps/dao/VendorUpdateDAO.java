package com.bps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bps.constants.QueryConstants;
import com.bps.dbutil.DbUtil;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.to.VendorUpdateTo;

public class VendorUpdateDAO {
	Connection conn1 = null;
	ResultSet rset1 = null;

	Connection conn2 = null;
	ResultSet rset2 = null;

	Connection conn3 = null;
	ResultSet rset3 = null;

	Connection conn4 = null;
	ResultSet rset4 = null;

	Connection conn5 = null;
	ResultSet rset5 = null;

	public boolean searchDetailsdao(int vId) throws BusinessException,
			Exception {
		boolean flag = false;
		try {
			int count = 0;
			conn1 = DbUtil.getConnection();
			String q1 = QueryConstants.SEARCH_VENDOR;
			PreparedStatement pst1 = conn1.prepareStatement(q1);
			pst1.setInt(1, vId);

			rset1 = pst1.executeQuery();

			while (rset1.next()) {
				count++;
			}
			if (count > 0) {
				flag = true;
			}
		} catch (NumberFormatException e) {
			throw new BusinessException(e);
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		return flag;
	}

	public VendorUpdateTo displayDetails(int vId) throws Exception,
			BusinessException {
		VendorUpdateTo to = new VendorUpdateTo();

		try {
			conn2 = DbUtil.getConnection();
			String q2 = QueryConstants.SEARCH_VENDOR;
			PreparedStatement pst2 = conn2.prepareStatement(q2);
			pst2.setInt(1, vId);
			rset2 = pst2.executeQuery();
			
			while (rset2.next()) {
				to.setVendorId(rset2.getInt("vendorId"));
				to.setCompanyRegNo(rset2.getString("companyRegNo"));
				to.setCountryId(rset2.getString("countryId"));
				to.setVendorName(rset2.getString("vendorName"));
				to.setVendorType(rset2.getString("vendorType"));
				to.setCertificate(rset2.getString("certificate"));
				to.setCertIssueDate(rset2.getString("certIssueDate"));
				to.setCertValDate(rset2.getString("certValDate"));
				to.setYearOfEstablish(rset2.getString("yearOfEstablish"));
				to.setCountryName(rset2.getString("countryName"));
				to.setAddress(rset2.getString("address"));
				to.setState(rset2.getString("state"));
				to.setEmail(rset2.getString("email"));
				to.setContactNo(rset2.getLong("contactNo"));
				to.setWebsite(rset2.getString("website"));
				to.setEmployeeCount(rset2.getInt("employeeCount"));
				to.setCustomerCount(rset2.getInt("customerCount"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return to;
	}

	public boolean updateVendor(VendorUpdateTo to) throws Exception,
			BusinessException {
		boolean flag = false;
		int update = 0;

		try {
			conn1 = DbUtil.getConnection();
			PreparedStatement pst2 = conn1
					.prepareStatement(QueryConstants.UPDATE_VENDOR);
			pst2.setString(1, to.getCountryName());
			pst2.setString(2, to.getState());
			pst2.setString(3, to.getAddress());
			pst2.setLong(4, to.getContactNo());
			pst2.setString(5, to.getEmail());
			pst2.setString(6, to.getWebsite());
			pst2.setInt(7, to.getEmployeeCount());
			pst2.setInt(8, to.getCustomerCount());
			pst2.setInt(9, to.getVendorId());

			pst2.executeUpdate();
			update = 1;

			if (update > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw new Exception(e);
		}
	//	System.out.println(flag);
		return flag;
	}

	public String certificatecalc(VendorUpdateTo to)
			throws ApplicationException {
		String certificate = to.getCertificate();

		Connection connection = null;
		ResultSet rset = null;
		try {
			connection = DbUtil.getConnection();
			PreparedStatement pst = connection
					.prepareStatement(QueryConstants.UPDATE_VENDOR1);
			pst.setString(1, certificate);
			pst.setInt(2, to.getVendorId());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
		return certificate;
	}
}