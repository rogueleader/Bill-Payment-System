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

import com.bps.bo.BillPaymentBO;
import com.bps.exceptions.ApplicationException;
import com.bps.exceptions.BusinessException;
import com.bps.exceptions.DatabaseOperationException;
import com.bps.to.AmountTO;
import com.bps.to.BillPaymentTO;
import com.bps.to.VenTO;

/**
 * Servlet implementation class bpTOController
 */
public class BillPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillPaymentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		RequestDispatcher dispatcher;
		if ("1".equals(choice)) {
			// no need to call BO afaik
			BillPaymentBO bpBO = new BillPaymentBO();
			HttpSession session = request.getSession();

			try {
				List<VenTO> bpToList = bpBO.getAll();
				session.setAttribute("bpToList", bpToList);
		//		System.out.println(bpToList);
				dispatcher = request.getRequestDispatcher("BillPayment.jsp");
				request.setAttribute("found", "true");
				dispatcher.forward(request, response);
		//		System.out.println("hello");
			} catch (BusinessException be) {
				be.printStackTrace();
			} catch (DatabaseOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {

				String venType = request.getParameter("venType");
		//		System.out.println("venType = " + venType);
			//	PrintWriter out = response.getWriter();
				BillPaymentBO bpBO = new BillPaymentBO();
				List<AmountTO> amountToList;
				amountToList = bpBO.getAmount(venType);
		//		System.out.println("List"+amountToList);
				request.setAttribute("amountToList", amountToList);
				dispatcher = request.getRequestDispatcher("BillPayment.jsp");
				request.setAttribute("venType", venType);
				request.setAttribute("found", "true");
		//		System.out.println("send");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			
		
		BillPaymentBO bpBO = new BillPaymentBO(); // will validate all details

		BillPaymentTO bpTO = new BillPaymentTO(); // acts as a setter
		// response.sendRedirect("google.com");

		try {
			String customer_id = request.getParameter("CustomerID");
			int customer_ID = Integer.parseInt(customer_id);
			String vendor_Type = request.getParameter("Vendortype");
			String vendor_Name = request.getParameter("VendorName");
			String pending_Amount = request.getParameter("PendingAmount");
		//	System.out.println(pending_Amount);
			String payment_Date = request.getParameter("PaymentDate");
			String amount_To_Pay = request.getParameter("AmountToPay");
			double amount_To_Payy = Double.parseDouble(amount_To_Pay);
			double pending_Amountt = Double.parseDouble(pending_Amount);
			String credit_Card_Type = request.getParameter("CardType");
			String card_Number = request.getParameter("CardNumber");
			String confirm_Card_Number = request
					.getParameter("ConfirmCardNumber");
			String credit_Card_ValidityMM = request.getParameter("MM");
			int creditCard_ValidityMM = Integer
					.parseInt(credit_Card_ValidityMM);
			String credit_Card_ValidityYY = request.getParameter("yyyy");
			int creditCard_ValidityYY = Integer
					.parseInt(credit_Card_ValidityYY);
			String cvv = request.getParameter("cvv");
			int cVv = Integer.parseInt(cvv);

			if (bpBO.validateCustomerId(customer_ID)) {

				if (bpBO.validateAmount(amount_To_Pay, pending_Amount)) {

					if (bpBO.validateCreditCard(card_Number,
							confirm_Card_Number, customer_ID)) {

						if (bpBO.validateCVV(cvv)) {

							bpTO.setCustomerid(customer_id);
							bpTO.setCustomerID(customer_ID);
							bpTO.setVendorType(vendor_Type);
							bpTO.setVendorName(vendor_Name);
							bpTO.setPendingAmount(pending_Amount);
							bpTO.setPaymentDate(payment_Date);
							bpTO.setAmountToPay(amount_To_Pay);
							bpTO.setAmountToPayy(amount_To_Payy);
							bpTO.setPendingAmountt(pending_Amountt);
							bpTO.setCreditCardType(credit_Card_Type);
							bpTO.setCardNumber(card_Number);
							bpTO.setConfirmCardNumber(confirm_Card_Number);
							bpTO.setCreditCardValidityMM(creditCard_ValidityMM);
							bpTO.setCreditCardValidityYY(creditCard_ValidityYY);
							bpTO.setCvv(cvv);
							RequestDispatcher rd = null;
							// System.out.println(bpTO.getVendorType());
							// System.out.println(bpTO.getCustomerid()+"  "+bpTO.getCustomerID());
							bpBO.addBillDetails(bpTO);// MODIFICATION OF BILL
														// AFTER PENDING BILL
														// PAYMENT

							request.setAttribute("id", customer_ID);
							rd = request
									.getRequestDispatcher("billpayment_success.jsp");
							rd.forward(request, response);
							// System.out.println("hello");
						}
					}

				}

			}
			// else {
			// response.sendRedirect("billpayment_failure.jsp");
			//
			// }
			// VALIDATE ALL DETAILS USING BO AND USE TO AS SETTER

		} catch (BusinessException be) {
			//be.printStackTrace();

			request.setAttribute("message", be.getMessage());

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("BillPayment.jsp");
			dispatcher.forward(request, response);

		} catch (ApplicationException ae) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
