package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

//Isso são chamados comandos, eles encapsulam a execução de alguma coisa.
public class ListaEmpresas implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas(); 
		
		request.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";
	}
}
