package in.apssdc.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.apssdc.command.LoginCommand;
import in.apssdc.command.UserCommand;
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
	@RequestMapping(value="/reg_form")
	public String registrationForm(Model m)
	{
		// TODO command object is needed here
		m.addAttribute("command", new UserCommand());
		
		return "reg_form";
	}
	@RequestMapping(value="/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m)
	{
		
		try {
			// Getting/reading values from the form
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			// save the user data to the database
			userService.register(user);
			//m.addAttribute("successmsg", "User registered successfully!,Please login");
			return "redirect:index?abc=reg"; // redirecting to index page with status (act=reg)
		} catch (DuplicateKeyException e) {
			m.addAttribute("err", "Username is already registered.Please select different username");
			e.printStackTrace();
			return "reg_form";
		}
		
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:index?act=lo";
	}
}

//git push -u origin --all
// git push -u origin --tags
