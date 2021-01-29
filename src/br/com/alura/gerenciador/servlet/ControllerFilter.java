package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controller.Action;

public class ControllerFilter implements Filter {
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		String paramAction = httpRequest.getParameter("action");
		String className = "br.com.alura.gerenciador.controller." + paramAction;
		
		String link;
		try {
			Class clazz = Class.forName(className); //Carrega a classe com o nome da variavel.
			Action action =  (Action) clazz.getDeclaredConstructor().newInstance(); //cria instância da classe, já fazendo um cast p/ a interface 
			link = action.execute(httpRequest,httpResponse);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}
		
		String[] addressType = link.split(":"); 
		
		if(addressType[0].equals("forward")) {
			RequestDispatcher rd = httpRequest.getRequestDispatcher("WEB-INF/view/" + addressType[1]);
			rd.forward(httpRequest, httpResponse);	
		}else {
			httpResponse.sendRedirect(addressType[1]);
		}
	}
}
