

package web.controllers;

import org.SakaiCommons.Person;
import org.SakaiServiceClients.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	@Autowired
	private ILoginService loginService;

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Person loginVerification(String username, String password){
		Person person = loginService.getUser(username, password);
		return person;
	}
	
	
	
	
}
