package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hibernate.CuentaHibernate;
import hibernate.HibernateConnector;
import hibernate.MovimientoHibernate;
import models.Cuenta;
import models.Movimiento;
import models.Usuario;

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
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");
		CuentaHibernate cuentaHibernate = new CuentaHibernate();
		List listaCuentas = cuentaHibernate.GetAll(user.getId_Usuario());
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("NuevaTransferencia");
		MV.addObject("id", idCuenta);
		MV.addObject("cuenta", cuenta);
		
		MV.addObject("cuentaList", listaCuentas);
		
		return MV;
	}

	@RequestMapping(value= "ConfirmarTransferencia.html", method = RequestMethod.POST)
	public ModelAndView ConfirmarTransferenciaPost(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");
		
		try
		{
			CuentaHibernate cuentaHibernate = new CuentaHibernate();
			List listaCuentas = cuentaHibernate.GetAll(user.getId_Usuario());
			Cuenta cuentaOrigen = cuentaHibernate.GetId(Integer.parseInt(request.getParameter("cuentaOrigen")));
			Cuenta cuentaDestino = cuentaHibernate.GetCuentaPorCbu(request.getParameter("cbu"));
			Float monto = Float.parseFloat(request.getParameter("monto"));
			
			if(cuentaDestino == null) {
				List<String> listaErrores = new ArrayList<String>();
				listaErrores.add("No existe el CBU de destino.");
				MV.addObject("errores", listaErrores);
			}
			else {
				MV.addObject("id", cuentaOrigen.getId_Cuenta());
				MV.addObject("cuenta", cuentaOrigen);
				MV.addObject("cuentaList", listaCuentas);
				MovimientoHibernate movimientoHibernate = new MovimientoHibernate();
				movimientoHibernate.NuevaTransferencia(cuentaOrigen, cuentaDestino.getCbu(), monto);
			}
		} 
		catch (Exception e) 
		{
			System.out.print(e.getMessage());
		}

		MV.setViewName("NuevaTransferencia");
		return MV;
	}
}
