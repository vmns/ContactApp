package in.apssdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping(value= {"/","/index"})
	public String index()
	{
		return "index"; //jsp     /WEB-INF/view/index.jsp
	}
}
