package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.model.Bank;
import br.com.alura.gerenciador.model.Company;

@WebServlet("/company")
public class CompanyService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Company> companies = new Bank().getCompany();
	
		String requestType = request.getHeader("Accept");
		
		System.out.println(requestType);
		
		if(requestType.contains("xml")) {
			
			XStream xstream = new XStream();
			xstream.alias("company", Company.class);
			String xml = xstream.toXML(companies);
		
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			
		} else if(requestType.contains("json")) {
			
			Gson gson = new Gson();
			String json = gson.toJson(companies);
		
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message': 'no content'}");
		}
	}
}