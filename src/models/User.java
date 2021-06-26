package models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public User(String nombre, String apellido, String email, String dni, String sexo, LocalDate fecha_Nacimiento,
			String direccion, String localidad, int idPais, int idProvincia, int idUserType) {
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Dni = dni;
		Sexo = sexo;
		Fecha_Nacimiento = fecha_Nacimiento;
		Direccion = direccion;
		Localidad = localidad;
		this.Pais = new Pais(idPais);
		this.Provincia = new Provincia(idProvincia);
		this.UserType = new UserType(idUserType);
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_User;

	@Column
	private String Nombre;
	
	@Column
	private String Apellido;
	
	@Column
	private String Email;

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
	
	@ManyToOne
    @JoinColumn(name = "Id_User_Type")
	private UserType UserType;
	
	@Column
	private String Status = "A";

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

