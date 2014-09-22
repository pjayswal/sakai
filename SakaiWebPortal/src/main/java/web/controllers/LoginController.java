

package web.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.SakaiCommons.Address;
import org.SakaiCommons.Course;
import org.SakaiCommons.Person;
import org.SakaiCommons.Role;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;
import org.SakaiCommons.Util.SakaiAuthorities;
import org.SakaiServiceClients.IAdminService;
import org.SakaiServiceClients.IFacultyService;
import org.SakaiServiceClients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller

public class LoginController {
	@Autowired
	IAdminService adminService;
	
	/*//@PostConstruct
	public void init(){
		Role student  = new Role("ROLE_STUDENT");
		Role teacher = new Role("ROLE_TEACHER");
		Role admin = new Role("ROLE_ADMIN");
		
		User user1 = new User("prasad", "jayswal");
		user1.addUserRoles(student);
		User user2 = new User("ramesh","karna");
		user2.addUserRoles(student);
		User user3 = new User("awais","tarik");
		user3.addUserRoles(student);
		User user4 = new User("yashir","mukhtar");
		user4.addUserRoles(teacher);
		Address padress = new Address("ans", "asdas", "asda");
		Address radress = new Address("232","adsad","as4e");
		
		Student pramod = new Student("Pramod", "231343431313", "pramod.jayswal@gmail.com", padress, 984165, user1);
		Student ramesh =	new Student("Ramesh", "231344331313", "ramesh.jayswal@gmail.com", radress, 984155, user2);
		Student awais = new Student("Awais", "231344331313", "awais.jayswal@gmail.com", radress, 984145, user3);
		Teacher yashir = new Teacher("yashir", "23144331313", "yashir.jayswal@gmail.com", radress, user4);
		
//		adminService.createRole(admin);
//		adminService.createRole(teacher);
//		adminService.createRole(student);
		
		adminService.createUser(pramod);
		adminService.createUser(yashir);
		adminService.createUser(awais);
		adminService.createUser(ramesh);
		
		Course  course = new Course("C++", "programming", "cs544");
		adminService.createCourse(course);
		Section section = new Section( yashir, new Date(),new Date(), 30, course);
		adminService.createSection(section);
		section.addStudent(pramod);
		section.addStudent(ramesh);
		section.addStudent(awais);
		//section.setFaculty(yashir);
		
		
		
	}*/
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String redirectToSpecificController(Model m,HttpServletRequest request){
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		Person person = adminService.getPerson(username);
		long id=person.getId();
		System.out.println("Login func called!!");
		if(request.isUserInRole(SakaiAuthorities.ROLE_STUDENT)){
			return "redirect:/student/"+id;
		}
		if(request.isUserInRole(SakaiAuthorities.ROLE_FACULTY)){
			return "redirect:/faculty/"+id;
		}
		
		return null;
	}
	
	
	
	
}
