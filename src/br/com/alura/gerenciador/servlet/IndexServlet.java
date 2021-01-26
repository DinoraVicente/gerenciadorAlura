package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.controller.Action;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean userNotLogged = session.getAttribute("userLogged") == null;
		boolean protectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
		
		if(protectedAction && userNotLogged) {
			response.sendRedirect("index?action=LoginForm");
			return;
		}
		
		String className = "br.com.alura.gerenciador.controller." + paramAction;
		
		String link;
		try {
			Class clazz = Class.forName(className); //Carrega a classe com o nome da variavel.
			Action action =  (Action) clazz.getDeclaredConstructor().newInstance(); //cria instância da classe, já fazendo um cast p/ a interface 
			link = action.execute(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}
		
		String[] addressType = link.split(":"); 
		
		if(addressType[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + addressType[1]);
			rd.forward(request, response);	
		}else {
			response.sendRedirect(addressType[1]);
		}
	}	
}