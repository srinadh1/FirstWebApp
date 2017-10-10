package com.sri.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PerformanceFilter implements Filter {
	private static final Logger log = LogManager.getLogger(PerformanceFilter.class);
    public PerformanceFilter() {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long startTime=System.currentTimeMillis();
		
		chain.doFilter(request, response);
	
		log.debug("TimeTaken:"+(System.currentTimeMillis()-startTime));
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
