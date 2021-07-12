package src.services;

import java.util.List;

import models.Persona;

public interface ClienteServiceInterface {
	
	Persona get(Integer id);
	
	List<Object> getAll();
	
	void add(Persona cliente);
	
	void update(Persona cliente);
} 
