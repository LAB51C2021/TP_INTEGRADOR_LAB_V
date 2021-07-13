package src.hibernate;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Cuenta;
import models.Movimiento;
import src.services.IEntityService;

public class MovimientoHibernate 
{
	private IEntityService<Cuenta> cuentaService;
	private IEntityService<Movimiento> movimientoService;
	
	public MovimientoHibernate(IEntityService<Cuenta> cuentaService, 
			IEntityService<Movimiento> movimientoService)
	{
		this.cuentaService = cuentaService;
		this.movimientoService = movimientoService;
	}
	
	public void NuevaTransferencia(int idCuentaOrigen, String cbuCuentaDestino, float monto) throws Exception
	{
		Cuenta cuentaDestino = cuentaService.FirstOrDefault("cbu = " + cbuCuentaDestino);

		if (cuentaDestino == null)
		{
			throw new Exception("La cuenta destino ingresada no existe en el sistema.");
		}
		
		if (idCuentaOrigen == cuentaDestino.getId_Cuenta())
		{
			throw new Exception("No es posible transferir dinero a la misma cuenta.");
		}
		
		Cuenta cuentaOrigen = cuentaService.FirstOrDefault(idCuentaOrigen);

		if (cuentaDestino.getTipo_Cuenta() == cuentaOrigen.getTipo_Cuenta())
		{
			throw new Exception("No es posible realizar una transferencia a un tipo de cuenta distinta.");
		}
		
		if (cuentaOrigen.getSaldo() < monto)
		{
			throw new Exception("Saldo insuficiente en la cuenta para realizar esta operación.");
		}

		cuentaOrigen.setRestarSaldo(monto);
		
		cuentaService.Update(cuentaOrigen);
		movimientoService.Add(new Movimiento(LocalDate.now(), monto, 3, cuentaOrigen.getId_Cuenta(), cuentaDestino.getId_Cuenta()));

		cuentaDestino.setSumarSaldo(monto);
		cuentaService.Update(cuentaDestino);
		movimientoService.Add(new Movimiento(LocalDate.now(), monto, 2, cuentaDestino.getId_Cuenta(), cuentaOrigen.getId_Cuenta()));
	}
}
