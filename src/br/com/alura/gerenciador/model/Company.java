package br.com.alura.gerenciador.model;

import java.util.Date;

public class Company {
	
	private Integer id;
	private String name;
	private Date openingDate = new Date();
	
	public Company() {
	}
	
	public Company( String name) {
		this.name = name;
	}
	
	public Company( String name, Date openingDate) {
		this.name = name;
		this.openingDate = openingDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
}
