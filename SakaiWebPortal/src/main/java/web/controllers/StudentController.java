package web.controllers;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;

import org.SakaiServiceClients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	
	
	@RequestMapping(value="/")
	public String home(Model model){
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		//List<Section> sections = studentService.getSections(username);
		return null;
		
	}

}
