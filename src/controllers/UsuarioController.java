package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

	@RequestMapping("Clientes.html")
	public ModelAndView Index()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes");
		return MV;
	}
	
	@RequestMapping("ClienteDetalle.html")
	public ModelAndView Details()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ClienteDetalle");
		return MV;
	}
}
