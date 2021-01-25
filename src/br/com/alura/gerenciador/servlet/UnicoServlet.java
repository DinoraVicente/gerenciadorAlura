package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controller.Action;

@WebServlet("/entrada")
public class UnicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramAction = request.getParameter("action");
		String nomeClasse = "br.com.alura.gerenciador.controller." + paramAction;
		
		String link;
		try {
			Class classe = Class.forName(nomeClasse); //Carrega a classe com o nome da variavel.
			Action action =  (Action) classe.getDeclaredConstructor().newInstance(); //cria instância da classe, já fazendo um cast p/ a interface 
			link = action.execute(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndereco = link.split(":"); 
		
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);	
		}else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}	
}