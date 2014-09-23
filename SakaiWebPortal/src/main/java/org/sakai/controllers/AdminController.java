package org.sakai.controllers;

import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.serviceclients.IAdminService;
import org.sakai.serviceclients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/students",method=RequestMethod.POST)
	public String createStudent(Student student){
		adminService.createStudent(student);
		return "redirect:/students";
	}
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String getStudents(Model model){
		model.addAttribute("students",adminService.getStudents());
		return "admin_studentList";
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.GET)
	public String getStudentDetails(@PathVariable int id, Model model) {
		model.addAttribute("student",studentService.getStudent(id));
		return "admin_studentDetails";
	}
	
	
	@RequestMapping(value="/faculties",method=RequestMethod.GET)
	public String getFaculity(Model model){
		model.addAttribute("students",adminService.getStudents());
		return "admin_facultyList";
	}
	
	@RequestMapping(value="/faculties",method=RequestMethod.POST)
	public String createFaculty(Teacher teacher){
		adminService.createTeacher(teacher);
		return "redirect:/faculties";
	}
	
}
