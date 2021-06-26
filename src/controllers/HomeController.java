package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.LogonUser;
import models.User;
import models.Customer;
import models.Representative;

@Controller
public class HomeController {

	private String SetViewNameByUser(User user) {
		if(user != null) {
			if(user.getUserType().getDescripcion() == "Cliente")
				return "HomeCliente";
			else if(user.getUserType().getDescripcion() == "Representante")
				return "HomeRepresentante";
			else
				return "Error";
		}else {
			return "Login";			
		}
	}
    @RequestMapping("HomeCliente.html")
	public ModelAndView Home(HttpServletRequest request)
	{
    	//obtengo variable de session
    	HttpSession sessionActiva = request.getSession();
    	User user = (Customer) sessionActiva.getAttribute("sessionUser");
    	
    	//redirecciono a donde corresponda
		ModelAndView MV = new ModelAndView();		
		MV.setViewName(this.SetViewNameByUser(user));
		return MV;
	}
    
    @RequestMapping("HomeRepresentante.html")
	public ModelAndView HomeBanco(HttpServletRequest request)
	{
    	//obtengo variable de session
    	HttpSession sessionActiva = request.getSession();
    	User user = (Representative) sessionActiva.getAttribute("sessionUser");
    	
    	//redirecciono a donde corresponda
		ModelAndView MV = new ModelAndView();		
		MV.setViewName(this.SetViewNameByUser(user));
		return MV;
	}
}
