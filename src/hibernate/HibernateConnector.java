package hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import models.LogonUser;

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
	}
	
	public void UpdateEntity(Object entity)
	{
		StartTransaction();
		session.update(entity);
	}
	
	public void DeleteEntity(Object entity)
	{
		StartTransaction();
		session.delete(entity);
	}
	
	public void SaveChange()
	{
		CloseTransaction();
	}
	
	public Object GetEntityKey(int key, String table)
	{
		StartTransaction();
		Object entity = session.get(table, key);
		CloseTransaction();

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
	
	public LogonUser GetUserByCredentials(String table, String username, String password)
	{
		AbrirConexion();
		
		Query query = session.createQuery("FROM " + table + " WHERE username= :username AND password= :password AND Status = 'A'");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		LogonUser foundUser = (LogonUser) query.uniqueResult();
		CerrarConexion();

		return foundUser;
	}
}
