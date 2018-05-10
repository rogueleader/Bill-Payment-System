package com.bps.dao;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;

import com.bps.dbutil.DbUtil;

public class AdminLoginDAO {
	
	Connection conn = null;
	
	ResultSet rset = null;
	
	ArrayList<String> adetails = new ArrayList<String>();
	
	public ArrayList<String> getAdmin(){
		
		PreparedStatement pst= null;
		try {
			conn=DbUtil.getConnection();
			String q="select user,pass from bps.admin";
			pst=conn.prepareStatement(q);
			rset=pst.executeQuery();
			while(rset.next())
			{
				adetails.add(rset.getString(1));
				adetails.add(rset.getString(2));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			try {
				pst.close();
				rset.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return adetails;
		
		
	}
		
		
	

}
