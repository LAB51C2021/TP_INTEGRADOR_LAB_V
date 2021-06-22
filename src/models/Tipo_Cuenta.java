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
public class Tipo_Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	public Tipo_Cuenta()
	{
		
	}

	public Tipo_Cuenta(String nombre)
	{
		this.Nombre = nombre;
	}

	public Tipo_Cuenta(int idTipoCuenta)
	{
		this.Id_Tipo_Cuenta = idTipoCuenta;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Tipo_Cuenta;

	@Column(unique=true)
	private String Nombre;

	// Getters and Setters
	public int getId_Tipo_Cuenta() {
		return Id_Tipo_Cuenta;
	}

	public void setId_Tipo_Cuenta(int id_Tipo_Cuenta) {
		Id_Tipo_Cuenta = id_Tipo_Cuenta;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
