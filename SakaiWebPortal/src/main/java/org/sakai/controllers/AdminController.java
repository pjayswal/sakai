package org.sakai.controllers;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.sakai.commons.Course;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.serviceclients.IAdminService;
import org.sakai.serviceclients.ICourseAdminService;
import org.sakai.serviceclients.IFacultyService;
import org.sakai.serviceclients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IStudentService studentService;
	@Autowired
	private IFacultyService facultyService;
	@Autowired
	private ICourseAdminService courseAdminService;

	@RequestMapping(value = "/")
	public String home() {

		return "admin/admin_home";
	}

	// Get Students
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getStudents(Model model) {
		List<Student> students = adminService.getStudents();
		model.addAttribute("students", students);
		return "admin/admin_studentlist";
	}

	// Create Student
	@RequestMapping(value = "/students/add", method = RequestMethod.POST)
	public String createStudent(@ModelAttribute("student") Student student,
			BindingResult result) {
		adminService.createStudent(student);
		return "redirect:./";
	}

	@RequestMapping(value = "/students/add", method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "admin/admin_addstudent";
	}

	// Get Student Details
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public String getStudentDetails(@PathVariable long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "admin/admin_studentdetails";
	}

	// Update Student Details
	@RequestMapping(value = "/students/{id}", method = RequestMethod.POST)
	public String updateStudentDetails(
			@ModelAttribute("student") Student student, BindingResult result,
			@PathVariable long id, Model model) {
		Student preUpdateStudent = studentService.getStudent(id);
		preUpdateStudent.setName(student.getName());
		preUpdateStudent.setRollNum(student.getRollNum());
		adminService.updateStudent(preUpdateStudent);
		model.addAttribute("student", studentService.getStudent(id));
		return "admin/admin_studentdetails";
	}

	// Delete Student
	@RequestMapping(value = "/students/delete", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("id") long id) {

		Student student = studentService.getStudent(id);
		adminService.deleteStudent(student);
		return "redirect:./";
	}

	// Get Faculties
	@RequestMapping(value = "/faculties", method = RequestMethod.GET)
	public String getFaculity(Model model) {
		model.addAttribute("faculties", adminService.getTeachers());
		return "admin/admin_facultylist";
	}

	// Create Faculty
	@RequestMapping(value = "/faculties/add", method = RequestMethod.POST)
	public String createFaculty(@ModelAttribute Teacher teacher) {
		adminService.createTeacher(teacher);
		return "redirect:./";
	}

	@RequestMapping(value = "/faculties/add", method = RequestMethod.GET)
	public String addFaculty(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "admin/admin_addfaculty";
	}

	// Get Faculty Details
	@RequestMapping(value = "/faculties/{id}", method = RequestMethod.GET)
	public String getFacultyDetails(@PathVariable int id, Model model) {
		model.addAttribute("faculty", facultyService.getTeacher(id));
		return "admin/admin_facultydetails";
	}

	// Update Student Details
	@RequestMapping(value = "/faculties/{id}", method = RequestMethod.POST)
	public String updateFacultyDetails(
			@ModelAttribute("faculty") Teacher faculty, BindingResult result,
			@PathVariable long id, Model model) {
		Teacher preUpdateFaculty = facultyService.getTeacher(id);
		preUpdateFaculty.setName(faculty.getName());
	
		adminService.updateTeacher(preUpdateFaculty);
		model.addAttribute("teacher", facultyService.getTeacher(id));
		return "admin/admin_facultydetails";
	}

	// Delete Faculty
	@RequestMapping(value = "/faculties/delete", method = RequestMethod.GET)
	public String deleteFaculty(@RequestParam("id") long id) {

		Teacher teacher = facultyService.getTeacher(id);
		adminService.deleteTeacher(teacher);
		return "redirect:./";
	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String getCourses(Model model) {
		model.addAttribute("courses", courseAdminService.getCourses());
		return "admin/admin_courselist";
	}

	// get details of a course
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
	public String getCourseDetails(@PathVariable int id, Model model,
			HttpServletRequest request) {
		List<Section> sections = courseAdminService.getSections(id);
		model.addAttribute("sections", sections);
		model.addAttribute("course", courseAdminService.getCourse(id));
		request.getSession().setAttribute("course_id", id);
		return "admin/coursedetails";
	}

	// add a course
	@RequestMapping(value = "/courses/add", method = RequestMethod.GET)
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		return "admin/addcourse";
	}

	// create a course
	@RequestMapping(value = "/courses/add", method = RequestMethod.POST)
	public String createCourse(Course course) {
		courseAdminService.addCourse(course);
		return "redirect:/admin/courses";
	}

	// update a course
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.POST)
	public String updateCourse(Course course, @PathVariable int id) {
		courseAdminService.updateCourse(course);
		return "redirect:/admin/courses";
	}

	// get details of a section in a course
	@RequestMapping(value = "/sections/{id}", method = RequestMethod.GET)
	public String getSections(@PathVariable int id, Model model) {
		model.addAttribute("section", courseAdminService.getSection(id));
		return "admin/sectiondetails";
	}

	// add section to a course
	@RequestMapping(value = "/sections/add", method = RequestMethod.GET)
	public String addSection(Model model, @RequestParam("id") String id) {
		Course course = courseAdminService.getCourse(Long.parseLong(id));
		model.addAttribute("course", course);
		model.addAttribute("faculties", facultyService.getFaculties());
		model.addAttribute("students", adminService.getStudents());
		model.addAttribute("section", new Section());
		return "admin/addsection";
	}

	// create section to a course
	@RequestMapping(value = "/sections/addSection", method = RequestMethod.POST)
	public String createSection(@ModelAttribute("section") Section section,
			BindingResult result, @RequestParam("id") long id) {

		Course course = courseAdminService.getCourse(id);
		section.setCourse(course);
		courseAdminService.addSection(section);

		return "redirect:../courses/" + id;
	}

	// update section"
	@RequestMapping(value = "/sections/{id}", method = RequestMethod.POST)
	public String updateSection(Section section, @PathVariable int id,
			HttpServletRequest request) {
		courseAdminService.updateSection(section);
		int csid = (int) request.getSession().getAttribute("course_id");
		return "redirect:../courses/" + csid;
	}

	@InitBinder
	protected void initBinder2(WebDataBinder binder) {
		// System.out.println("fancy thingssss two");
		binder.registerCustomEditor(List.class, "students",
				new CustomCollectionEditor(List.class) {
					@Override
					protected Object convertElement(Object element) {
						// System.out.println("fancy thingssss");
						Integer id = null;
						if (element instanceof String
								&& !((String) element).equals("")) {
							// From the JSP 'element' will be a String
							try {
								id = Integer.parseInt((String) element);
							} catch (NumberFormatException e) {
								System.out.println("Element was "
										+ ((String) element));
								e.printStackTrace();
							}
						} else if (element instanceof Integer) {
							// From the database 'element' will be a Long
							id = (Integer) element;
						}
						return id != null ? studentService.getStudent(id)
								: null;
					}
				});

		binder.registerCustomEditor(Teacher.class, "faculty",
				new PropertyEditorSupport() {

					@Override
					public void setAsText(String text) {
						Teacher ch = facultyService.getTeacher((Long
								.parseLong(text)));
						setValue(ch);
					}
				});

	}

}
