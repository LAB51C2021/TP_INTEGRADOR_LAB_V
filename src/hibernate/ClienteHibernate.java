package hibernate;

import java.time.LocalDate;
import java.util.List;

import models.Cuenta;
import models.Movimiento;
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
		return hibernateConnector.GetList(Persona.class.getSimpleName(), "EsCliente = 1 AND Habilitado = 1");
	}
	
	public void Actualizar(Persona cliente)
	{
		try {
			
			HibernateConnector hibernateConnector = new HibernateConnector();
			hibernateConnector.UpdateEntity(cliente);
			hibernateConnector.SaveChange();
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}

}
