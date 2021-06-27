package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	public Provincia()
	{
		
	}
	
	public Provincia(String nombre)
	{
		Nombre = nombre;
	}
	
	public Provincia(int idProvincia)
	{
		Id_Provincia = idProvincia;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Provincia;

	@Column(unique=true)
	private String Nombre;

	// Getters and Setters
	public int getId_Provincia() {
		return Id_Provincia;
	}

	public void setId_Provincia(int id_Provincia) {
		Id_Provincia = id_Provincia;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
