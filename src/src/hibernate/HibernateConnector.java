package src.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import models.Cuenta;
import models.Persona;
import models.Tipo_Cuenta;
import models.Usuario;

public class HibernateConnector 
{
	private SessionFactory sessionFactory;
	private Session session;
	private boolean isTransaction;

	public HibernateConnector()
	{
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
		this.isTransaction = false;
	}
	
	private void AbrirConexion()
	{
		if (session == null && sessionFactory != null)
		{
	    	session = sessionFactory.openSession();
		}
	}
	
	private void CerrarConexion()
	{
		session.close();
		session = null;
	}
	
	private void StartTransaction()
	{
		AbrirConexion();
		
		if (!isTransaction)
		{
			isTransaction = true;
			session.beginTransaction();
		}
	}

	private void CloseTransaction()
	{
		if (isTransaction)
		{
			session.getTransaction().commit();
			isTransaction = false;
			
			CerrarConexion();
		}
	}
	
	public void AddEntity(Object entity)
	{
		StartTransaction();
		session.save(entity);
		SaveChange();
	}
	
	public void UpdateEntity(Object entity)
	{
		StartTransaction();
		session.update(entity);
		SaveChange();
	}
	
	public void DeleteEntity(Object entity)
	{
		StartTransaction();
		session.delete(entity);
		SaveChange();
	}
	
	public void SaveChange()
	{
		CloseTransaction();
	}
	
	public Object GetEntityKey(int key, String table)
	{
		AbrirConexion();
		Object entity = session.get(table, key);
		CerrarConexion();

		return entity;
	}
	
	public int GetCountRegistry(String table)
	{
		AbrirConexion();
		Long count = (Long) session.createQuery("SELECT COUNT(*) FROM " + table).uniqueResult();
		CerrarConexion();

		return count.intValue();
	}
	
	public Object GetRegistry(String table, String where)
	{
		AbrirConexion();
		Object registry = (Object) session.createSQLQuery("SELECT FROM " + table + " WHERE " + where).uniqueResult();
		CerrarConexion();

		return registry;
	}
	
	public List<Object> GetList(String table)
	{
		AbrirConexion();
		List<Object> registryList = session.createQuery("FROM " + table).list();
		CerrarConexion();

		return registryList;
	}
	
	public List<Object> GetList(String table, String where)
	{
		AbrirConexion();
		List<Object> registryList = session.createQuery("FROM " + table + " WHERE " + where).list();
		CerrarConexion();

		return registryList;
	}
	
	public Usuario GetUserByCredentials(String nombre, String dni, String clave)
	{
		AbrirConexion();
		
		Query query = session.createQuery("FROM " + Usuario.class.getSimpleName() + " WHERE nombre=:nombre AND clave=:clave");
		query.setParameter("nombre", nombre);
		query.setParameter("clave", clave);
		
		Usuario foundUser = (Usuario) query.uniqueResult();
		CerrarConexion();

		return foundUser;
	}
	
	public Persona ValidateDNI(String dni)
	{
		AbrirConexion();
		
		Query query = session.createQuery("FROM " + Persona.class.getSimpleName() + " WHERE EsCliente = 1 AND Habilitado = 1 AND DNI= :dni");
		query.setParameter("dni", dni);
		
		Persona foundUser = (Persona) query.uniqueResult();
		CerrarConexion();

		return foundUser;
	}
	
	public Cuenta GetAccountByCredentials(String cbu)
	{
		AbrirConexion();
		
		Query query = session.createQuery("FROM " + Cuenta.class.getSimpleName() + " WHERE cbu=:cbu");
		query.setParameter("cbu", cbu);
		
		Cuenta foundAccount = (Cuenta)query.uniqueResult();
		CerrarConexion();

		return foundAccount;
	}	
	
	public Object GetFirstOrDefaultWhere(String table, String where)
	{
		AbrirConexion();
		
		Query query = session.createQuery("FROM " + table + " WHERE " + where);
		
		Cuenta foundAccount = (Cuenta)query.uniqueResult();
		CerrarConexion();

		return foundAccount;
	}

	public Cuenta ValidateNroCuenta(String nroCuenta) {
		AbrirConexion();
		
		Query query = session.createQuery("FROM " + Cuenta.class.getSimpleName() + " WHERE Habilitado = 1 AND Numero_Cuenta= :nro");
		query.setParameter("nro", nroCuenta);
		
		Cuenta foundCuenta = (Cuenta) query.uniqueResult();
		CerrarConexion();
		
		return foundCuenta;
	}

	public List<Cuenta> GetAllCuentasByUser(String userID) {
		AbrirConexion();
		Query query = session.createQuery("FROM Cuenta WHERE Habilitado = 1 AND Id_Usuario=:user");
		query.setParameter("user", userID);
		List<Cuenta> registryList = query.list();
		CerrarConexion();

		return registryList;
	}	
}
