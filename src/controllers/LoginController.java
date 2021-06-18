package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("Login.html")
	public ModelAndView Login(){
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
