package src.services;

import java.util.List;

public interface IEntityService<T>
{
	// Devuelve una entidad de la base de datos con la ID que se pase por parametro.
	T FirstOrDefault(int id);

	// Devuelve una entidad de la base de datos con el where que se pasa por parametro.
	T FirstOrDefault(String where);

	// Devuelve una lista con todos los registros.
	List<T> GetAll();

	// Devuelve una lista con todos los registros que cumplan con where que se pasa por parametro.
	List<T> GetAll(String where);

	// Agrega una nueva entidad.
	void Add(T entity);

	// Modificar una entidad, siempre enviar la instancia que se obtenga en el FirstOrDefault.
	void Update(T entity);

	// Elimina una entidad, siempre enviar la instancia que se obtenga en el FirstOrDefault.
	void Delete(T entity);
}
