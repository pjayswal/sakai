package org.sakai.serviceclients;

import java.util.List;

import org.sakai.commons.Course;
import org.sakai.commons.Section;

public interface ICourseAdminService {
	public List<Course> getCourses();
	public List<Section> getSections(long courseId);
	public Course getCourse(long id);
	public Section getSection(long id);
	public void updateSection(Section section);
	public void updateCourse(Course course);
	
}
