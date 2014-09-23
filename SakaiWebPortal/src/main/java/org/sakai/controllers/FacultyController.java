package org.sakai.controllers;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.serviceclients.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/faculty")
public class FacultyController {
	
	@Autowired
	private IFacultyService facultyService;
	
	@RequestMapping(value="/")
	public String home(Model model){
		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =user.getUsername();
		return "Faculty:"+username;
		
	}
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getSections(Model model, @PathVariable long id){
		model.addAttribute("sectionList", facultyService.getSecctions(id));
		return "listSection";
	}
	
	@RequestMapping(value="/sectionStudent/{id}",method = RequestMethod.GET)
	public String getStudent(@PathVariable long sectionId , Model model){
		model.addAttribute("studentList", facultyService.getStudents(sectionId));		
		return "sectionStudentList";
	}
	
	@RequestMapping(value="/createAssignment/{id}", method=RequestMethod.POST)
	public String createAssignment(@PathVariable long id, Assignment assignment, Model model){
		facultyService.CreateAssignment(id, assignment);
		model.addAttribute("id", id);
		return "assignmentList";
	}
	@RequestMapping(value="/sectionAssignment/{id}",method=RequestMethod.GET)
	public String getAssignmentList(Model model, @PathVariable long id){
		model.addAttribute("assignmentList", facultyService.getAssignments(id));
		return "assignmentList";
	}
	
	@RequestMapping(value="/sectionAssignmentStudent/{id}")
	public String getAssignmentStudent(@PathVariable long id, Model model){
		model.addAttribute("assignmentStudentList", facultyService.getAssignments(id));
		return "assignmentStudentList";
	}
	
	@RequestMapping(value="/updateAssignmentStudent/{id}")
	public String updateAssignmentStudent(@PathVariable long id,Model model, AssignmentStudent assignmentStudent){
		facultyService.UpdateAssignmnetStudent(assignmentStudent);
		return "assignmentStudentList";
	}	
}
