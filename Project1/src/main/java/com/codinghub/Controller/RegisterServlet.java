package com.codinghub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.codinghub.Repository.RegisterDao;
import com.codinghub.pogo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/r")
public class RegisterServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String emailid=req.getParameter("email");
		String password=req.getParameter("password");
		
		Customer customer=new Customer();
		customer.setUsername(username);
		customer.setEmail(emailid);
		customer.setPassword(password); 
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		try {
			int rows=RegisterDao.insert(customer);
			if(rows>0)
			{
				out.print("Registration completed successfully");
			}
			else
				out.print("Please try again");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
