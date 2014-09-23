package org.sakai.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/faculty")
public class FacultyController {
	
	@Autowired
	private IFacultyService facultyService;
	
//	@RequestMapping(value="/")
//	public String home(Model model){
//		User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String username =user.getUsername();
//		return "Faculty:"+username;
//		
//	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getSections(Model model, @PathVariable long id){
		model.addAttribute("sectionList", facultyService.getSecctions(id));
		System.out.println("|Request seen");
		return "SectionList";
	}
	
	@RequestMapping(value="/getStudentList/{id}",method = RequestMethod.GET)
	public String getStudent(@PathVariable long id , Model model){
		model.addAttribute("studentList", facultyService.getStudents(id));	
		model.addAttribute("assignmentList", facultyService.getAssignments(id));
		return "StudentList";
	}
	
	@RequestMapping(value="createAssignment/{id}", method=RequestMethod.POST)
	public String createAssignment(@PathVariable long id,@RequestParam("assignmentFile") MultipartFile file, Assignment assignment, Model model){
		
		if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + assignment.getAssignments());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
//                logger.info("Server File Location="
//                        + serverFile.getAbsolutePath());
 
//                return "You successfully uploaded file=" + assignment.getAssignments();
            } catch (Exception e) {
//                return "You failed to upload " + assignment.getAssignments() + " => " + e.getMessage();
            }
        } else {
//            return "You failed to upload " + assignment.getAssignments()
//                    + " because the file was empty.";
        }
		
		facultyService.CreateAssignment(id, assignment);
		model.addAttribute("id", id);
		return "AssignmentList";
	}
	@RequestMapping(value="/getSectionAssignmentList/{id}",method=RequestMethod.GET)
	public String getAssignmentList(Model model, @PathVariable long id){
		model.addAttribute("assignmentList", facultyService.getAssignments(id));
		return "AssignmentList";
	}
	
	@RequestMapping(value="/getAssignmentStudentList/{id}",method = RequestMethod.GET)
	public String getAssignmentStudentList(@PathVariable long id, Model model){
		model.addAttribute("assignmentStudentList", facultyService.getAssignmentStudentList(id));
		return "AssignmentStudentList";
	}
	
	@RequestMapping(value="/getAssignmentStudent/{id}",method=RequestMethod.GET)
	public String getAssignmentStudent(@PathVariable long id, Model model){
		model.addAttribute("assignmentStudent",facultyService.getAssignmentStudent(id));
		return "updateAssignmentStudent";
	}
	
	
	@RequestMapping(value="/updateAssignmentStudent/{id}", method = RequestMethod.POST)
	public String updateAssignmentStudent(@PathVariable long id,Model model, AssignmentStudent assignmentStudent){
		facultyService.UpdateAssignmnetStudent(assignmentStudent);
		return "AssignmentStudentList";
	}		
}
