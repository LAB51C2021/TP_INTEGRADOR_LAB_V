package src.hibernate;

import java.time.LocalDate;
import java.util.List;

import models.Cuenta;
import models.Movimiento;
import models.Pais;
import models.Persona;
import models.Provincia;

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
	
	public void Grabar(Persona cliente)
	{
		try {
			
			HibernateConnector hibernateConnector = new HibernateConnector();
			hibernateConnector.AddEntity(cliente);
			hibernateConnector.SaveChange();
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	public List<Object> getProvincias()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Provincia.class.getSimpleName(), "1 = 1");
	}
	
	public List<Object> getPaises()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Pais.class.getSimpleName(), "1 = 1");
	}

	public boolean ValidateDNI(String dni) {
		HibernateConnector hibernateConnector = new HibernateConnector();
		Persona persona = hibernateConnector.ValidateDNI(dni);
		
		if(persona != null) {
			return true;
		}else {
			return false;
		}
	}

}
