package hibernate;

import java.util.List;

import models.Persona;

public class ClienteHibernate {
	
	public Persona GetCliente(int idPersona)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Persona) hibernateConnector.GetEntityKey(idPersona, Persona.class.getName());
	}
	
	public List<Object> GetAllClientes()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Persona.class.getSimpleName(), "EsCliente = 1");
	}

}
