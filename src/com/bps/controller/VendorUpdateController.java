package com.bps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bps.bo.VendorUpdateBO;
import com.bps.constants.SuccessConstants;
import com.bps.exceptions.BusinessException;
import com.bps.to.VendorUpdateTo;

/**
 * Servlet implementation class VendorUpdateController
 */
public class VendorUpdateController extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VendorUpdateController()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		int vendorId = 0;
		HttpSession session = request.getSession();
		try
		{
			try
			{
				vendorId = Integer.parseInt(request.getParameter("vendorId"));
			}
			
			catch (NumberFormatException e)
			{
				throw new BusinessException("Vendor Id must be a number");
			}
			
			VendorUpdateBO bo = new VendorUpdateBO();
			if (bo.searchDetails(vendorId))
			{
				VendorUpdateTo to = new VendorUpdateTo();
				to = bo.displayDetails(vendorId);
				{
					if (to != null)
					{
						session.setAttribute("result", to);
						RequestDispatcher rd = request
								.getRequestDispatcher(SuccessConstants.VENDOR_UPDATE_PAGE);
						rd.forward(request, response);
						
					}
				}
			}
		}
		
		catch (BusinessException e)
		{
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher(SuccessConstants.VENDOR_SEARCH_PAGE);
			rd.forward(request, response);
		}
		catch (Exception e)
		{
			request.setAttribute("errMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher(SuccessConstants.ERROR_PAGE);
			rd.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		try
		{
			VendorUpdateTo to = new VendorUpdateTo();
			
			to.setCountryName(request.getParameter("countryName"));
			to.setState(request.getParameter("state"));
			to.setAddress(request.getParameter("address"));
			to.setContactNo(Long.parseLong(request.getParameter("contactNo")));
			to.setEmail(request.getParameter("email"));
			to.setWebsite(request.getParameter("website"));
			
			try
			{
				to.setYearOfEstablish(request.getParameter("yearOfEstablish"));
				to.setEmployeeCount(Integer.parseInt(request
						.getParameter("employeeCount")));
				to.setCustomerCount(Integer.parseInt(request
						.getParameter("customerCount")));
				to.setVendorId(Integer.parseInt(request
						.getParameter("vendorId")));
				request.setAttribute("vendorId",
						request.getParameter("vendorId"));
			}
			catch (NumberFormatException e)
			{
				throw new BusinessException(
						"Employee count and Customer count Should be a Numeric");
			}
			
			try
			{
				VendorUpdateBO bo = new VendorUpdateBO();
				
				if (bo.updateVendor(to))
				{
					bo.certificatecalc(to);
					
					RequestDispatcher rd = request
							.getRequestDispatcher(SuccessConstants.VENDOR_UPDATE_SUCCESS_PAGE);
					rd.forward(request, response);
				}
			}
			catch (BusinessException e)
			{
				request.setAttribute("message", e.getMessage());
				
				RequestDispatcher rd = request
						.getRequestDispatcher(SuccessConstants.VENDOR_UPDATE_PAGE);
				rd.forward(request, response);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
