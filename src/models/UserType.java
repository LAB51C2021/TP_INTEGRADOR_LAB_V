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
public class UserType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public UserType() {

	}
	
	public UserType(int idUserType) {
		this.Id_User_Type = idUserType;
	}

	public UserType(String descripcion) {
		this.Descripcion = descripcion;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_User_Type;

	@Column(unique=true)
	private String Descripcion;
	
	@Column
	private String Status = "A";

	public int getId_User_Type() {
		return Id_User_Type;
	}

	public void setId_User_Type(int id_User_Type) {
		Id_User_Type = id_User_Type;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
