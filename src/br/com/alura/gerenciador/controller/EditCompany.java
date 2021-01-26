package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Bank;
import br.com.alura.gerenciador.model.Company;

public class EditCompany implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String companyName= request.getParameter("name");
		String companyDate = request.getParameter("date");
		String idCompany = request.getParameter("id");
		Integer id = Integer.valueOf(idCompany);
	
		Date openingDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = sdf.parse(companyDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
			
		Bank bank = new Bank();
		Company company = bank.hasId(id);
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		return "redirect:index?action=ListCompany";

	}
}
