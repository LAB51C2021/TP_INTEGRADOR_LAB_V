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
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pais()
	{
		
	}

	public Pais(String nombre)
	{
		this.Nombre = nombre;
	}

	public Pais(int idPais)
	{
		this.Id_Pais = idPais;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Pais;

	@Column(unique=true)
	private String Nombre;
	
	@Column
	private String Status = "A";

	// Getters and Setters
	public int getId_Pais() {
		return Id_Pais;
	}

	public void setId_Pais(int id_Pais) {
		Id_Pais = id_Pais;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
