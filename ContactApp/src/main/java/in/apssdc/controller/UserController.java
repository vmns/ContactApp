package in.apssdc.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.apssdc.command.LoginCommand;
import in.apssdc.entity.User;
import in.apssdc.exception.UserBlockedException;
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
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd ,Model m, HttpSession s)
	{
		try {
		User loggedInUser = userService.login(cmd.getLoginName(),cmd.getPassword()); 
		if(loggedInUser == null)
		{
			//add error message and go back to index(login) page
			m.addAttribute("err","login failed enter valid credentials");
			return "index";
		}
		else
		{	// success
			// check role and redirect to appropriate dashboard
			if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN))
			{
				// adding user to session object
				addUserInSession(loggedInUser,s);
				return "redirect:admin/dashboard";
			}
			else if(loggedInUser.getRole().equals(UserService.ROLE_USER))
			{
				addUserInSession(loggedInUser,s);
				return "redirect:user/dashboard";
			}
			else
			{
				// add error message and redirect to login page
				m.addAttribute("err","Invalid user role");
				return "index";
			}
			
		}
		}
		catch(UserBlockedException ube)
		{
			//add error message and go back to login form
			m.addAttribute("err",ube.getMessage());
			return "index";
		}
	}
	private void addUserInSession(User u,HttpSession s)
	{
		s.setAttribute("user", u);
		s.setAttribute("name", u.getLoginName());
		s.setAttribute("userId", u.getUserId());
		s.setAttribute("role", u.getRole());
	}
}
