package org.sakai.controllers;

import org.sakai.commons.Course;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.serviceclients.IAdminService;
import org.sakai.serviceclients.ICourseAdminService;
import org.sakai.serviceclients.IFacultyService;
import org.sakai.serviceclients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IStudentService studentService;
	@Autowired
	private IFacultyService facultyService;
	@Autowired
	private ICourseAdminService courseAdminService;
	
	@RequestMapping(value="/")
	public String home(){

		return "admin_home";
	}
	
	@RequestMapping(value="/students/add",method=RequestMethod.POST)
	public String createStudent(@ModelAttribute Student student){
		adminService.createStudent(student);
		return "redirect:/students";
	}
	
	@RequestMapping(value="/students/add",method=RequestMethod.GET)
	public String addStudent(Model model){
		model.addAttribute("student",new Student());
		return "admin_addstudent";
	}
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String getStudents(Model model){
		model.addAttribute("studsectionsents",adminService.getStudents());
		return "admin_studentlist";
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.GET)
	public String getStudentDetails(@PathVariable int id, Model model) {
		model.addAttribute("student",studentService.getStudent(id));
		return "admin_studentdetails";
	}
	
	
	@RequestMapping(value="/faculties",method=RequestMethod.GET)
	public String getFaculity(Model model){
		model.addAttribute("faculties",adminService.getTeachers());
		return "admin_facultylist";
	}
	
	@RequestMapping(value="/faculties/add",method=RequestMethod.POST)
	public String createFaculty(@ModelAttribute Teacher teacher){
		adminService.createTeacher(teacher);
		return "redirect:/faculties";
	}
	@RequestMapping(value="/faculties/add",method=RequestMethod.GET)
	public String addTeacher(Model model){
		model.addAttribute("teacher",new Teacher());
		return "admin_addfaculty";
	}
	
	@RequestMapping(value="/faculties/{id}", method=RequestMethod.GET)
	public String getTeacherDetails(@PathVariable int id, Model model) {
		model.addAttribute("faculty",facultyService.getTeacher(id));
		return "admin_facultydetails";
	}
	
	
	@RequestMapping(value="/courses",method=RequestMethod.GET)
	public String getCourses(Model model){
		model.addAttribute("courses",courseAdminService.getCourses());
		return "admin_courselist";
	}
	
	@RequestMapping(value="/courses/add",method=RequestMethod.GET)
	public String addCourse(Model model){
		model.addAttribute("course",new Course());
		return "admin_addcourse";
	}
	@RequestMapping(value="/courses/add",method=RequestMethod.POST)
	public String createCourse(Model model){
		
		return "admin_addcourse";
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
	public String getCourseDetails(@PathVariable int id, Model model) {
		model.addAttribute("sections",courseAdminService.getSection(id));
		model.addAttribute("course",courseAdminService.getCourse(id));
		return "admin_coursedetails";
	}

	@RequestMapping(value="/sections/{id}",method=RequestMethod.GET)
	public String getSections(@PathVariable int id,Model model){
		model.addAttribute("sections",courseAdminService.getSection(id));
		return "admin_courselist";
	}
	
}
