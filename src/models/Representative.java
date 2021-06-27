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
public class Representative extends User implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public Representative() {
		super();
	}

	public Representative(String nombre, String apellido, String email, String dni, String sexo,
			LocalDate fecha_Nacimiento, String direccion, String localidad, int idPais, int idProvincia,
			int idUserType) {
		super(nombre, apellido, email, dni, sexo, fecha_Nacimiento, direccion, localidad, idPais, idProvincia,
				idUserType);
		//this.Id_Representative = this.getId_User();
	}

	public Representative(String nombre, String apellido, String email, String dni, String sexo,
			LocalDate fecha_Nacimiento, String direccion, String localidad, 
			int idPais, int idProvincia, int idUserType, List<Customer> clientes) {
		super(nombre, apellido, email, dni, sexo, fecha_Nacimiento, direccion, localidad, idPais, idProvincia,
				idUserType);
		Clientes = clientes;
		//this.Id_Representative = this.getId_User();
	}
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_User")
	private List<Customer> Clientes = new ArrayList<>();
}
