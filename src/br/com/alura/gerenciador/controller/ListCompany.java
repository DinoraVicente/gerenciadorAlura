package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Bank;
import br.com.alura.gerenciador.model.Company;

//Isso são chamados comandos, eles encapsulam a execução de alguma coisa.
public class ListCompany implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Bank bank = new Bank();
		List<Company> list = bank.getCompany(); 
		
		request.setAttribute("companyList", list);
		
		return "forward:listCompany.jsp";
	}
}
