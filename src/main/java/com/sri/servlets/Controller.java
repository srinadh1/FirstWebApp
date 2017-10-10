package com.sri.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ArrayList<Item> items=new ArrayList<Item>();  
    
    public Controller() {
        super();
        }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		items=ItemDAO.display();
		HttpSession session1=request.getSession();
		session1.setAttribute("list", items);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/DisplayItems.jsp");
		rd.forward(request, response);
	
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
