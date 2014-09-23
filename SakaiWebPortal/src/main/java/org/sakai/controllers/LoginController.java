

package org.sakai.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.sakai.Util.SakaiAuthorities;
import org.sakai.commons.Address;
import org.sakai.commons.Admin;
import org.sakai.commons.Course;
import org.sakai.commons.Person;
import org.sakai.commons.Role;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.commons.UserCredential;
import org.sakai.serviceclients.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {
	
	IAdminService adminService;
	
	@Autowired
	public LoginController(IAdminService adminService)
	{
		this.adminService=adminService;
	}
	
	//@PostConstruct
	public void init(){
		Role student  = new Role("ROLE_STUDENT");
		Role teacher = new Role("ROLE_TEACHER");
		Role admin = new Role("ROLE_ADMIN");
		
		UserCredential user1 = new UserCredential("prasad", "jayswal");
		user1.addUserRoles(student);
		UserCredential user2 = new UserCredential("ramesh","karna");
		user2.addUserRoles(student);
		UserCredential user3 = new UserCredential("awais","tarik");
		user3.addUserRoles(student);
		UserCredential user4 = new UserCredential("yashir","mukhtar");
		user4.addUserRoles(teacher);
		UserCredential root = new UserCredential("admin", "admin");
		root.addUserRoles(admin);
		Address padress = new Address("ans", "asdas", "asda","1232");
		Address radress = new Address("232","adsad","as4e","32423");
		
		Student pramod = new Student("Pramod", "231343431313", "pramod.jayswal@gmail.com", padress, 984165, user1);
		Student ramesh =	new Student("Ramesh", "231344331313", "ramesh.jayswal@gmail.com", radress, 984155, user2);
		Student awais = new Student("Awais", "231344331313", "awais.jayswal@gmail.com", radress, 984145, user3);
		Teacher yashir = new Teacher("yashir", "23144331313", "yashir.jayswal@gmail.com", radress, user4);
		
		Admin admin1 = new Admin("admin", "231343431313", "asd@gmail.com", radress,root);
		adminService.createRole(admin);
		adminService.createRole(teacher);
		adminService.createRole(student);
		
		adminService.createStudent(pramod);
		adminService.createTeacher(yashir);
		adminService.createStudent(awais);
		adminService.createStudent(ramesh);
		adminService.createAdmin(admin1);
		
		Course  course = new Course("C++", "programming", "cs544");
		adminService.createCourse(course);
		Section section = new Section( new Date(),new Date(), 30, course);
		
		section.addStudent(pramod);
		section.addStudent(ramesh);
		section.addStudent(awais);
		section.setFaculty(yashir);
		adminService.createSection(section);
	
		
		
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String redirectToSpecificController(Model m,HttpServletRequest request){
		//init();
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		Person person = adminService.getPerson(username);
		long id=person.getId();
		if(request.isUserInRole(SakaiAuthorities.ROLE_STUDENT)){
			
			//System.out.println("Login func called!!");
			return "redirect:/student/"+id;
		}
		else if(request.isUserInRole(SakaiAuthorities.ROLE_ADMIN)){
			
			System.out.println("Login func called!!");
			return "redirect:/admin/";
		}
		else
			return "redirect:/faculty/"+id;
		
	}
	
	
	
	
}
