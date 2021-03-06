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
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	public Movimiento()
	{
		
	}

	public Movimiento(LocalDate fecha, float monto, int idTipoMovimiento, Integer idCuentaOrigen, Integer idCuentaDestino)
	{
		this.Fecha = fecha;
		this.Monto = monto;
		
		this.Tipo_Movimiento = new Tipo_Movimiento(idTipoMovimiento);
		this.Cuenta_Origen = idCuentaOrigen != null ? new Cuenta(idCuentaOrigen) : null;
		this.Cuenta_Destino = idCuentaDestino != null ? new Cuenta(idCuentaDestino) : null;
	}
	
	// Campos
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Movimiento;

	@Column
	private LocalDate Fecha;

	@Column
	private float Monto;

	@ManyToOne
	@JoinColumn(name="Id_Tipo_Movimiento")
	private Tipo_Movimiento Tipo_Movimiento;

	@ManyToOne
	@JoinColumn(name="Id_Cuenta_Origen")
	private Cuenta Cuenta_Origen;

	@ManyToOne
	@JoinColumn(name="Id_Cuenta_Destino")
	private Cuenta Cuenta_Destino;
	// Getters and Setters

	public int getId_Movimiento() {
		return Id_Movimiento;
	}

	public void setId_Movimiento(int id_Movimiento) {
		Id_Movimiento = id_Movimiento;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public float getMonto() {
		return Tipo_Movimiento.getNombre().contains("Egreso") ? -(Monto) : Monto;
	}

	public void setMonto(float monto) {
		Monto = monto;
	}

	public Tipo_Movimiento getTipo_Movimiento() {
		return Tipo_Movimiento;
	}

	public void setTipo_Movimiento(Tipo_Movimiento tipo_Movimiento) {
		Tipo_Movimiento = tipo_Movimiento;
	}

	public Cuenta getCuenta_Origen() {
		return Cuenta_Origen;
	}

	public void setCuenta_Origen(Cuenta cuenta_Origen) {
		Cuenta_Origen = cuenta_Origen;
	}

	public Cuenta getCuenta_Destino() {
		return Cuenta_Destino;
	}

	public void setCuenta_Destino(Cuenta cuenta_Destino) {
		Cuenta_Destino = cuenta_Destino;
	}

	public String getCbuCuentaOrigen() {
		
		if (Tipo_Movimiento.getNombre().equals("Alta"))
		{
			return "-";
		}
		else
		{
			return Cuenta_Destino.getCbu();
		}
	}
	
	public String getSignoMoneda()
	{
		if (Cuenta_Origen != null)
		{
			return Cuenta_Origen.getTipo_Cuenta().getSigno_Moneda();
		}
		
		return "?";
	}
}
