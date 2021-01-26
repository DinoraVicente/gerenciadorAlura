package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
	
	private static List<Company> listCompany = new ArrayList<Company>();
	private static List<User> listUser = new ArrayList<User>();

	private static Integer key = 1;
	
	static {
		Company company = new Company();
		company.setId(key++);
		company.setName("Alura");
		
		Company company2 = new Company();
		company2.setId(key++);
		company2.setName("Caelum");
		
		listCompany.add(company);
		listCompany.add(company2);
		
		User u1 = new User("dondi", "123");
		User u2 = new User("oscar", "123");
		
		listUser.add(u1);
		listUser.add(u2);
	}

	public void addCompany(Company company) {
		company.setId(Bank.key++);
		listCompany.add(company);
	}
	
	public void removeCompany(Integer id) {
		Iterator<Company> it = listCompany.iterator();
		while(it.hasNext()) {
			Company comp = it.next();
			
			if(comp.getId() == id) {
				it.remove();
			}
		}
	}
	
	public List<Company> getCompany(){
		return Bank.listCompany;
	}

	public Company hasId(Integer id) {
		for (Company comp : listCompany) {
			if(comp.getId() == id) {
				return comp;
			}
		}
		return null;
	}

	public User userExists(String login, String password) {
		for(User user : listUser) {
			if(user.userExists(login, password)) {
				return user;
			}
		}
		return null;
	}
}
