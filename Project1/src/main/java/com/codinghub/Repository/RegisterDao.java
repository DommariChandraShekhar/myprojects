package com.codinghub.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.codinghub.pogo.Customer;

public class RegisterDao 
{
	public static Connection boilerPlateCode() throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/ch15";
		String u="root",p="2126";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, u, p);
		return con;
	}
	public static int insert(Customer customer) throws ClassNotFoundException, SQLException
	{
		Connection con=boilerPlateCode();
		PreparedStatement pst=con.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?)");
		pst.setString(1, customer.getUsername());
		pst.setString(2, customer.getEmail());
		pst.setString(3,customer.getPassword());
		int rows=pst.executeUpdate();
		return rows;
	}
}
