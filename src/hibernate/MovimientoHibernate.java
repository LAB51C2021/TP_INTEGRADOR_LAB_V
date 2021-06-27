package hibernate;

import java.util.List;

import models.Cuenta;

public class MovimientoHibernate 
{
	public List<Object> GetAll(int idCuenta)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		
		return hibernateConnector.GetList(Cuenta.class.getSimpleName(), "Id_Usuario = " + idCuenta);
	}
}
