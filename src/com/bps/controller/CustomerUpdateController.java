package com.bps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bps.bo.CustomerUpdateBO;
import com.bps.exceptions.BusinessException;
import com.bps.to.CustomerUpdateTo;

/**
 * Servlet implementation class CustomerUpdateController
 */
public class CustomerUpdateController extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerUpdateController()
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
		int customerId = 0;
		HttpSession session = request.getSession();
		try
		{
			try
			{
				customerId = Integer.parseInt(request
						.getParameter("customerId"));
			}
			catch (NumberFormatException e)
			{
				throw new BusinessException("Customer Id must be a number");
			}
			
			CustomerUpdateBO bo = new CustomerUpdateBO();
			if (bo.searchDetails(customerId))
			{
				CustomerUpdateTo to = new CustomerUpdateTo();
				to = bo.displayDetails(customerId);
				{
					if (to != null)
					{
						session.setAttribute("result", to);
						
						RequestDispatcher rd = request
								.getRequestDispatcher("CustomerUpdate.jsp");
						rd.forward(request, response);
						
					}
				}
			}
		}
		
		catch (BusinessException e)
		{
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("CustomerSearch.jsp");
			rd.forward(request, response);
		}
		catch (Exception e)
		{
			request.setAttribute("errMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
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
		
		// response.sendRedirect("google.com");
		
		try
		{
			// System.out.println("qwqwqw");
			
			CustomerUpdateTo to = new CustomerUpdateTo();
			// System.out.println("789");
			to.setCountryName(request.getParameter("countryName"));
			to.setState(request.getParameter("state"));
			to.setAddress(request.getParameter("address"));
			to.setContactNo(Long.parseLong((request.getParameter("contactNo"))));
			to.setEmail(request.getParameter("email"));
			// System.out.println("789");
			to.setVendorType(request.getParameter("vendorType"));
			// System.out.println("ufsfhsfhoshfosh");
			to.setBalance(Integer.parseInt(request.getParameter("balance")));
			to.setCardNo(Long.parseLong((request.getParameter("cardNo"))));
			// System.out.println("po");
			// System.out.println(request.getParameter("cardNo"));
			// System.out.println(Integer.parseInt(request.getParameter("cardNo")));
			// System.out.println("wqqwq");
			to.setCustomerName(request.getParameter("customerName"));
			// System.out.println("q");
			to.setIdNo(request.getParameter("idNo"));
			// System.out.println("w");
			to.setIdDoc(request.getParameter("idDoc"));
			to.setCountryId(request.getParameter("countryId"));
			to.setRegDate(request.getParameter("regDate"));
			
			// System.out.println("qwerty");
			
			try
			{
				
				// to.setCardNo(Integer.parseInt(request.getParameter("cardNo")));
				// System.out.println("apo");
				
				to.setCustomerId(Integer.parseInt(request
						.getParameter("customerId")));
				
				// System.out.println("gdhgd");
				request.setAttribute("customerId",
						request.getParameter("customerId"));
			}
			catch (NumberFormatException e)
			{
				throw new BusinessException(
						"Employee count and Customer count Should be a Numeric");
			}
			// System.out.println("asde");
			CustomerUpdateBO bo = new CustomerUpdateBO();
			
			// System.out.println(bo);
			
			if (bo.updateCustomer(to))
			{
				// System.out.println("edwew");
				RequestDispatcher rd = request
						.getRequestDispatcher("CustomerUpdateSuccess.jsp");
				rd.forward(request, response);
			}
		}
		catch (BusinessException e)
		{
			request.setAttribute("message", e.getMessage());
			
			RequestDispatcher rd = request
					.getRequestDispatcher("CustomerUpdate.jsp");
			rd.forward(request, response);
		}
		
		catch (Exception e)
		{
			// request.setAttribute("message", e.getMessage());
			e.printStackTrace();
			// RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			// rd.forward(request, response);
		}
		
	}
}