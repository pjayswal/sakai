package org.sakai.controllers;

import javax.servlet.http.HttpServletRequest;

import org.sakai.serviceclients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@Secured({"ROLE_ADMIN", "ROLE_TEACHER","ROLE_STUDENT"})
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@RequestMapping(value="/")
	public String home(Model model){
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		return "Student:"+username;
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getSections(Model model, @PathVariable long id,HttpServletRequest request){
		model.addAttribute("sectionList", studentService.getSections(id));
		request.getSession().setAttribute("student_id", ""+id);
		return "SectionList";
	}

	
	@RequestMapping(value="/section/{id}",method=RequestMethod.GET)
	public String getAssignmentList(Model model, @PathVariable long id,HttpServletRequest request){
		request.getSession().setAttribute("section_id", ""+id);
		model.addAttribute("assignmentList", studentService.getAssignments(id));
		return "AssignmentList";
	}
	
	@RequestMapping(value="/section/assignment/{id}",method=RequestMethod.GET)
	public String getAssignmentDetails(Model model, @PathVariable long id,HttpServletRequest request){
		int student_id = (int) request.getSession().getAttribute("student_id");
		model.addAttribute("assignmentList", studentService.getAssignmentStudent(student_id, id));
		return "AssignmentList";
	}
	
	

}
