package src.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import models.Cuenta;
import models.Movimiento;
import models.Persona;
import models.Tipo_Cuenta;
import models.Usuario;
import src.hibernate.ClienteHibernate;
import src.hibernate.CuentaHibernate;
import src.services.IEntityService;

@Controller
@EnableWebMvc
public class CuentaController {
	
	@Autowired
	private IEntityService<Cuenta> cuentaService;
	
	@Autowired
	private IEntityService<Tipo_Cuenta> tiposCuentaService;
	
	@Autowired
	private IEntityService<Persona> personaService;
	
	@Autowired
	private IEntityService<Movimiento> movimientoService;

	@RequestMapping("Cuentas.html")
	public ModelAndView Clientes(HttpServletRequest request, Model modelo)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	
    	if(sessionActiva.getAttribute("sessionUser") != null) 
    	{
    		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		List datos = cuentaService.GetAll();
    		
    		modelo.addAttribute("cuentaListado", datos);
    		
    		MV.setViewName("Cuentas");
    	}
    	else 
    	{
    		MV.setViewName("Login");
    	}
		
		return MV;
	}
	
	@RequestMapping("EditarCuenta.html")
	public ModelAndView Cliente(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		String idCuenta = request.getParameter("idCuenta");
		HttpSession sessionActiva = request.getSession();
    	
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		Usuario user = (Usuario) sessionActiva.getAttribute("sessionUser");

    		List tiposCuenta = tiposCuentaService.GetAll();
			MV.addObject("tiposCuenta", tiposCuenta);
    		
    		List clientes = personaService.GetAll("EsCliente = 1");
    		MV.addObject("clientes", clientes);
    		
    		if(idCuenta != null) {
    			int id = Integer.parseInt(idCuenta);
    			Cuenta cuenta = cuentaService.FirstOrDefault(id);
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
        			cuenta = cuentaService.FirstOrDefault(id);
    			}
        		
        		
        		
        		if(request.getParameter("tiposCuenta").toString() != null) {
        			Tipo_Cuenta tipo = cuentaHibernate.GetTipoCuenta(Integer.parseInt(request.getParameter("tiposCuenta").toString()));
        			cuenta.setTipo_Cuenta(tipo);
        			cuenta.setNombre(tipo.getNombre());
        		}
        		
        		if(request.getParameter("clienteID").toString() != null) {
        			Persona cliente = clienteHibernate.GetCliente(Integer.parseInt(request.getParameter("clienteID").toString()));
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
        		
        		String respuesta;
        		if(id != 0) {
        			cuentaService.Update(cuenta);
        			respuesta = "Se actualizo la cuenta correctamente";
        		}else {
        			cuentaService.Add(cuenta);
        			
        			Date input = new Date();
        			LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        			cuenta.setFecha_Creacion(date);
        			Movimiento movimiento = new Movimiento(date, Float.parseFloat(request.getParameter("saldo").toString()),
        					1, cuenta.getId_Cuenta(), null);
        			
        			movimientoService.Add(movimiento);
        			
        			respuesta = "Se agreg? la cuenta correctamente";
        		}
    			MV.addObject("respuesta", respuesta);
        		
        		MV.setViewName("EditCuenta");  
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
    			boolean estado = Boolean.parseBoolean(request.getParameter("habilitado"));
    			String respuesta;
        		Cuenta cuenta = cuentaService.FirstOrDefault(id);
        		cuenta.setHabilitado(estado);
        		cuentaService.Update(cuenta);
        		
        		if(!estado) {
        			respuesta = "Se des habilito la cuenta correctamente";        			
        		}else {
        			respuesta = "Se habilito la cuenta correctamente";
        		}
        		MV.addObject("respuesta", respuesta);
        		
        		MV.setViewName("EditCuenta");
    		}
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
		
	@RequestMapping(value = "ValidaCantCuentasAsignadasPorCliente.html", method = RequestMethod.GET)
	public ModelAndView ValidacionCantidadCuentas(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ValidaCantCuentasAsignadasPorCliente");
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("userID") != null) {
    			String userID = request.getParameter("userID");
        		        		
    			CuentaHibernate cuentaHibernate = new CuentaHibernate();
        		int cant = cuentaHibernate.GetAllCuentasByUser(userID);
        		
        		if(cant >= 4) {
        			MV.addObject("error", "El cliente a llegado al limite de cuentas por asignar.");
        		}
    		}
    	}
    	return MV;
	}
	
	@RequestMapping(value = "ValidaDuplicateNroCuenta.html", method = RequestMethod.GET)
	public ModelAndView ValidacionNroCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ValidaDuplicateNroCuenta");
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("nroCuenta") != null) {
    			String nroCuenta = request.getParameter("nroCuenta");
        		        		
    			CuentaHibernate cuentaHibernate = new CuentaHibernate();
        		boolean existe = cuentaHibernate.ValidateNroCuenta(nroCuenta);
        		
        		if(existe) {
        			MV.addObject("error", "No se pudo dar de alta correctamente al cliente, porque ya existe el DNI en la base.");	
        		}
    		}
    	}
    	return MV;
	}
}
