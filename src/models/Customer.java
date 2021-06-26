package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Customer extends User {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Customer;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="Id_Customer")
	private List<Cuenta> Cuentas = new ArrayList<>();

}
