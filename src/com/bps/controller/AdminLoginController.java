package com.bps.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bps.*;
import com.bps.bo.AdminLoginBO;
import com.bps.constants.ErrorConstants;
import com.bps.exceptions.BusinessException;
import com.bps.exceptions.DatabaseOperationException;
import com.bps.to.AdminTO;





//LOG AND EXCEPTION are to be added 

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		AdminLoginBO loginbo=new AdminLoginBO();
		
		
		try {
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			if(user==null||pass==null)
			{
				throw new BusinessException("Null user and/or pass values ");
			}
			AdminTO adminto=new AdminTO(user,pass);
			//response.sendRedirect("adminerror.jsp");
			if(loginbo.validate(user, pass))
			{	session.setAttribute("username", request.getParameter("username"));
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
			else
			{
				//response.sendRedirect("adminerror.jsp");
			}
			
			
			
		} 
		catch(BusinessException be){
			
			request.setAttribute("msg",be.getMessage());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	catch (Exception e) {
			//response.sendRedirect("home.jsp");
			// TODO: handle exception
		//	e.printStackTrace();
		}
	}

}
