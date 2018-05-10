package com.bps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bps.bo.CustomerRegistrationBO;
import com.bps.constants.SuccessConstants;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.to.CustomerRegistrationTo;
import com.bps.to.StateTO;

/**
 * Servlet implementation class CustomerRegistrationController
 */
public class CustomerRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerRegistrationBO customerRegistrationBo = new CustomerRegistrationBO();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		String choice = request.getParameter("choice");
		String result =null;

		if ("1".equals(choice)) {
		List<String> countryList = customerRegistrationBo.getCountryList();
	//	System.out.println(countryList);
		session.setAttribute("countryList", countryList);
		
		
		List<String> identificationDocumentList = customerRegistrationBo.getidentificationDocumentList();
	//	System.out.println(identificationDocumentList);
		session.setAttribute("identificationDocumentList", identificationDocumentList);
		dispatcher = request.getRequestDispatcher("CustomerRegistration.jsp");
		request.setAttribute("found", "true");
		dispatcher.forward(request, response);
		} else if ("2".equals(choice)) {
		String countryName = request.getParameter("country");
		// System.out.println("inside servlet" + countryName);
		try {
		List<StateTO> stateList = customerRegistrationBo.getStateList(countryName);

		session.setAttribute("stateList", stateList);
		session.setAttribute("countryName", countryName);
		PrintWriter out = response.getWriter();

		for (StateTO stateTo : stateList) {

		result += "<option value=\"" + stateTo.getCountryId()
		+ "\" > " + stateTo.getState() + "</option>";

		}
		out.println(result);
		
		} catch (ApplicationException e) {

		e.printStackTrace();
		}

		}
		 if ("3".equals(choice)) {
			String identificationDocumentName = request.getParameter("identificationDocument");
			
			try {

			String prefixFormat=customerRegistrationBo.getprefixFormat(identificationDocumentName);
		//	System.out.println(prefixFormat);
			session.setAttribute("prefixFormat", prefixFormat);
			session.setAttribute("identificationDocumentName", identificationDocumentName);
			PrintWriter out = response.getWriter();
		//	String result = new String();

			

			result+="<input type=\"text\" name=\"prefix\" value="+ prefixFormat +">";

			

			out.println(result);
			
			} catch (ApplicationException e) {

			e.printStackTrace();
			}

			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		String address=request.getParameter("address");
		String contactNumber=request.getParameter("contactNumber");
		String country=request.getParameter("country");
		String country_id=request.getParameter("state");
		String mailId=request.getParameter("mailId");
		String identificationDocument=request.getParameter("identificationDocument");
		String prefixFormat=request.getParameter("prefixFormat");
		String documemtDetailNumber=request.getParameter("documemtDetailNumber");
		String registrationDate=request.getParameter("registrationDate");
		String typeOfVendor=request.getParameter("typeOfVendor");
		String cardNo=request.getParameter("cardNo");
		String balance=request.getParameter("balance");
		
		CustomerRegistrationBO customerRegistrationBO =new CustomerRegistrationBO();
		String state = null;
        RequestDispatcher dispatcher=null;
		
		HttpSession session;
		
		try {
			state = customerRegistrationBO.getStateName(country_id, country);
			CustomerRegistrationTo customerRegistrationTo=new CustomerRegistrationTo(customerName, 
                    address, contactNumber, country,country_id, state, 
                    mailId, identificationDocument, prefixFormat+documemtDetailNumber,
                    registrationDate, typeOfVendor, cardNo, balance);
      //      System.out.println(customerRegistrationTo+"inside servlet");
			customerRegistrationBO.validateCustomer(customerRegistrationTo);
			customerRegistrationBO.customerAdd(customerRegistrationTo);
			session=request.getSession();
			session.setAttribute("customerName", customerName);
			dispatcher=request.getRequestDispatcher(SuccessConstants.SUCCESS_PAGE);
		//	System.out.println("inside servlet dispatch successful");
			dispatcher.forward(request, response);
		}
		   catch (BusinessException e) {
		//	   System.out.println("-------------------");
        //       System.out.println(e.getErrorList());
               request.setAttribute("found", "true");
               request.setAttribute("errorList", e.getErrorList());
               dispatcher = request.getRequestDispatcher("CustomerRegistration.jsp");
               dispatcher.forward(request, response);

		}
		    catch(ApplicationException e)
		    {
			dispatcher=request.getRequestDispatcher(SuccessConstants.LOGIN_PAGE);
			request.setAttribute("errMsg", e.getMessage());
			dispatcher.forward(request, response);
		    }
		
		 
		
	}

}
