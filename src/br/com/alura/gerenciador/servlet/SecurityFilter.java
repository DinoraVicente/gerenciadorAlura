package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
				
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		String paramAction = httpRequest.getParameter("action");
		
		HttpSession session = httpRequest.getSession();
		boolean userNotLogged = session.getAttribute("userLogged") == null;
		boolean protectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		
		if(protectedAction && userNotLogged) {
			httpResponse.sendRedirect("index?action=LoginForm");
			return;
		}	
		
		chain.doFilter(httpRequest, httpResponse);

	}
}