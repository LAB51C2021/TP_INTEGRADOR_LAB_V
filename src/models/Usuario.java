package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Usuario()
	{
		
	}

	public Usuario(String nombre, String email, String clave, Persona persona, boolean habilitado, List<Cuenta> cuentas)
	{
		this.Nombre = nombre;
		this.Clave = clave;
		this.Persona = persona;
		this.Habilitado = habilitado;
		this.Cuentas = cuentas;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Usuario;

	@Column
	private String Nombre;
	
	@Column
	private String Clave;
	
	@Column
	private boolean Habilitado;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Id_Persona")
	private Persona Persona;
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cuenta> Cuentas = new ArrayList<>();
	
	@Override
	public String toString()
	{
		return Nombre;
	}
	
	// Getters and Setters
	public int getId_Usuario() {
		return Id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		Id_Usuario = id_Usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public boolean isHabilitado() {
		return Habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		Habilitado = habilitado;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}

	public List<Cuenta> getCuentas() {
		return Cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		Cuentas = cuentas;
	}
}
