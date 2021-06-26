package models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class User {
	
	// Campos
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_User;

	@Column
	private String Nombre;
	
	@Column
	private String Apellido;

	@Column(unique=true)
	private String Dni;

	@Column
	private String Sexo;
	
	@Column
	private LocalDate Fecha_Nacimiento;

	@Column
	private String Direccion;

	@Column
	private String Localidad;
	
	@ManyToOne
	@JoinColumn(name="Id_Pais")
	private Pais Pais;

	@ManyToOne
	@JoinColumn(name="Id_Provincia")
	private Provincia Provincia;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Id_User")
	private UserType UserType;

	public int getId_User() {
		return Id_User;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public String getDni() {
		return Dni;
	}

	public String getSexo() {
		return Sexo;
	}

	public LocalDate getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public Pais getPais() {
		return Pais;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public UserType getUserType() {
		return UserType;
	}
	
}
