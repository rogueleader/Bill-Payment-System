package com.bps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bps.constants.QueryConstants;
import com.bps.dbutil.DbUtil;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.exceptions.DatabaseOperationException;
import com.bps.to.AmountTO;
import com.bps.to.BillPaymentTO;
import com.bps.to.VenTO;
import com.mysql.jdbc.PreparedStatement;

@SuppressWarnings("unused")
public class BillPaymentDAO {

	private String pendingAmount;
	java.sql.Connection conn = null;
	private List<String> vendorType = new ArrayList<String>();
	private List<String> vendorName = new ArrayList<String>();

	public int customerExists(int cid) throws ApplicationException,
			DatabaseOperationException {
		// System.out.println(cid);
		int response = 2;
		java.sql.PreparedStatement statement = null;
		ResultSet rset = null;

		try {
			conn = DbUtil.getConnection();
			String query = QueryConstants.GET_CUSTOMER_ID ;
			statement = conn.prepareStatement(query);
			statement.setString(1, String.valueOf(cid));
			rset = statement.executeQuery();
			while (rset.next()) {
				response = 1;
				break;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseOperationException("SQL Exception happened", e);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				statement.close();
				rset.close();
				conn.close();

			} catch (SQLException e) {
				throw new DatabaseOperationException("SQL Exception happened",
						e);
			}

		}

		return response;
	}

	public void add(BillPaymentTO bp) throws ApplicationException// a function
																	// to modify
																	// the db
																	// value of
																	// the
	// pending amount is to be implemented
	{
		java.sql.PreparedStatement pst = null;
		java.sql.PreparedStatement pst2 = null;
		ResultSet rset = null;

		Double amountpaid = bp.getAmountToPayy();
		Double balance = 0.0;
		try {
			conn = DbUtil.getConnection();
			String query = QueryConstants.GET_BALANCE;
			pst = conn.prepareStatement(query);
			pst.setInt(1, bp.getCustomerID());
			rset = pst.executeQuery(); // retrieves the current balance of the
										// desired cusomter

			while (rset.next()) {
				balance = Double.parseDouble(rset.getString(1));

			}

			Double newbalance = balance - amountpaid;

			String query_up = QueryConstants.UPDATE_BALANCE;
			pst = conn.prepareStatement(query_up);
			pst.setString(1, newbalance.toString());
			pst.setString(2, bp.getCustomerid());
			pst.executeUpdate(); // updates the customer table with the new
									// reduced balance after payment

			// also we have to update the vendor_amount table

			int newamount = (int) (bp.getPendingAmountt() - amountpaid);
			// System.out.println(newamount+bp.getVendorType());
			String query_upa = QueryConstants.UPDATE_AMOUNT;
			pst2 = conn.prepareStatement(query_upa);
			pst2.setInt(1, newamount);
			pst2.setString(2, bp.getVendorType());
			pst2.executeUpdate();

		}

		catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				pst.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}

		}

	}

	public boolean validateCC(String cardNumber, int cid)
			throws BusinessException {
		try {
			Connection conn = DbUtil.getConnection();
			java.sql.PreparedStatement p = conn
					.prepareStatement(QueryConstants.GET_CARDNO);
			p.setString(1, String.valueOf(cid));
			ResultSet rs = p.executeQuery();
			while (rs.next()) {

				String s = rs.getString(1);
				if (s.equalsIgnoreCase(cardNumber)) {
					return true;
				} else {
					throw new BusinessException("Invalid Card Number");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void setPendingAmount(String type) {
		if (type != null) {
			try {
				Connection conn = DbUtil.getConnection();
				java.sql.PreparedStatement pst = conn
						.prepareStatement(QueryConstants.GET_AMOUNT);
				pst.setString(1, type);
				ResultSet rset = pst.executeQuery();
				while (rset.next()) {
					pendingAmount = String.valueOf(rset.getInt(1));
				}
				// System.out.println(pendingAmount);
			} catch (SQLException e) {
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public String getPendingAmount() {

		return pendingAmount;

	}

	public void setVendorType() {
		try {

			conn = DbUtil.getConnection();
			java.sql.PreparedStatement pst = conn
					.prepareStatement(QueryConstants.GET_VENDOR_T);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				vendorType.add(rs.getString(1));

			}
			// System.out.println(vendorType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}

	}

	public List<String> getVendorType() {
		return vendorType;
	}

	public List<String> getVendorName() {
		return vendorName;
	}

	public void setVendorName(String VendorType) {
		if (VendorType != null) {
			try {
				conn = DbUtil.getConnection();
				java.sql.PreparedStatement pst = conn
						.prepareStatement(QueryConstants.GET_VENDOR_N);

				pst.setString(1, VendorType);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					vendorName.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block

			}
		}
	}

	public List<VenTO> getAll() throws BusinessException,
			DatabaseOperationException {

		List<VenTO> bpList = new ArrayList<VenTO>();

		try {
			Connection conn = DbUtil.getConnection();
			java.sql.PreparedStatement pst = conn
					.prepareStatement(QueryConstants.GET_VENDOR_ALL);
			ResultSet rs = pst.executeQuery();
			VenTO vTO;
			while (rs.next()) {

				String ven_type = rs.getString("vendorType");

				vTO = new VenTO(ven_type);
				bpList.add(vTO);
			}

		} catch (SQLException e) {
			throw new DatabaseOperationException(e);
		} /*finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DatabaseOperationException(e);
			}
		}*/
		return bpList;

	}

	public List<AmountTO> getAmount(String venType) throws SQLException {
		AmountTO aTO;
		List<AmountTO> amountList = new ArrayList<AmountTO>();
		Connection conn=null;
		conn = DbUtil.getConnection();
	//	System.out.println("inside dao"+venType);
		java.sql.PreparedStatement pstmt = conn
				.prepareStatement(QueryConstants.GET_VENDOR_AMOUNT);
		pstmt.setString(1, venType);
	//	System.out.println(pstmt);
		ResultSet resultSet = pstmt.executeQuery();
		while (resultSet.next()) {
			Double Amount = (double) resultSet.getInt("amount");
			String ven_name = resultSet.getString("vendorName");

			aTO = new AmountTO(Amount,ven_name);
			amountList.add(aTO);
		}
		return amountList;
	}
}
