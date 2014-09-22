package web.controllers;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiServiceClients.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="/facutly")
public class FacultyController {
	private IFacultyService facultyService;
	
	@Autowired
	public FacultyController(IFacultyService facultyService) {
		this.facultyService = facultyService; 
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getSection(Model model, @PathVariable long id){
		model.addAttribute("sectionList", facultyService.getSecctions(id));
		return "listSection";
	}
	
	@RequestMapping(value="/sectionStudent/{id}",method = RequestMethod.GET)
	public String getStudent(@PathVariable long sectionId , Model model){
		model.addAttribute("studentList", facultyService.getStudents(sectionId));		
		return "sectionStudentList";
	}
	
	@RequestMapping(value="createAssignment/{id}", method=RequestMethod.POST)
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
	
	@RequestMapping(value="sectionAssignmentStudent/{id}")
	public String getAssignmentStudent(@PathVariable long id, Model model){
		model.addAttribute("assignmentStudentList", facultyService.getAssignments(id));
		return "assignmentStudentList";
	}
	
	@RequestMapping(value="updateAssignmentStudent/{id}")
	public String updateAssignmentStudent(@PathVariable long id,Model model, AssignmentStudent assignmentStudent){
		facultyService.UpdateAssignmnetStudent(assignmentStudent);
		return "assignmentStudentList";
	}	
}
