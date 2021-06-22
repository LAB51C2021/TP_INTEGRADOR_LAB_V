package controllers;

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
	public ModelAndView Login(){
		
		CargarModelosDefectos();

		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login"); 
		
		return MV;
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView Ingresar(String txtUsername, String txtPassword){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Home"); 
		return MV;
	}
	
	@RequestMapping("Logout.html")
	public ModelAndView Logout()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Home");
		return MV;
	}
}
