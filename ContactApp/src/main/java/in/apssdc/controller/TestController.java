package in.apssdc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/test/ajax_test")
	public String testPage()
	{
		return "test";
	}
	@RequestMapping(value="/test/get_time")
	@ResponseBody
	public String getServerTime()
	{
		System.out.println("----getServer time()-------");
		Date d = new Date();
		return d.toString();
	}
}
