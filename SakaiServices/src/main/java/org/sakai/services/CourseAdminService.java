package org.sakai.services;

import java.util.List;

import org.sakai.commons.Course;
import org.sakai.commons.Section;
import org.sakai.daointerfaces.ICourseDAO;
import org.sakai.daointerfaces.ISectionDAO;
import org.sakai.serviceclients.ICourseAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class CourseAdminService implements ICourseAdminService {
	@Autowired
	public ICourseDAO courseDAO;
	@Autowired
	public ISectionDAO sectionDAO;
	
	public List<Course> getCourses() {
		return courseDAO.getAll();
	}

	public List<Section> getSections(long courseId) {
		return sectionDAO.getAll(courseId);
	}

	public Course getCourse(long id) {
		return courseDAO.get(id);
	}

	public Section getSection(long id) {
		return sectionDAO.get(id);
	}

	public void updateSection(Section section) {
		sectionDAO.update(section);

	}

	public void updateCourse(Course course) {
		courseDAO.update(course);

	}

}
