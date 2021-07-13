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
	
	// Devuelve una entidad de la base de datos con la ID que se pase por parametro.
	@Override
	public T FirstOrDefault(int id) 
	{
		return (T) hibernateConnector.GetEntityKey(id, entity.getClass().getName());
	}

	
	// Devuelve una entidad de la base de datos con el where que se pasa por parametro.
	@Override
	public T FirstOrDefault(String where) 
	{
		return (T) hibernateConnector.GetFirstOrDefaultWhere(entity.getClass().getName(), where);
	}

	// Devuelve una lista con todos los registros.
	@Override
	public List<T> GetAll() 
	{
		return (List<T>) hibernateConnector.GetList(entity.getClass().getName());
	}

	// Devuelve una lista con todos los registros que cumplan con where que se pasa por parametro.
	@Override
	public List<T> GetAll(String where) {
		return (List<T>) hibernateConnector.GetList(entity.getClass().getName(), where);
	}

	// Agrega una nueva entidad.
	@Override
	public void Add(T entity) 
	{
		hibernateConnector.AddEntity(entity);
	}

	// Modificar una entidad, siempre enviar la instancia que se obtenga en el FirstOrDefault.
	@Override
	public void Update(T entity) 
	{
		hibernateConnector.UpdateEntity(entity);
	}

	// Elimina una entidad, siempre enviar la instancia que se obtenga en el FirstOrDefault.
	@Override
	public void Delete(T entity) 
	{
		hibernateConnector.DeleteEntity(entity);
	}
}
