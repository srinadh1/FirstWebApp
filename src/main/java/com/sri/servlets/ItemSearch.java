package com.sri.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemSearch
 */
public class ItemSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ArrayList<String> s1=new ArrayList<String>(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		out.append("<html>");
		out.append("<head>");
		out.append("<title>Items Display</title>");
		out.append("</head>");
		out.append("<body>");
		out.append("<form method='post' action='ItemSearch'>");
		out.append("Barcode:");
		out.append("<input type=\"text\" name=\"bc\">");
		out.append("<input type=\"submit\" value=\"submit\">");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String  code="";
		code=request.getParameter("bc");
		//out.print(code);
		s1=ItemDAO.getBarcode();
		if(s1.contains(code))
		{
		Item item=ItemDAO.selectItem(code);
		out.append("<html>");
		out.append("<head>");
		out.append("<title>Items Display</title>");
		out.append("</head>");
		out.append("<body>");
		out.append("<p>"+item.getName()+"</p>");
		out.print("<p>"+item.getPrice()+"</p>");
		out.print("<p>"+item.getQuantity()+"</p>");
		out.append("<body>");
		out.append("</title>");
		out.append("<html>");
		}
		else {
			response.sendRedirect("https://www.google.com");
		}
	}
}
