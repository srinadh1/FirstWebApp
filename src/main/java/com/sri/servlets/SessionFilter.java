package com.sri.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




public class SessionFilter implements Filter {

   
    public SessionFilter() {
        
    }

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req= (HttpServletRequest) request;    
		    HttpSession session = req.getSession(false);
		    
		    if(session==null) {
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		    	dispatcher.forward(request, response);
		    }
		    else {
		chain.doFilter(request, response);
	}}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
