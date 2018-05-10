package com.bps.bo;

import java.util.Calendar;

import com.bps.dao.VendorUpdateDAO;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.to.VendorUpdateTo;

public class VendorUpdateBO
{
	
	VendorUpdateDAO	dao	= new VendorUpdateDAO();
	
	public boolean searchDetails(int vId1) throws BusinessException, Exception
	{
		boolean flag = false;
		
		flag = dao.searchDetailsdao(vId1);
		if (flag == false)
		{
			throw new BusinessException("Invalid Vendor Id");
		}
		
		return flag;
	}
	
	public VendorUpdateTo displayDetails(int vId1) throws BusinessException,
			Exception
	{
		VendorUpdateTo to = dao.displayDetails(vId1);
		return to;
	}
	
	public boolean updateVendor(VendorUpdateTo to) throws BusinessException

	{
		
		boolean successflag = true;
		try
		{
			successflag = dao.updateVendor(to);
			if (successflag == false)
			{
				throw new BusinessException("Invalid Vendor Id");
			}
			
		}
		catch (BusinessException e)
		{
			throw new BusinessException("Invalid Vendor Id");
		}
		catch (Exception e)
		{
			throw new BusinessException("Invalid Vendor Id");
		}
		//System.out.println("end of update vendor " + successflag);
		return successflag;
	}
	
	public String certificatecalc(VendorUpdateTo to)
			throws ApplicationException
	{
		
		String certificate = "";
		{
			int yoe = Integer.parseInt(to.getYearOfEstablish());
			int year = (int) Calendar.getInstance().get(Calendar.YEAR);
		//	System.out.println(year);
			int yos = year - yoe;
			int eCount = to.getEmployeeCount();
			
			if (yos >= 1 && yos < 5)
			{
				if (eCount >= 30 && eCount < 50)
				{
					certificate += "A+";
				}
			}
			else if (yos == 5)
			{
				if (eCount >= 30 && eCount < 50)
				{
					certificate += "A+";
				}
				else if (eCount >= 50 && eCount < 75)
				{
					certificate += "B+";
				}
			}
			else if (yos > 5 && yos < 10)
			{
				
				if (eCount >= 50 && eCount < 75)
				{
					certificate += "B+";
				}
			}
			else if (yos == 10)
			{
				if (eCount >= 50 && eCount < 75)
				{
					certificate += "B+";
				}
				else if (eCount >= 75 && eCount < 100)
				{
					certificate += "C+";
				}
			}
			else if (yos > 10 && yos < 15)
			{
				if (eCount >= 75 && eCount < 100)
				{
					certificate += "C+";
				}
			}
			else if (yos == 15)
			{
				if (eCount >= 75 && eCount < 100)
				{
					certificate += "C+";
				}
				else if (eCount >= 100 && eCount < 200)
				{
					certificate += "D+";
				}
			}
			else if (yos > 15 && yos < 25)
			{
				if (eCount >= 100 && eCount < 200)
				{
					certificate += "D+";
				}
			}
			else if (yos == 25)
			{
				if (eCount >= 100 && eCount < 200)
				{
					certificate += "D+";
				}
				else if (eCount >= 200 && eCount < 500)
				{
					certificate += "E+";
				}
			}
			else if (yos > 25 && yos <= 50)
			{
				if (eCount >= 200 && eCount < 500)
				{
					certificate += "E+";
				}
			}
			else if (yos > 50)
			{
				if (eCount > 500)
				{
					certificate += "F+";
				}
			}
			
		}
		to.setCertificate(certificate);
		return dao.certificatecalc(to);
	}
}
