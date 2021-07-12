package src.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import helper.ViewHelper;
import models.Cuenta;
import models.Persona;
import models.Usuario;
import src.hibernate.UsuarioHibernate;

@Controller
public class AccountController 
{
	int intentos = 3;
	
	@RequestMapping("Login.html")
	public ModelAndView Login(HttpServletRequest request) {
		
		//obtengo variable de session
		HttpSession sessionActiva = request.getSession();
		Usuario persona = (Usuario) sessionActiva.getAttribute("sessionUser");

		//redirecciono a donde corresponda
		ModelAndView MV = new ModelAndView();
		MV.setViewName(ViewHelper.SetViewNameByUser(persona));
		
		return MV;
	}
	
	@RequestMapping(value = "Login.html", method = RequestMethod.POST)
	public ModelAndView Ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		
		String username = request.getParameter("username");
		String dni = request.getParameter("dni");
		String pass = request.getParameter("password");
		
		UsuarioHibernate usuarioHibernate = new UsuarioHibernate(); 
		Usuario usuario = usuarioHibernate.GetUserByCredentials(username, dni, pass);
		
		if(usuario == null)
		{
			MV.addObject("username", username);
			MV.addObject("dni", dni);
			MV.addObject("password", pass);
			MV.addObject("error", "Datos ingresados incorrectos");
			
			return MV;
		}
		
		//seteo variable de session
		HttpSession sessionActiva = request.getSession();
		sessionActiva.setAttribute("sessionUser", usuario);
		
		response.sendRedirect(ViewHelper.SetViewNameByUser(usuario) + ".html");
		
		//redirecciono a donde corresponda
		MV.setViewName(ViewHelper.SetViewNameByUser(usuario));
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
