package controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hibernate.CuentaHibernate;
import hibernate.HibernateConnector;
import hibernate.MovimientoHibernate;
import models.Cuenta;
import models.Movimiento;

@Controller
public class MovimientoController 
{
	private Cuenta cuenta;
	private int idCuenta = 0;
	
	@RequestMapping(value = "Movimientos.html", method = RequestMethod.GET)
	public ModelAndView Listado(HttpServletRequest request)
	{
		Integer id = Integer.valueOf(request.getParameter("id"));
		idCuenta = id == null ? idCuenta : id;

		CuentaHibernate cuentaHibernate = new CuentaHibernate();
		cuenta = cuentaHibernate.GetId(idCuenta);
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("datosCuenta", "Cuenta N° " + cuenta.getNumero_Cuenta() + " - " + cuenta.getNombre());
		MV.addObject("cantidadRegistros", cuenta.getMovimiento().size());
		
		List movimientos = cuenta.getMovimiento();
		
		MV.addObject("listamovimientos", movimientos);
		MV.setViewName("Movimientos");
		return MV;
	}

	@RequestMapping("NuevaTransferencia.html")
	public ModelAndView NuevaTransferencia(HttpServletRequest request)
	{
		CuentaHibernate cuentaHibernate = new CuentaHibernate();
		List listaCuentas = cuentaHibernate.GetAll(idCuenta);
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("NuevaTransferencia");
		MV.addObject("id", idCuenta);
		MV.addObject("cuenta", cuenta);
		
		MV.addObject("cuentaList", listaCuentas);
		
		return MV;
	}

	@RequestMapping("ConfirmarTransferencia.html")
	public ModelAndView ConfirmarTransferenciaPost(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();

		try
		{
			Cuenta cuentaOrigen =  cuenta;//request.getParameter("cuentaOrigen"); HAY QUE AGARRAR EL OBJECT DEL COMBOBOX CON LA CUENTA SELECCIONADA
			String cbu = request.getParameter("cbu");
			Float monto = Float.parseFloat(request.getParameter("monto"));
			
			MovimientoHibernate movimientoHibernate = new MovimientoHibernate();
			movimientoHibernate.NuevaTransferencia(cuenta, cbu, monto);
			MV.setViewName("HomeCliente");
		} 
		catch (Exception e) 
		{
			System.out.print(e.getMessage());
			MV.setViewName("NuevaTransferencia");
		}
		
		return MV;
	}
}
