package src.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import helper.ViewHelper;
import models.Cuenta;
import models.Usuario;
import src.services.IEntityService;

@Controller
public class HomeController 
{
	@Autowired
	private IEntityService<Cuenta> cuentaService;
	
    @RequestMapping("HomeCliente.html")
	public ModelAndView Home(HttpServletRequest request, Model modelo)
	{
    	ModelAndView MV = new ModelAndView();
    	//obtengo variable de session
    	HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	
    	if(sessionActiva.getAttribute("sessionUser") != null) 
    	{
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		List cuentaList = cuentaService.GetAll("Id_Usuario = " + user.getId_Usuario());

    		modelo.addAttribute("cuentaListado", cuentaList);
    	}
    	
    	//redirecciono a donde corresponda
		MV.setViewName(ViewHelper.SetViewNameByUser(user));
		
		return MV;
	}
    
    @RequestMapping("HomeRepresentante.html")
	public ModelAndView HomeBanco(HttpServletRequest request)
	{
    	//obtengo variable de session
    	HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	
    	if(sessionActiva.getAttribute("sessionUser") != null) 
    	{
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    	}
    	
    	//redirecciono a donde corresponda
		ModelAndView MV = new ModelAndView();		
		MV.setViewName(ViewHelper.SetViewNameByUser(user));
		return MV;
	}
}
