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

import com.bps.bo.RegisterVendorBO;
import com.bps.constants.SuccessConstants;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.to.StateTO;
import com.bps.to.VendorRegistrationTO;
import com.bps.to.VendorTO;

/**
 * Servlet implementation class RegisterVendorController
 */
public class RegisterVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterVendorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterVendorBO registerVendorBo = new RegisterVendorBO();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		String choice = request.getParameter("choice");
		if ("1".equals(choice)) {
			List<String> countryList = registerVendorBo.getCountryList();
	//		System.out.println(countryList);
			session.setAttribute("countryList", countryList);
			List<String> regNoList = registerVendorBo.getRegNoList();
	//		System.out.println(regNoList);
			session.setAttribute("regNoList", regNoList);

			dispatcher = request.getRequestDispatcher("RegisterVendor.jsp");
			request.setAttribute("found", "true");
			dispatcher.forward(request, response);
		} else if ("2".equals(choice)) {
			String countryName = request.getParameter("country");
			// System.out.println("inside servlet" + countryName);
			try {
				List<StateTO> stateList = registerVendorBo
						.getStateList(countryName);

				session.setAttribute("stateList", stateList);
				session.setAttribute("countryName", countryName);
				PrintWriter out = response.getWriter();
				String result = null ;

				for (StateTO stateTo : stateList) {

					result += "<option value=\"" + stateTo.getCountryId()
							+ "\" > " + stateTo.getState() + "</option>";

				}

				out.println(result);
				// dispatcher =
				// request.getRequestDispatcher("RegisterVendor.jsp");
				// request.setAttribute("found", "true");
				// dispatcher.forward(request, response);

			} catch (ApplicationException e) {

				e.printStackTrace();
			}

		} else {
			String companyRegNo = request.getParameter("companyRegNo");
	//		System.out.println(companyRegNo);
			int companyRegno = 0;
			if (companyRegNo != null && !"-".matches(companyRegNo)) {
				companyRegno = Integer.parseInt(companyRegNo);
			}
	//		System.out.println(companyRegno);

			VendorTO vendorTo;
			try {
				// registerVendorBo.validateCompRegNo(companyRegno);
				session.setAttribute("companyRegno", companyRegNo);
				vendorTo = registerVendorBo.getVendorName(companyRegno);
				String vendorName = vendorTo.getVendorName();
				session.setAttribute("vendorName", vendorName);
				String vendorType = vendorTo.getVendorType();
				session.setAttribute("vendorType", vendorType);
				dispatcher = request.getRequestDispatcher("RegisterVendor.jsp");
				request.setAttribute("found", "true");
				dispatcher.forward(request, response);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				dispatcher = request
						.getRequestDispatcher(SuccessConstants.REGISTRATION_PAGE);
				request.setAttribute("errMsg", e.getMessage());
				dispatcher.forward(request, response);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterVendorBO registerVendorBo = new RegisterVendorBO();
	//	System.out.println("hgdryw");
		String companyRegno = request.getParameter("companyRegNo");
		String vendor_name = request.getParameter("name");
		String vendor_type = request.getParameter("vendorType");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String country_id = request.getParameter("state");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contact");

		String website = request.getParameter("website");
		String eCount = request.getParameter("eCount");
		String cCount = request.getParameter("cCount");
		String yoe = request.getParameter("yoe");
		String issue = request.getParameter("issue");
		String validity = request.getParameter("validity");
		// System.out.println(state);

		RegisterVendorBO regVendorBo = new RegisterVendorBO();
		String state = null;
		RequestDispatcher dispatcher = null;
		try {
			state = regVendorBo.getStateName(country_id, country);
			VendorRegistrationTO venRegTo = new VendorRegistrationTO(
					companyRegno, country_id, vendor_name, vendor_type, issue,
					validity, yoe, country, address, state, email, contactNo,
					website, eCount, cCount);
			registerVendorBo.validateVendor(venRegTo);
			registerVendorBo.addVendorDetails(venRegTo);
			dispatcher = request
					.getRequestDispatcher(SuccessConstants.VEN_SUCCESS_PAGE);

			dispatcher.forward(request, response);
		} catch (ApplicationException e1) {
		//	System.out.println(e1.getMessage());
			dispatcher = request
					.getRequestDispatcher(SuccessConstants.REGISTRATION_PAGE);
			request.setAttribute("errMsg", e1.getMessage());
			dispatcher.forward(request, response);
			// e1.printStackTrace();
		} catch (BusinessException e) {

			// System.out.println(e.getMessage());
			dispatcher = request
					.getRequestDispatcher(SuccessConstants.REGISTRATION_PAGE);
			request.setAttribute("found", "true");
			request.setAttribute("errorList", e.getErrorList());

			dispatcher.forward(request, response);

		}

	}
}
