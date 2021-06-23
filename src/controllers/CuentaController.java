package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CuentaController {

	@RequestMapping("Cuentas.html")
	public ModelAndView Index()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Cuentas");
		return MV;
	}
	
	@RequestMapping("CuentaDetalle.html")
	public ModelAndView Details()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("CuentaDetalle");
		return MV;
	}
}
