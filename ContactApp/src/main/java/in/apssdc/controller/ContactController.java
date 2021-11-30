package in.apssdc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.apssdc.entity.Contact;
import in.apssdc.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	ContactService contactService;
	@RequestMapping(value="/user/contact_form")
	public String contactForm(Model m)
	{
		Contact contact = new Contact();
		m.addAttribute("command", contact);
		return "contact_form"; // contact_form.jsp
	}
	@RequestMapping(value="/user/save_contact")
	public String saveOrUpdateContact(@ModelAttribute ("command") Contact c,Model m,HttpSession s)
	{
		Integer contactId = (Integer)s.getAttribute("acontactId");
		if(contactId == null)
		{
			try {
				Integer userId = (Integer)s.getAttribute("userId");
				c.setUserId(userId); // FK logged in userId
				contactService.save(c);
				return "redirect:clist?act=sv"; // redirecting user to contact list url
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to save contact");
				return "contact_form"; // redirecting to contact form to fill data again
			}
		}
		else // Update contact
		{
			try {
				
				c.setContactId(contactId); // FK logged in userId
				contactService.update(c);
				return "redirect:clist?act=ed"; // redirecting user to contact list url
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to edit contact");
				return "contact_form"; // redirecting to contact form to fill data again
			}
		}
	}
	@RequestMapping(value="/user/clist")
	public String contactList(Model m,HttpSession s)
	{
		Integer userId = (Integer)s.getAttribute("userId");
		m.addAttribute("contactList",contactService.findUserContact(userId));
		return "clist"; //redirecting to contact list jsp page
	}
	@RequestMapping(value="/user/del_contact")
	public String deleteContact(@RequestParam("cid") Integer contactId)
	{
		contactService.delete(contactId);
		return "redirect:clist?act=del";
	}
	@RequestMapping(value="/user/edit_contact")
	public String prepareEditForm(Model m,HttpSession s,@RequestParam("cid") Integer contactId)
	{
		s.setAttribute("acontactId", contactId);
		Contact c = contactService.findById(contactId);
		m.addAttribute("command", c);
		return "contact_form";
	}
}
