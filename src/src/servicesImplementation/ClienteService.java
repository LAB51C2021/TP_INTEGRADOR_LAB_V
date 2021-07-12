package src.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import models.Persona;
import src.hibernate.ClienteHibernate;
import src.services.ClienteServiceInterface;

public class ClienteService implements ClienteServiceInterface {

	@Autowired
	private ClienteHibernate clienteHibernate;
	
	@Override
	public Persona get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		return clienteHibernate.GetAllClientes();
	}

	@Override
	public void add(Persona cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Persona cliente) {
		// TODO Auto-generated method stub
	}

}
