package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hibernate.HibernateConnector;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;

@Controller
public class LoginController {
	 
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
	
	@RequestMapping("Dashboard.html")
	public ModelAndView Ingresar(String txtUsername, String txtPassword)
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("Usuario", txtUsername);
		MV.addObject("Password", txtPassword);
		MV.setViewName("Dashboard");
		return MV;
	}
}
