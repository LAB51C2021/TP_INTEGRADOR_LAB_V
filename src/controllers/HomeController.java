package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("Home.html")
	public ModelAndView Home()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Home");
		return MV;
	}

}
