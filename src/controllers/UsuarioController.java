package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hibernate.CuentaHibernate;
import models.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("ClienteDetalle.html")
	public ModelAndView Details()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ClienteDetalle");
		return MV;
	}
	
}
