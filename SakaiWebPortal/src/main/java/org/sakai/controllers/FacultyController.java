package org.sakai.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentSolution;
import org.sakai.commons.Section;
import org.sakai.serviceclients.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("sectionId", id);
		return "StudentList";
	}
	
	@RequestMapping(value="/createAssignment/{id}")
	public String createAssignment(@PathVariable long id,Model model){
		model.addAttribute("sectionId", id);
		model.addAttribute("assignment", new Assignment());
		return "CreateAssignment";
	}
	
	@RequestMapping(value="/assignment/{id}",method=RequestMethod.GET)
	public String downloadAssignment(Model model,@PathVariable long id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttr){
		UserDetails userDetails =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Assignment assignment=facultyService.getAssignment(id);
		String path="";
		try {

			File file=new File(request.getServletContext().getRealPath("/resources/assignment.doc"));
			writeBytesToFile(file, assignment.getAssignments());
			path=file.getAbsolutePath();
            String filePathToBeServed = path;
                    File fileToDownload = new File(filePathToBeServed);
                    InputStream inputStream = new FileInputStream(fileToDownload);
                    response.setContentType("application/force-download");
                    response.setHeader("Content-Disposition", "attachment; filename=assignment.doc"); 
                    IOUtils.copy(inputStream, response.getOutputStream());
                      response.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String fileURL = path;
	    
	    FileInputStream fileInputStream = null;
	    BufferedInputStream bufferedInputStream = null;

		return "StudentList";
	}
	public static void writeBytesToFile(File theFile, byte[] bytes) throws IOException {
		BufferedOutputStream bos = null;

		try {
			
			FileOutputStream fos = new FileOutputStream(theFile);
			bos = new BufferedOutputStream(fos); 
			bos.write(bytes);
			
		}finally {
			if(bos != null) {
				try  {
					//flush and close the BufferedOutputStream
					bos.flush();
					bos.close();
				} catch(Exception e){}
			}
		}
      }
	
	@RequestMapping(value="/uploadAssignment/{sectionId}", method=RequestMethod.POST)
	public String uploadAssignment(@PathVariable long sectionId,@Valid Assignment assignment,BindingResult result, Model model){
		
		if(result.hasFieldErrors())
		{
			return "CreateAssignment";
		}
		else
		{
			facultyService.CreateAssignment(sectionId, assignment);
		}
		model.addAttribute("studentList", facultyService.getStudents(sectionId));	
		model.addAttribute("assignmentList", facultyService.getAssignments(sectionId));
		model.addAttribute("sectionId", sectionId);
		
		return "StudentList";
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
	public String updateAssignmentStudent(@PathVariable long id,Model model, AssignmentSolution assignmentStudent){
		facultyService.UpdateAssignmnetStudent(assignmentStudent);
		return "AssignmentStudentList";
	}		
}
