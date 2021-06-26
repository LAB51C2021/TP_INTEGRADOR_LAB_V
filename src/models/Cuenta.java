package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	public Cuenta()
	{
		
	}
	
	public Cuenta(int idTipoCuenta, String dniTitular, int nroCuenta)
	{
		this.Fecha_Creacion = LocalDate.now();
		this.Cbu = generateCBU(dniTitular + nroCuenta);
		this.Tipo_Cuenta = new Tipo_Cuenta(idTipoCuenta);
	}
	
	public Cuenta(int idCuenta)
	{
		this.Id_Cuenta = idCuenta;
	}
	
	private String generateCBU(String numero) {
		int n = 22;
		StringBuilder sb = new StringBuilder(n);
		
		for (int i = 0; i < n; i++) {
		int index
		= (int)(numero.length()
		    * Math.random());
		
		// add Character one by one in end of sb
		sb.append(numero
		      .charAt(index));
		}
			
		String ret = sb.toString();
		return ret;
	}
	
	// Campos
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Cuenta;
	
	@Column
	private LocalDate Fecha_Creacion;

	@Column(unique=true)
	private String Cbu;

	@Column
	private float Saldo = 0;
	
	@ManyToOne
	@JoinColumn(name="Id_Tipo_Cuenta")
	Tipo_Cuenta Tipo_Cuenta;
	
	@Column
	private String Status = "A";
	
	// Getters and Setters
	public int getId_Cuenta() {
		return Id_Cuenta;
	}

	public void setId_Cuenta(int id_Cuenta) {
		Id_Cuenta = id_Cuenta;
	}

	public LocalDate getFecha_Creacion() {
		return Fecha_Creacion;
	}

	public void setFecha_Creacion(LocalDate fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}

	public String getCbu() {
		return Cbu;
	}

	public void setCbu(String cbu) {
		Cbu = cbu;
	}

	public float getSaldo() {
		return Saldo;
	}

	public void setSaldo(float saldo) {
		Saldo = saldo;
	}

	public Tipo_Cuenta getTipo_Cuenta() {
		return Tipo_Cuenta;
	}

	public void setTipo_Cuenta(Tipo_Cuenta tipo_Cuenta) {
		Tipo_Cuenta = tipo_Cuenta;
	}
}
