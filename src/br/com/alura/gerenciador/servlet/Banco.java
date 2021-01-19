package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresa = new ArrayList<Empresa>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		listaEmpresa.add(empresa);
		listaEmpresa.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		listaEmpresa.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresa;
	}
}
