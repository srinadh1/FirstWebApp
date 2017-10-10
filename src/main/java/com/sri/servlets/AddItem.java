package com.sri.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddItem() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		

		out.print(request.getSession().getCreationTime());
		//ItemDAO.insert();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name="";
		double price=0.0;
		int quantity=0;
		int id=0;
		id=Integer.parseInt(request.getParameter("id"));
		
		name=request.getParameter("name");
		price=Double.parseDouble(request.getParameter("price"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		ItemDAO.insert(id,name, price, quantity);
		
		doGet(request, response);
		
	}

}
