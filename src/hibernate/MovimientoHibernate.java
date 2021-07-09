package hibernate;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Cuenta;
import models.Movimiento;

public class MovimientoHibernate 
{
	public void NuevaTransferencia(int idCuentaOrigen, String cbuCuentaDestino, float monto) throws Exception
	{
		HibernateConnector hibernateConnector = new HibernateConnector();
		CuentaHibernate cuentaHibernate = new CuentaHibernate();

		Cuenta cuentaDestino = cuentaHibernate.GetCuentaPorCbu(cbuCuentaDestino);

		if (cuentaDestino == null)
		{
			throw new Exception("La cuenta destino ingresada no existe en el sistema.");
		}
		
		if (idCuentaOrigen == cuentaDestino.getId_Cuenta())
		{
			throw new Exception("No es posible transferir dinero a la misma cuenta.");
		}
		
		Cuenta cuentaOrigen = cuentaHibernate.GetId(idCuentaOrigen);

		if (cuentaDestino.getTipo_Cuenta() == cuentaOrigen.getTipo_Cuenta())
		{
			throw new Exception("No es posible realizar una transferencia a un tipo de cuenta distinta.");
		}
		
		if (cuentaOrigen.getSaldo() < monto)
		{
			throw new Exception("Saldo insuficiente en la cuenta para realizar esta operación.");
		}

		cuentaOrigen.setRestarSaldo(monto);
		hibernateConnector.UpdateEntity(cuentaOrigen);
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), monto, 3, cuentaOrigen.getId_Cuenta(), cuentaDestino.getId_Cuenta()));

		cuentaDestino.setSumarSaldo(monto);
		hibernateConnector.UpdateEntity(cuentaDestino);
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), monto, 2, cuentaDestino.getId_Cuenta(), cuentaDestino.getId_Cuenta()));

		hibernateConnector.SaveChange();
	}
}
