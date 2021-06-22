package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
	
	public Cuenta(String nombre, LocalDate fechaCreacion, String numeroCuenta, String cbu, float saldo, int idTipoCuenta)
	{
		this.Nombre = nombre;
		this.Fecha_Creacion = fechaCreacion;
		this.Numero_Cuenta = numeroCuenta;
		this.Cbu = cbu;
		this.Saldo = saldo;
		this.Tipo_Cuenta = new Tipo_Cuenta(idTipoCuenta);
	}

	public Cuenta(int idCuenta)
	{
		this.Id_Cuenta = idCuenta;
	}
	
	// Campos
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Cuenta;

	@Column
	private String Nombre;
	
	@Column
	private LocalDate Fecha_Creacion;

	@Column(unique=true)
	private String Numero_Cuenta;

	private String Cbu;

	@Column
	private float Saldo;
	
	@ManyToOne
	@JoinColumn(name="Id_Tipo_Cuenta")
	Tipo_Cuenta Tipo_Cuenta;
	
	// Getters and Setters
	public int getId_Cuenta() {
		return Id_Cuenta;
	}

	public void setId_Cuenta(int id_Cuenta) {
		Id_Cuenta = id_Cuenta;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public LocalDate getFecha_Creacion() {
		return Fecha_Creacion;
	}

	public void setFecha_Creacion(LocalDate fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}

	public String getNumero_Cuenta() {
		return Numero_Cuenta;
	}

	public void setNumero_Cuenta(String numero_Cuenta) {
		Numero_Cuenta = numero_Cuenta;
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
