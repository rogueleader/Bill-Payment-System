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
import com.bps.to.CustomerRegistrationTo;
import com.bps.to.StateTO;

public class CustomerRegistrationDAO {

	private Connection connection;
	private PreparedStatement pstmt1;
	private Statement statement;
	private ResultSet resultSet;
	
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
		//System.out.println(countryList);
		return countryList;
		}

		

		public List<StateTO> getStateList(String countryName)
		throws ApplicationException {
		List<StateTO> stateList = new ArrayList<StateTO>();
		try {
		connection = DbUtil.getConnection();
		pstmt1 = connection.prepareStatement(QueryConstants.GET_ALL_STATE);
		pstmt1.setString(1, countryName);
		resultSet = pstmt1.executeQuery();
		StateTO stateTo;
		while (resultSet.next()) {

		String countryId = resultSet.getString("countryId");
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
	//	System.out.println(stateList);
		return stateList;
		}

		public List<String> getidentificationDocumentList() {
			List<String> identificationDocumentList = new ArrayList<String>();
			try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstants.GET_IDENTIFICATIONDOCUMENT_NAME);
			while (resultSet.next()) {
			String identificationDocumentName = resultSet.getString("identificationDocument");
			String  prefixFormat = resultSet.getString("prefixFormat");
			identificationDocumentList.add(identificationDocumentName+"-"+prefixFormat);
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
			//System.out.println(countryList);
			return identificationDocumentList;
			}
		
		public String getprefixFormat(String identificationDocumentName)
		throws ApplicationException {
		
		String prefixFormat = null;
		try {
		connection = DbUtil.getConnection();
		pstmt1 = connection.prepareStatement(QueryConstants.GET_PREFIXFORMAT);
		pstmt1.setString(1, identificationDocumentName);
		resultSet = pstmt1.executeQuery();
		//PrefixFormatTO prefixFormatTO ;
		while (resultSet.next()) {

		
	 prefixFormat = resultSet.getString("prefixFormat");
		
		
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
	//	System.out.println(prefixFormat);
		return prefixFormat;
		}

		public String getStateName(String country_id, String country)
		throws ApplicationException {
	List<StateTO> stateList = new ArrayList<StateTO>();
	String state = null;
	try {
		connection = DbUtil.getConnection();
		pstmt1 = connection.prepareStatement(QueryConstants.GET_STATE);
		pstmt1.setString(1, country_id);
		pstmt1.setString(2, country);
		resultSet = pstmt1.executeQuery();
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
	
//	public int generateCustomerId(int uniqNumber) throws ApplicationException
//	{
//	try {
//		connection=DbUtil.getConnection();
//		pstmt1=connection.prepareStatement(QueryConstant.CHECK_CUSTOMERID);
//		resultSet=pstmt1.executeQuery();
//		while(resultSet.next())
//        {
//                        uniqNumber++;
//        }
//		
//	} catch (SQLException e) {
//		throw new ApplicationException(e);
//	}
//	finally {
//        try {
//                        closeConnection();
//        } catch (SQLException e) {
//                        //System.out.println("application exception");
//                        throw new ApplicationException(e);
//
//          }
//          }
//	return uniqNumber;	
//	}
	
	public int addingCustomer(CustomerRegistrationTo customerRegistrationTo) throws ApplicationException
	{
		  int result = 1;
	//	String customerId=customerRegistrationTo.getCustomerId();
		String customerName=customerRegistrationTo.getCustomerName();
		String address=customerRegistrationTo.getAddress();
		String contactNumber=customerRegistrationTo.getContactNumber();
		String country=customerRegistrationTo.getCountry();
		String country_id = customerRegistrationTo.getCountryId();
		String state = customerRegistrationTo.getState();
		String mailId=customerRegistrationTo.getMailId();
		String identificationDocument=customerRegistrationTo.getIdentificationDocument();
		//String prefix=customerRegistrationTo.getPrefixFormat();
		String documemtDetailNumber=customerRegistrationTo.getDocumemtDetailNumber();
		String registrationDate=customerRegistrationTo.getRegistrationDate();
		String typeOfVendor=customerRegistrationTo.getTypeOfVendor();
		String cardNo=customerRegistrationTo.getCardNo();
		String balance=customerRegistrationTo.getBalance();
		
		try {
			connection=DbUtil.getConnection();
			 pstmt1 = connection.prepareStatement(QueryConstants.ENTER_CUSTOMER);
			 //int cId=Integer.parseInt("125");
			// pstmt1.setInt(1, cId);
			 pstmt1.setString(1,customerName );
			 pstmt1.setString(2,country_id);
			 pstmt1.setString(3,address );
			 pstmt1.setString(4,contactNumber);
			 pstmt1.setString(5,country);
			 pstmt1.setString(6,state);
			 pstmt1.setString(7,mailId);
			 pstmt1.setString(8,identificationDocument);
			 pstmt1.setString(9,documemtDetailNumber);
			 pstmt1.setString(10,registrationDate);
			 pstmt1.setString(11,typeOfVendor);
			 pstmt1.setString(12,cardNo);
			 pstmt1.setString(13,balance);
		//	 System.out.println(pstmt1);
			 pstmt1.executeUpdate();
		//	 System.out.println("data insertd successfully");
			 
			 
		} catch (SQLException e) {
	//		System.out.println(e.getMessage());
			throw new ApplicationException(e);
		}
		 finally {
             try {
                             closeConnection();
             } catch (SQLException e) {
            //                 System.out.println("application exception78");
                             throw new ApplicationException(e);
             }
		 }
		
		return result;
	}
	 private void closeConnection() throws SQLException {
         
         if (pstmt1 != null) {
                         pstmt1.close();
         }
         if(resultSet!=null)
         {
                         resultSet.close();
         }
         if (connection != null) {
                         connection.close();
         }

}
}
