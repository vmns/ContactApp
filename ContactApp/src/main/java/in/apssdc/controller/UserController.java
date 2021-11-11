package in.apssdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.apssdc.command.LoginCommand;
import in.apssdc.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value= {"/","/index"})
	public String index(Model m)
	{
		m.addAttribute("command",new LoginCommand());
		return "index"; //jsp     /WEB-INF/view/index.jsp
	}
	@RequestMapping(value= "/user/dashboard")
	public String userDashboard()
	{
		return "dashboard_user";
	}
	@RequestMapping(value="/admin/dashboard")
	public String adminDashboard()
	{
		return "dashboard_admin";
	}
}
