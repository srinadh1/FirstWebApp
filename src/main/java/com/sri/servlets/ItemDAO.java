package com.sri.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;



class ItemDAO {
	
	static Item item=new Item();
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
	static ArrayList<Item> items=new ArrayList<Item>();
	static ArrayList<String> s1=new ArrayList<String>();
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
          

	//create
	public static void create() {
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("create table if not exists Item (ID INT not null ,u_name VARCHAR(20), Price INT,Quantity INT,disc boolean,  primary key (id))");
			int rs=stmt.executeUpdate();
			
		if(rs==0) {
			System.out.println("Table created successfully.");
		}
		else {
			System.out.println("Creation of table failed.");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	//insert
		public static void insert(int id,String name,double price,int quantity) {
			Connection con = null;
			try {
				con = getConnection();
				PreparedStatement stmt = con.prepareStatement("insert into Item values(?,?,?,?,?)");
				stmt.setInt(1, id);
				stmt.setString(2,name);
				stmt.setInt(3, (int) price);
				stmt.setInt(4, quantity);
				stmt.setBoolean(5, true);
				
				int rs=stmt.executeUpdate();
		
			if(rs==1) {
				System.out.println("Values inserted successfully");
			}
			else {
				System.out.println("Insertion failed.");
			}}
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}}
		public static ArrayList<Item> display() {
			Connection con=null;
			try {
				con=getConnection();
				PreparedStatement stmt=con.prepareStatement("select * from item");
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) 
				{
					item=new Item(rs.getString("u_name"),rs.getInt("price"),rs.getInt("quantity"));
					items.add(item);
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(con!=null) {
					try {
						con.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return items;
		}
		
		public static  ArrayList<String> getBarcode(){
			Connection con=null;
			try {
				con=getConnection();
				PreparedStatement stmt=con.prepareStatement("Select id from item");
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
				
				s1.add(rs.getString("id"));
				
				}}
				catch(Exception e) {
					System.out.println(e);
				}
			finally {
				if(con!=null){
					try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}}
				return s1;
		}
		public static void update() {
			Connection con = null;
			try {
				con = getConnection();
				PreparedStatement stmt = con.prepareStatement("update item set quantity=33 where id=1");
				
				int rs=stmt.executeUpdate();
				if(rs==1) {
					System.out.println("Table successfully updated");
				}
				else {
					 System.out.println("Updation of table failed.");
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}}
		}
	public static Item select() {
		
		Connection con = null;
	
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from item");
			ResultSet rs = stmt.executeQuery();
		while(rs.next()) 
		{
			item=new Item(rs.getString("u_name"),rs.getInt("price"),rs.getInt("quantity"));
		}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return item;
		
	}

	public static Item selectItem(String code) {

		Connection con = null;
	
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from item where id="+code+"");
			ResultSet rs = stmt.executeQuery();
		while(rs.next()) 
		{
			item=new Item(rs.getString("u_name"),rs.getInt("price"),rs.getInt("quantity"));
		}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return item;
	}


	public static void descriptionDisplay() {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con=getConnection();
			PreparedStatement stmt=con.prepareStatement("select *from itemdescription");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		}
		catch(Exception e) {System.out.println(e);
		}
		finally {
			if(con!=null) {
				try {
			con.close();}
				catch(SQLException e) {
					e.printStackTrace();
				}
		}
	}
}}