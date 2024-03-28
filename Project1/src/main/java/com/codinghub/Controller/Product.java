package com.codinghub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codinghub.Repository.ProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class Product extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		try {
			ResultSet rs=ProductDao.getProduct();
		
			while(rs.next())
			{
				
				out.println(
						
						"<table border=1>"+
								"<tr>"+
									"<th>"+"Product Name"+"</th>"+
									"<th>"+"Product Code"+"</th>"+
									"<th>"+"Product Price"+"</th>"+
									"<th>"+"Product Quantity"+"</th>"+
								"</tr>"+
									
								"<tr align=center>"+
								"<td>"+rs.getString(1)+"</td>"+
								"<td>"+rs.getString(2)+"</td>"+
								"<td>"+rs.getString(3)+"</td>"+
								"<td>"+rs.getString(4)+"</td>"+
								"</tr>"+
								
						"</table>"
						);
				
				
//				out.println(rs.getString(1));
//				out.println(rs.getString(2));
//				out.println(rs.getString(3));
//				out.println(rs.getString(4));
//				out.println("<br>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
