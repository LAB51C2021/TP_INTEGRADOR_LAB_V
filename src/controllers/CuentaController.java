package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
		MV.setViewName("Login");    
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCuenta") != null) {
    			String idCuenta = request.getParameter("idCuenta");
    			int id = Integer.parseInt(idCuenta);
        		
    			ClienteHibernate clienteHibernate = new ClienteHibernate();
        		CuentaHibernate cuentaHibernate = new CuentaHibernate();
        		Cuenta cuenta = new Cuenta();
        		if(id != 0) {
        			cuenta = cuentaHibernate.GetId(id);
    			}
        		
        		if(request.getParameter("tiposCuenta").toString() != null) {
        			Tipo_Cuenta tipo = cuentaHibernate.GetTipoCuenta(Integer.parseInt(request.getParameter("tiposCuenta").toString()));
        			cuenta.setTipo_Cuenta(tipo);
        			cuenta.setNombre(tipo.getNombre());
        		}
        		
        		if(request.getParameter("clientes").toString() != null) {
        			Persona cliente = clienteHibernate.GetCliente(Integer.parseInt(request.getParameter("clientes").toString()));
        			cuenta.setUsuario(cliente.getUsuario());
        		}
        			        		
        		if(request.getParameter("nroCuenta") != null)
        			cuenta.setNumero_Cuenta(request.getParameter("nroCuenta").toString());    
        		if(request.getParameter("cbu") != null)
        			cuenta.setCbu(request.getParameter("cbu").toString());
        		if(request.getParameter("saldo") != null)
        			cuenta.setSaldo(Float.parseFloat(request.getParameter("saldo").toString()));
        		
        		if(id == 0) {
        			Date input = new Date();
        			LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        			cuenta.setFecha_Creacion(date);		        			
        		}
        		        		
        		cuenta.setHabilitado(true);
        		
        		if(id != 0) {
        			cuentaHibernate.Actualizar(cuenta);
        		}else {
        			cuentaHibernate.Grabar(cuenta);
        		}
        		response.sendRedirect("Cuentas.html");
    		}
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
