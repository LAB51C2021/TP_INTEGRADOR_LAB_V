package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hibernate.CuentaHibernate;
import hibernate.MovimientoHibernate;
import models.Cuenta;
import models.Usuario;

@Controller
public class MovimientoController 
{
	private int idCuenta = 0;
	
	@RequestMapping(value = "Movimientos.html", method = RequestMethod.GET)
	public ModelAndView Listado(HttpServletRequest request)
	{
		Integer id = Integer.valueOf(request.getParameter("id"));
		idCuenta = id == null ? idCuenta : id;

		CuentaHibernate cuentaHibernate = new CuentaHibernate();
		Cuenta cuenta = cuentaHibernate.GetId(idCuenta);
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("datosCuenta", "Cuenta N° " + cuenta.getNumero_Cuenta() + " - " + cuenta.getNombre());
		MV.addObject("cantidadRegistros", cuenta.getMovimiento().size());
		
		List movimientos = cuenta.getMovimiento();
		
		MV.addObject("listamovimientos", movimientos);
		MV.setViewName("Movimientos");
		return MV;
	}

	@RequestMapping("Transferencia.html")
	public ModelAndView NuevaTransferencia(HttpServletRequest request)
	{
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");
		CuentaHibernate cuentaHibernate = new CuentaHibernate();
		List listaCuentas = cuentaHibernate.GetAllByUser(user.getId_Usuario());
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("NuevaTransferencia");
		MV.addObject("id", idCuenta);
		MV.addObject("cuentaList", listaCuentas);
		
		return MV;
	}

	@RequestMapping(value="NuevaTransferencia.html", method = RequestMethod.POST)
	public ModelAndView ConfirmarTransferenciaPost(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");

		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaOrigen"));
		String cbuCuentaDestino = String.valueOf(request.getParameter("cbuDestino"));
		float monto = Float.parseFloat(request.getParameter("monto"));
		
		try
		{
			new MovimientoHibernate().NuevaTransferencia(idCuentaOrigen, cbuCuentaDestino, monto);
			MV.setViewName("HomeCliente");
		} 
		catch (Exception e) 
		{
			CuentaHibernate cuentaHibernate = new CuentaHibernate();
			List listaCuentas = cuentaHibernate.GetAllByUser(user.getId_Usuario());

			MV.setViewName("NuevaTransferencia");
			MV.addObject("cuentaList", listaCuentas);

			MV.addObject("cuentaOrigen", idCuentaOrigen);
			MV.addObject("cbuDestino", cbuCuentaDestino);
			MV.addObject("monto", monto);
			
			MV.addObject("error", e.getMessage());
		}

		return MV;
	}
	

	@RequestMapping(value="NuevaTransferencia.html")
	public ModelAndView ConfirmarTransferenciaGet(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("HomeCliente.html");
		
		return MV;
	}
}
