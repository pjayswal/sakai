package org.SakaiServiceClients;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.Course;
import org.SakaiCommons.Person;
import org.SakaiCommons.Section;

public interface IService {
		public void CreateUser(Person p);
		public void CreateCourse(Course c);
		public void CreateSection(Section s);
		
}
