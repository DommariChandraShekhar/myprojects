package com.codinghub.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao 
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/ch15";
		String u="root",p="2126";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, u, p);
		return con;
	}
	public static ResultSet getValues(String email,String password) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("SELECT * FROM CUSTOMER WHERE EMAIL=? AND PASSWORD=?");
		pst.setString(1,email);
		pst.setString(2,password);
		return pst.executeQuery();
		
	}
}
