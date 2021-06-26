package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hibernate.HibernateConnector;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;

@Controller
public class AccountController {
	
	private void CargarModelosDefectos()
	{
		HibernateConnector hibernateConnector = new HibernateConnector();

		if (hibernateConnector.GetCountRegistry(Tipo_Cuenta.class.getName()) == 0 && 
			hibernateConnector.GetCountRegistry(Tipo_Movimiento.class.getName()) == 0)
		{
			hibernateConnector.AddEntity(new Tipo_Cuenta("Caja de ahorro en pesos"));
			hibernateConnector.AddEntity(new Tipo_Cuenta("Caja de ahorro en dólares"));
			hibernateConnector.AddEntity(new Tipo_Movimiento("Alta"));
			hibernateConnector.AddEntity(new Tipo_Movimiento("Ingreso"));
			hibernateConnector.AddEntity(new Tipo_Movimiento("Egreso"));
			hibernateConnector.SaveChange();
		}
	}
	
	@RequestMapping("Login.html")
	public ModelAndView Login(HttpServletRequest request){
		
		CargarModelosDefectos();
		HttpSession sessionActiva = request.getSession();
		String user = (String) sessionActiva.getAttribute("sessionUser");
		String userType = (String) sessionActiva.getAttribute("sessionUserType");
		ModelAndView MV = new ModelAndView();		
		if(user != null) {
			if(userType == "Cliente")
				MV.setViewName("Home2");
			else if(userType == "Representante")
				MV.setViewName("Home");
			else
				MV.setViewName("Error");
		}else {
			MV.setViewName("Login");			
		}
		
		return MV;
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView Ingresar(String txtUsername, String txtPassword){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Home"); 
		return MV;
	}
	
	@RequestMapping("Logout.html")
	public ModelAndView Logout(HttpServletRequest request)
	{
		HttpSession sessionActiva = request.getSession();
		sessionActiva.setAttribute("sessionUser", null);
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}
}
