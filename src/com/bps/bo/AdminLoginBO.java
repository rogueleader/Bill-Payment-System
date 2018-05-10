package com.bps.bo;

import java.util.ArrayList;

import com.bps.constants.ErrorConstants;
import com.bps.dao.AdminLoginDAO;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;

//HAVE TO ADD CODE FOR CHECKING NULL VALUES 
public class AdminLoginBO {
	AdminLoginDAO adminDAO = new AdminLoginDAO();

	@SuppressWarnings({ "finally", "finally" })
	public boolean validate(String u, String p) throws ApplicationException,
			BusinessException {

		ArrayList<String> al = new ArrayList<String>();
		al = adminDAO.getAdmin();

		if (al.get(0).equals(u) && al.get(1).equals(p)) {
			return true;
		} else {

			throw new BusinessException(ErrorConstants.LOGINERROR);

		}

	}

}
