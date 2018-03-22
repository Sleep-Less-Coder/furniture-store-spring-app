package com.hemant.furniture.store.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginRequiredFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// casting the servletrequest to the httprequest
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		// logging the uri
		System.out.println(httpServletRequest.getRequestURI());

		// check for the session variable
		if (httpServletRequest.getSession().getAttribute("loggedInUser") != null) {
			// forwarding the request and response
			chain.doFilter(servletRequest, servletResponse);
		} else {
			// go to login page
			HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
			httpResponse.sendRedirect("/product/all");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
