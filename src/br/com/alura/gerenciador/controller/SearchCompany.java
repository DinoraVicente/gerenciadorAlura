package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Bank;
import br.com.alura.gerenciador.model.Company;

public class SearchCompany implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Bank bank = new Bank();
		Company company = bank.hasId(id);
			
		request.setAttribute("company", company);
		
		return "forward:formEditCompany.jsp";
	}
}
