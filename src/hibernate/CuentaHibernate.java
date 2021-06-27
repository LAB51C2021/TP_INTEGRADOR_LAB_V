package hibernate;

import java.util.List;

import models.Cuenta;

public class CuentaHibernate 
{
	public List<Object> GetAll(int idUser)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Cuenta.class.getSimpleName(), "Id_Usuario = " + idUser);
	}
	
	public Cuenta GetId(int idCuenta)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Cuenta) hibernateConnector.GetEntityKey(idCuenta, Cuenta.class.getName());
	}
}
