package models;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Table;

@Entity
@Table
public class Customer extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Customer() {
		super();
	}

	public Customer(int representante, String nombre, String apellido, String email, String dni, String sexo, LocalDate fecha_Nacimiento,
			String direccion, String localidad, int idPais, int idProvincia, int idUserType) {
		super(nombre, apellido, email, dni, sexo, fecha_Nacimiento, direccion, localidad, idPais, idProvincia,
				idUserType);
		this.Id_Representative = representante;
		//this.Id_Customer = this.getId_User();
	}

	public Customer(int representante, String nombre, String apellido, String email, String dni, String sexo, LocalDate fecha_Nacimiento,
			String direccion, String localidad, int idPais, int idProvincia, int idUserType, List<Cuenta> cuentas) {
		super(nombre, apellido, email, dni, sexo, fecha_Nacimiento, direccion, localidad, idPais, idProvincia,
				idUserType);
		this.Id_Representative = representante;
		//this.Id_Customer = this.getId_User();
		Cuentas = cuentas;
	}

	@Column
	private int Id_Representative;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_User")
	private List<Cuenta> Cuentas = new ArrayList<>();

}
