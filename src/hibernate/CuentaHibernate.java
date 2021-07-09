package hibernate;

import java.util.List;

import models.Cuenta;

public class CuentaHibernate 
{
	public List<Object> GetAllByUser(int idUser)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Cuenta.class.getSimpleName(), "Id_Usuario = " + idUser);
	}
	
	public Cuenta GetId(int idCuenta)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Cuenta) hibernateConnector.GetEntityKey(idCuenta, Cuenta.class.getName());
	}
	
	public List<Object> GetAll(int idUsuario)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Cuenta.class.getSimpleName(), "Id_Usuario = " + idUsuario);
	}
	
	public Cuenta GetCuentaPorCbu(String cbu)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Cuenta) hibernateConnector.GetAccountByCredentials(cbu);
	}
}
