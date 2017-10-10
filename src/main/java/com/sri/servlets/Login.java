package com.sri.servlets;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
	HashMap<Integer,String> map=new HashMap<Integer,String>();
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("");
		 dbprops = DatabaseProperties.getInstance().getProperties();
		connectionUrl = "jdbc:mysql://" 
				+ dbprops.getProperty("server") 
				+ ":" + dbprops.getProperty("port")
				+ "/" + dbprops.getProperty("database")+"?autoReconnect=true&useSSL=false";
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	{
		System.out.println("Called when the class is initialized");
	}
	
	public static Connection getConnection() throws Exception
	{
		Connection con = DriverManager.getConnection(connectionUrl, dbprops.getProperty("userid"), dbprops.getProperty("password"));
return con;
	}  
   
    public Login() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select *from login");
			ResultSet rs=stmt.executeQuery();
			
		while(rs.next()) {
			map.put(rs.getInt(1), rs.getString(2));
			}
	
		if(map.containsKey(Integer.parseInt(request.getParameter("id")))&&map.containsValue(request.getParameter("password"))) {
			request.getSession(true);
			response.sendRedirect("http://localhost:8080/FirstWebApp/Controller");
			
		}
		else {
			response.sendRedirect("http://localhost:8080/FirstWebApp/error.jsp");
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			}
		}
	}

}
