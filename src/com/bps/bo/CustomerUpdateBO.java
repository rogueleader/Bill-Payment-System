package com.bps.bo;

import com.bps.dao.CustomerUpdateDAO;
import com.bps.exceptions.BusinessException;
import com.bps.to.CustomerUpdateTo;

public class CustomerUpdateBO
{
	
	CustomerUpdateDAO	dao	= new CustomerUpdateDAO();
	
	public boolean searchDetails(int cId1) throws BusinessException, Exception
	{
		boolean flag = false;
		
		//System.out.println("c");
		flag = dao.searchDetailsdao(cId1);
		
		// System.out.println("ttttt");
		// System.out.println(flag);
		if (flag == false)
		{
			throw new BusinessException("Please enter a valid Customer Id");
		}
		
		return flag;
	}
	
	public CustomerUpdateTo displayDetails(int cId1) throws BusinessException,
			Exception
	{
		// TODO Auto-generated method stub
		CustomerUpdateTo to = dao.displayDetails(cId1);
		
		return to;
	}
	
	public boolean updateCustomer(CustomerUpdateTo to) throws BusinessException

	{
		
		boolean successflag = true;
		try
		{
			//System.out.println(to);
			successflag = dao.updateCustomer(to);
			//System.out.println(successflag);
			if (successflag == false)
			{
				throw new BusinessException("Please enter a valid Customer Id");
				
			}
			
		}
		catch (BusinessException e)
		{
			// TODO Auto-generated catch block
			// e.printStackTrace();
			
			throw new BusinessException("Please enter a valid Customer Id");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new BusinessException("Please enter a valid Customer Id");
		}
		//System.out.println(successflag);
		return successflag;
	}
}
