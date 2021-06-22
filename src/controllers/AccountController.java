package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
	
	@RequestMapping("Login.html")
	public ModelAndView Login(){
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
