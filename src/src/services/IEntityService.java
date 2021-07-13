package src.services;

import java.util.List;

public interface IEntityService<T>
{
	T FirstOrDefault(int id);
	
	T FirstOrDefault(String where);
	
	List<T> GetAll();

	List<T> GetAll(String where);
	
	void Add(T entity);
	
	void Update(T entity);
	
	void Delete(T entity);
}
