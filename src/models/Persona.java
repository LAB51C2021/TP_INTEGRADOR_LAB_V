package models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Persona()
	{
		
	}
	
	public Persona(String nombreApellido, String dni, String sexo, LocalDate fechaNacimiento,
			String direccion, String localidad, int idPais, int idProvincia, boolean esCliente, boolean habilitado)
	{
		this.Nombre_Apellido = nombreApellido;
		this.Dni = dni;
		this.Sexo = sexo;
		this.Fecha_Nacimiento = fechaNacimiento;
		this.Direccion = direccion;
		this.Localidad = localidad;
		this.EsCliente = esCliente;
		this.Pais = new Pais(idPais);
		this.Provincia = new Provincia(idProvincia);
		this.Habilitado = habilitado;
	}
	
	// Campos
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Cliente;

	@Column
	private String Nombre_Apellido;

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

	@Column
	private boolean EsCliente;
	
	@Column
	private boolean Habilitado;
	
	@ManyToOne
	@JoinColumn(name="Id_Pais")
	private Pais Pais;

	@ManyToOne
	@JoinColumn(name="Id_Provincia")
	private Provincia Provincia;
	
	@OneToOne(mappedBy = "Persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Usuario Usuario;

	// Getters and Setters
	public int getId_Cliente() {
		return Id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}
	public String getNombre_Apellido() {
		return Nombre_Apellido;
	}
	public void setNombre_Apellido(String nombre_Apellido) {
		Nombre_Apellido = nombre_Apellido;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public LocalDate getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(LocalDate fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public boolean isEsCliente() {
		return EsCliente;
	}

	public void setEsCliente(boolean esCliente) {
		EsCliente = esCliente;
	}

	public boolean isHabilitado() {
		return Habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		Habilitado = habilitado;
	}

	public Pais getPais() {
		return Pais;
	}

	public void setPais(Pais pais) {
		Pais = pais;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}
	public Usuario getUsuario() {
		return Usuario;
	}
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	@Override
	public String toString() {
		return Nombre_Apellido;
	}
		
}
