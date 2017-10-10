package com.sri.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemsInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static Item item=new Item();  
    
    public ItemsInventory() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    item=ItemDAO.select();
		PrintWriter out=response.getWriter();
		out.append("<html>");
		out.append("<head>");
		out.append("<style> table,th,td{border:1px solid black}</style>");
		out.append("<title>Items Display</title>");
		out.append("</head>");
		out.append("<body>");
		out.append("<table style=\"width=100%\">");
		out.append("<th> Name </th>");
		out.append("<th> Price </th>");
		out.append("<th> Quantity </th>");
		out.append("<tr>");
		out.append("<td>"+item.getName()+"</td>");
		out.append("<td>"+item.getPrice()+"</td>");
		out.append("<td>"+item.getQuantity()+"</td>");
		out.append("</tr>");
		out.append("</table>");
		out.append("</body>");
		out.append("</html>");
		out.print(request.getSession().getCreationTime());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
