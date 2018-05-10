package com.bps.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.bps.dao.BillPaymentDAO;
import com.bps.dbutil.DbUtil;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.exceptions.DatabaseOperationException;
import com.bps.to.AmountTO;
import com.bps.to.BillPaymentTO;
import com.bps.to.VenTO;

public class BillPaymentBO {

	BillPaymentDAO bpDAO = new BillPaymentDAO();

	public boolean validateCustomerId(int cid) throws BusinessException,
			DatabaseOperationException, ApplicationException {

		int result = bpDAO.customerExists(cid); // SO , basically DAO is doing
												// all the validation
		if (result != 1) {
			throw new BusinessException("Invalid Customer ID ");

		}

		return true;

	}

	public boolean validateAmount(String amount, String pending)
			throws BusinessException, DatabaseOperationException,
			ApplicationException {
		boolean flag = true;

		double amountToPay = Double.parseDouble(amount);
		double pendingAmount = Double.parseDouble(pending);
		if (pendingAmount >= amountToPay) {
			if (amount.matches("\\d+.\\d\\d")) {
				if (amountToPay < 0) {
					throw new BusinessException("Amount should not be negative");
				}
				flag = true;
			} else {
				throw new BusinessException(
						"Amount should have two decimal places");
			}
		} else {
			throw new BusinessException(
					"Amount to pay  should be less than or equal to pending amount");
		}

		return flag;

	}

	public boolean validateCreditCard(String cardNumber,
			String confirmCardNumber , int cid) throws BusinessException,
			DatabaseOperationException, ApplicationException {

		if (cardNumber.equalsIgnoreCase(confirmCardNumber)) {

			if (bpDAO.validateCC(cardNumber,cid)) {
				return true;
			}
			else{
				throw new BusinessException("Credit card number not valid");
			}
			
		}

		else {
			throw new BusinessException("Credit card number not matching");
		}
	}

	public boolean validateCVV(String cvv) throws BusinessException,
			DatabaseOperationException, ApplicationException {

		if (cvv.length() == 3) {

			return true;
		}

		else {
			throw new BusinessException("CVV should be of 3 digits");
		}
	}
	  public List<VenTO> getAll() throws BusinessException, DatabaseOperationException
	  {
		  return new BillPaymentDAO().getAll();
	  }

	// addBillDetails is Left ... which modifies the pending bill after payment
	public void addBillDetails(BillPaymentTO bpTO) throws ApplicationException {
		bpDAO.add(bpTO);

	}

	public List<AmountTO> getAmount(String venType) throws BusinessException, SQLException{
		
		return new BillPaymentDAO().getAmount(venType);
		
}
}
