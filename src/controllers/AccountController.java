package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hibernate.UsuarioHibernate;
import models.LogonUser;
import models.User;

@Controller
public class AccountController {
	
	private String SetViewNameByUser(User user) {
		if(user != null) {
			if(user.getUserType().getDescripcion().equals("Cliente")) {
				return "HomeCliente";				
			}
			if(user.getUserType().getDescripcion().equals("Representante")) {
				return "HomeRepresentante";				
			}
			
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
		
		UsuarioHibernate usuarioHibernate = new UsuarioHibernate(); 
		LogonUser UserLogin = usuarioHibernate.GetUserByCredentials(username, "", pass);
		
		if(UserLogin == null){
			MV.addObject("username", username);
			MV.addObject("password", pass);
			MV.addObject("error", "error de acceso");
			return MV;
		}
		
		//seteo variable de session
		HttpSession sessionActiva = request.getSession();
		sessionActiva.setAttribute("sessionUser", UserLogin.getUser());
		
		//redirecciono a donde corresponda
		MV.setViewName(this.SetViewNameByUser(UserLogin.getUser()));
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
