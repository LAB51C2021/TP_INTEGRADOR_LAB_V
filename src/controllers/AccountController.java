package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hibernate.HibernateConnector;
import models.LogonUser;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;
import models.User;

@Controller
public class AccountController {
	
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
		
	@RequestMapping("Login.html")
	public ModelAndView Login(HttpServletRequest request){
		
		//obtengo variable de session
		HttpSession sessionActiva = request.getSession();
		User user = (User) sessionActiva.getAttribute("sessionUser");

		//redirecciono a donde corresponda
		ModelAndView MV = new ModelAndView();
		MV.setViewName(this.SetViewNameByUser(user));
		return MV;
	}
	
	@RequestMapping(value = "Login.html", method = RequestMethod.POST)
	public ModelAndView Ingresar(HttpServletRequest request, HttpServletResponse response){		
		ModelAndView MV = new ModelAndView();		
		MV.setViewName("Login");	
		//valido contra db
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		/*if(username != "fmansilla" && pass != "123456"){
			MV.addObject("username", username);
			MV.addObject("password", pass);
			MV.addObject("error", "error de acceso");
			return MV;
		}*/
		
		User user =  new User();
		
		//seteo variable de session
		HttpSession sessionActiva = request.getSession();
		sessionActiva.setAttribute("sessionUser", user);
		
		//redirecciono a donde corresponda
		MV.setViewName(this.SetViewNameByUser(user));
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
