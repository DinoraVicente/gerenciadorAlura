package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Bank;
import br.com.alura.gerenciador.model.User;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Bank bank = new Bank();	
		User user = bank.userExists(login, password);
		
		System.out.println("Logando " + login);

		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userLogged", user);
			
			return "redirect:index?action=ListCompany";
		}else {
			return "redirect:index?action=LoginForm";
		}
	}
}