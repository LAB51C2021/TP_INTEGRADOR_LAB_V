package src.services;

import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.Cuenta;
import src.hibernate.HibernateConnector;

public class EntityService<T> implements IEntityService<T>
{
	private T entity;
	
	public EntityService(T entity)
	{
		this.entity = entity;
	}

	@Autowired
	private HibernateConnector hibernateConnector;
	
	@Override
	public T FirstOrDefault(int id) 
	{
		return (T) hibernateConnector.GetEntityKey(id, entity.getClass().getName());
	}

	@Override
	public T FirstOrDefault(String where) 
	{
		return (T) hibernateConnector.GetFirstOrDefaultWhere(entity.getClass().getName(), where);
	}

	@Override
	public List<T> GetAll() 
	{
		return (List<T>) hibernateConnector.GetList(entity.getClass().getName());
	}
	
	@Override
	public List<T> GetAll(String where) {
		return (List<T>) hibernateConnector.GetList(Cuenta.class.getSimpleName(), where);
	}

	@Override
	public void Add(T entity) 
	{
		hibernateConnector.AddEntity(entity);
	}

	@Override
	public void Update(T entity) 
	{
		hibernateConnector.UpdateEntity(entity);
	}

	@Override
	public void Delete(T entity) 
	{
		hibernateConnector.DeleteEntity(entity);
	}
}
