package src.hibernate;

import java.util.List;

import models.Cuenta;
import models.Persona;
import models.Tipo_Cuenta;

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
	
	public List<Object> GetAll()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Cuenta.class.getSimpleName());
	}
	
	public Cuenta GetCuentaPorCbu(String cbu)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Cuenta) hibernateConnector.GetAccountByCredentials(cbu);
	}
	
	public Tipo_Cuenta GetTipoCuenta(int idTipoCuenta)
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return (Tipo_Cuenta) hibernateConnector.GetEntityKey(idTipoCuenta, Tipo_Cuenta.class.getName());
	}
	
	public List<Object> GetTiposCuenta()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		return hibernateConnector.GetList(Tipo_Cuenta.class.getSimpleName());
	}
	
	public void Actualizar(Cuenta cuenta)
	{
		try {
			
			HibernateConnector hibernateConnector = new HibernateConnector();
			hibernateConnector.UpdateEntity(cuenta);
			hibernateConnector.SaveChange();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public void Grabar(Cuenta cuenta)
	{
		try {
			
			HibernateConnector hibernateConnector = new HibernateConnector();
			hibernateConnector.AddEntity(cuenta);
			hibernateConnector.SaveChange();
		}catch(Exception ex) {
			throw ex;
		}
	}
}
