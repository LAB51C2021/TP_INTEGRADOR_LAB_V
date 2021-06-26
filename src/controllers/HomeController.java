package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("Home.html")
	public ModelAndView Home(HttpServletRequest request)
	{
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
    
    @RequestMapping("Home2.html")
	public ModelAndView HomeBanco(HttpServletRequest request)
	{
    	HttpSession sessionActiva = request.getSession();
    	sessionActiva.setAttribute("Usuario", null);
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Home2");
		return MV;
	}
}
