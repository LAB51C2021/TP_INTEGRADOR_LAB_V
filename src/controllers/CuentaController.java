package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import hibernate.ClienteHibernate;
import hibernate.CuentaHibernate;
import models.Cuenta;
import models.Pais;
import models.Persona;
import models.Provincia;
import models.Tipo_Cuenta;
import models.Usuario;

@Controller
@EnableWebMvc
public class CuentaController {

	@RequestMapping("Cuentas.html")
	public ModelAndView Clientes(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		CuentaHibernate cuentaHibernate = new CuentaHibernate();
    		List datos = cuentaHibernate.GetAll();
    		
    		MV.addObject("cuentas", datos);
    		MV.setViewName("Cuentas");
    	}else {
    		MV.setViewName("Login");
    	}
		
		return MV;
	}
	
	@RequestMapping("EditarCuenta.html")
	public ModelAndView Cliente(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		CuentaHibernate cuentaHibernate = new CuentaHibernate();
		ClienteHibernate clienteHibernate = new ClienteHibernate();
		String idCuenta = request.getParameter("idCuenta");
		HttpSession sessionActiva = request.getSession();
    	
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");

    		List tiposCuenta = cuentaHibernate.GetTiposCuenta();
			MV.addObject("tiposCuenta", tiposCuenta);
    		
    		List clientes = clienteHibernate.GetAllClientes();
    		MV.addObject("clientes", clientes);
    		
    		if(idCuenta != null) {
    			Cuenta cuenta = cuentaHibernate.GetId(Integer.parseInt(idCuenta));
    			MV.addObject("cuenta", cuenta);
    		}
    		
    		MV.setViewName("CuentaDetalle");   
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
	
	@RequestMapping(value = "GuardarCuenta.html", method = RequestMethod.POST)
	public ModelAndView Grabar(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCuenta") != null) {
    			String idCuenta = request.getParameter("idCuenta");
    			int id = Integer.parseInt(idCuenta);
        		
    			ClienteHibernate clienteHibernate = new ClienteHibernate();
        		CuentaHibernate cuentaHibernate = new CuentaHibernate();
        		Cuenta cuenta = cuentaHibernate.GetId(id);
        		
        		if(request.getAttribute("tiposCuenta").toString() != null) {
        			Tipo_Cuenta tipo = cuentaHibernate.GetTipoCuenta(Integer.parseInt(request.getAttribute("tiposCuenta").toString()));
        			cuenta.setTipo_Cuenta(tipo);
        		}
        		
        		if(request.getAttribute("clientes").toString() != null) {
        			Persona cliente = clienteHibernate.GetCliente(Integer.parseInt(request.getAttribute("clientes").toString()));
        			cuenta.setUsuario(cliente.getUsuario());
        		}
        			        		
        		if(request.getAttribute("nroCuenta") != null)
        			cuenta.setNumero_Cuenta(request.getAttribute("nroCuenta").toString());    
        		if(request.getAttribute("cbu") != null)
        			cuenta.setCbu(request.getAttribute("cbu").toString());
        		if(request.getAttribute("saldo") != null)
        			cuenta.setSaldo(Float.parseFloat(request.getAttribute("saldo").toString()));
        		
        		cuentaHibernate.Actualizar(cuenta);
        		response.sendRedirect("Cuentas.html");
    		}
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
	
	
	@RequestMapping(value = "EliminarCuenta.html", method = RequestMethod.POST)
	public ModelAndView Eliminar(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCuenta") != null) {
    			String idCuenta = request.getParameter("idCuenta");
    			int id = Integer.parseInt(idCuenta);
        		        		
    			CuentaHibernate cuentaHibernate = new CuentaHibernate();
        		Cuenta cuenta = cuentaHibernate.GetId(id);
        		cuenta.setHabilitado(false);
        		cuentaHibernate.Actualizar(cuenta);
        		MV.setViewName("Cuentas");
    		}
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
}
