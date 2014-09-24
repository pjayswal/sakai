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

import org.apache.commons.io.IOUtils;
import org.sakai.commons.Assignment;
import org.sakai.serviceclients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_TEACHER","ROLE_STUDENT"})
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
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
		return "student/SectionList";
	}

	
	@RequestMapping(value="/assignmentList/{id}",method=RequestMethod.GET)
	public String getAssignmentList(Model model, @PathVariable long id,HttpServletRequest request){
		request.getSession().setAttribute("section_id", ""+id);
		model.addAttribute("assignmentList", studentService.getAssignments(id));
		return "student/AssignmentList";
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
	
	@RequestMapping(value="/assignmentDownload/{id}",method=RequestMethod.GET)
	public String downloadAssignment(Model model,@PathVariable long id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttr){
		UserDetails userDetails =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Assignment assignment=studentService.getAssignment(id);
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
	    model.addAttribute("id", id);
		return "student/AssignmentList";
	}
	
	
	public String createAssignmentSolution(Model model, @PathVariable long id){
		model.addAttribute("id", id);
		return "AssignmentSolution";
	}
	
	@RequestMapping(value="/section/assignment/{id}",method=RequestMethod.GET)
	public String getAssignmentDetails(Model model, @PathVariable long id,HttpServletRequest request){
		int student_id = (int) request.getSession().getAttribute("student_id");
		model.addAttribute("assignmentList", studentService.getAssignmentStudent(student_id, id));
		return "AssignmentList";
	}
	
	

}
