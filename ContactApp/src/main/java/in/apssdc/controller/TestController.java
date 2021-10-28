package in.apssdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test/hello")
	public String helloworld()
	{
		return "hello";
	}
	
	@RequestMapping("/login")
	public String userlogin()
	{
		return "login";
	}
}
