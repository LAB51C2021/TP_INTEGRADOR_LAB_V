package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import helper.ViewHelper;

@Entity
@Table
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	public Cuenta()
	{
		
	}
	
	public Cuenta(String nombre, LocalDate fechaCreacion, String cbu, String numeroCuenta, float saldo, int idTipoCuenta, boolean habilitado)
	{
		this.Nombre = nombre;
		this.Fecha_Creacion = fechaCreacion;
		this.Cbu = cbu;
		this.Numero_Cuenta = numeroCuenta;
		this.Saldo = saldo;
		this.Tipo_Cuenta = new Tipo_Cuenta(idTipoCuenta);
		this.Habilitado = habilitado;
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

	@Column(unique=true)
	private String Cbu;

	@Column
	private boolean Habilitado;
	
	@Column
	private float Saldo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Id_Tipo_Cuenta")
	Tipo_Cuenta Tipo_Cuenta;
	
    @ManyToOne()
    @JoinColumn(name = "Id_Usuario")
    private Usuario Usuario;

    @OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
    @JoinColumn(name="Id_Cuenta_Origen")
	private List<Movimiento> Movimiento = new ArrayList<>();
	
    @Override
    public String toString()
    {
    	return ViewHelper.GetLetraPorTipo(getTipo_Cuenta()) + " N° " + Numero_Cuenta + " - " + getTipo_Cuenta().getSigno_Moneda() + " " + Saldo;
    }
    
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

	public void setSumarSaldo(float monto) {
		Saldo += monto;
	}

	public void setRestarSaldo(float monto) {
		Saldo -= monto;
	}
	
	public boolean isHabilitado() {
		return Habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		Habilitado = habilitado;
	}
	
	public Tipo_Cuenta getTipo_Cuenta() {
		return Tipo_Cuenta;
	}

	public void setTipo_Cuenta(Tipo_Cuenta tipo_Cuenta) {
		Tipo_Cuenta = tipo_Cuenta;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public List<Movimiento> getMovimiento() {
		return Movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		Movimiento = movimiento;
	}
}
