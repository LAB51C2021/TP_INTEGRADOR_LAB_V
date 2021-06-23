package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovimientoController {

	@RequestMapping("NuevaTransferencia.html")
	public ModelAndView Home()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("NuevaTransferencia");
		return MV;
	}
	
	@RequestMapping("Movimientos.html")
	public ModelAndView Listado()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Movimientos");
		return MV;
	}
}
