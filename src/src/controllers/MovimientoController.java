package src.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Cuenta;
import models.Movimiento;
import models.Usuario;
import src.hibernate.MovimientoHibernate;
import src.services.IEntityService;

@Controller
public class MovimientoController 
{
	List<Cuenta> cuentasList;
	
	private List<Cuenta> GetCuentaList(int idUser)
	{
		if (cuentasList == null)
		{
			cuentasList = cuentaService.GetAll("Id_Usuario = " + idUser);
		}
		
		return cuentasList;
	}
	
	@Autowired
	private IEntityService<Cuenta> cuentaService;
	
	@Autowired
	private IEntityService<Movimiento> movimientoService;
	
	private int idCuenta = 0;
	
	@RequestMapping(value = "Movimientos.html", method = RequestMethod.GET)
	public ModelAndView Listado(HttpServletRequest request, Model modelo)
	{
		Integer id = Integer.valueOf(request.getParameter("id"));
		idCuenta = id == null ? idCuenta : id;

		Cuenta cuenta = cuentaService.FirstOrDefault(idCuenta);
		ModelAndView MV = new ModelAndView();
		
		modelo.addAttribute("datosCuenta", "Cuenta N° " + cuenta.getNumero_Cuenta() + " - " + cuenta.getNombre());
		modelo.addAttribute("datoCbu", "Cbu: " + cuenta.getCbu());
		modelo.addAttribute("datoSaldo", "Saldo: " + cuenta.getSaldo());
		modelo.addAttribute("cantidadRegistros", cuenta.getMovimiento().size());
		modelo.addAttribute("listaMovimientos", cuenta.getMovimiento());

		MV.setViewName("Movimientos");
		return MV;
	}

	@RequestMapping("Transferencia.html")
	public ModelAndView NuevaTransferencia(HttpServletRequest request, Model modelo)
	{
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");

		modelo.addAttribute("id", idCuenta);
		modelo.addAttribute("cuentaListado", GetCuentaList(user.getId_Usuario()));

		ModelAndView MV = new ModelAndView();
		MV.setViewName("NuevaTransferencia");
		
		return MV;
	}

	@RequestMapping(value="NuevaTransferencia.html", method = RequestMethod.POST)
	public ModelAndView ConfirmarTransferenciaPost(HttpServletRequest request, Model modelo)
	{
		ModelAndView MV = new ModelAndView();
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");

		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaOrigen"));
		String cbuCuentaDestino = String.valueOf(request.getParameter("cbuDestino"));
		float monto = Float.parseFloat(request.getParameter("monto"));
		
		try
		{
			new MovimientoHibernate(cuentaService, movimientoService).NuevaTransferencia(idCuentaOrigen, cbuCuentaDestino, monto);

			cuentasList = null;
			modelo.addAttribute("cuentaListado", GetCuentaList(user.getId_Usuario()));
			MV.addObject("respuesta", "{ \"status\": \"ok\", \"message\": \"Se realizo la transferencia con exito\" }");
    		
    		MV.setViewName("AlertTransferencia");
		} 
		catch (Exception e) 
		{
			MV.setViewName("AlertTransferencia");
			MV.addObject("respuesta", "{ \"status\": \"error\", \"message\": \"" + e.getMessage() + "\" }");
		}

		return MV;
	}
	

	@RequestMapping(value="NuevaTransferencia.html")
	public ModelAndView ConfirmarTransferenciaGet(HttpServletRequest request, Model modelo)
	{
		HttpSession sessionActiva = request.getSession();
		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");
		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("HomeCliente.html");
		
		
		return MV;
	}
}
