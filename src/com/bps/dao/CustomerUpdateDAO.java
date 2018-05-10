package com.bps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bps.constants.QueryConstants;
import com.bps.dbutil.DbUtil;
import com.bps.exceptions.BusinessException;
import com.bps.to.CustomerUpdateTo;

public class CustomerUpdateDAO
{
	Connection	conn1	= null;
	ResultSet	rset1	= null;
	
	Connection	conn2	= null;
	ResultSet	rset2	= null;
	
	Connection	conn3	= null;
	ResultSet	rset3	= null;
	
	Connection	conn4	= null;
	ResultSet	rset4	= null;
	
	Connection	conn5	= null;
	ResultSet	rset5	= null;
	
	// ArrayList<String> al = new ArrayList<String>();
	
	public boolean searchDetailsdao(int cId) throws BusinessException,
			Exception
	{
		boolean flag = false;
		try
		{
			
			int count = 0;
			conn1 = DbUtil.getConnection();
			
			String q1 = QueryConstants.SEARCH_CUSTOMER;
			PreparedStatement pst1 = conn1.prepareStatement(q1);
			pst1.setInt(1, cId);
			rset1 = pst1.executeQuery();
			
			while (rset1.next())
			{
				count++;
			}
			if (count > 0)
			{
				flag = true;
			}
		}
		catch (NumberFormatException e)
		{
			throw new BusinessException(e);
		}
		catch (SQLException e)
		{
			throw new BusinessException(e);
		}
		
		return flag;
	}
	
	public CustomerUpdateTo displayDetails(int cId) throws Exception,
			BusinessException
	{
		CustomerUpdateTo to = new CustomerUpdateTo();
		
		try
		{
			conn2 = DbUtil.getConnection();
			String q2 = QueryConstants.SEARCH_CUSTOMER;
			PreparedStatement pst2 = conn2.prepareStatement(q2);
			pst2.setInt(1, cId);
			rset2 = pst2.executeQuery();
			
			while (rset2.next())
			{
				to.setCustomerId(rset2.getInt(1));
				
				to.setCustomerName(rset2.getString(2));
				to.setCountryId(rset2.getString(3));
				to.setAddress(rset2.getString(4));
				to.setContactNo(rset2.getLong(5));
				to.setCountryName(rset2.getString(6));
				to.setState(rset2.getString(7));
				to.setEmail(rset2.getString(8));
				to.setIdDoc(rset2.getString(9));
				to.setIdNo(rset2.getString(10));
				to.setRegDate(rset2.getString(11));
				to.setVendorType(rset2.getString(12));
				to.setCardNo(rset2.getLong(13));
				to.setBalance(rset2.getInt(14));
				
			}
			
		}
		
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return to;
	}
	
	public boolean updateCustomer(CustomerUpdateTo to) throws Exception,
			BusinessException
	{
		boolean flag = false;
		
		try
		{
			conn1 = DbUtil.getConnection();
			
			String query = QueryConstants.UPDATE_CUSTOMER;
			PreparedStatement pst2 = conn1.prepareStatement(query);
			
			pst2.setString(1, to.getAddress());
			pst2.setLong(2, to.getContactNo());
			pst2.setString(3, to.getEmail());
			pst2.setLong(4, to.getCardNo());
			pst2.setInt(5, to.getBalance());
			pst2.setInt(6, to.getCustomerId());
			
			int update = pst2.executeUpdate();
			
			if (update > 0)
			{
				flag = true;
			}
		}
		catch (SQLException e)
		{
			throw new Exception(e);
		}
		
		return flag;
	}
	
}
