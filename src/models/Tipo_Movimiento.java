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
public class Tipo_Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	public Tipo_Movimiento()
	{
		
	}

	public Tipo_Movimiento(String nombre)
	{
		this.Nombre = nombre;
	}
	
	public Tipo_Movimiento(int idTipoMovimiento)
	{
		this.Id_Tipo_Movimiento = idTipoMovimiento;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Tipo_Movimiento;

	@Column(unique=true)
	private String Nombre;

	// Getters and Setters
	public int getId_Tipo_Movimiento() {
		return Id_Tipo_Movimiento;
	}

	public void setId_Tipo_Movimiento(int id_Tipo_Movimiento) {
		Id_Tipo_Movimiento = id_Tipo_Movimiento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
