package org.SakaiDaoInterfaces;

import org.SakaiCommons.AssignmentStudent;

public interface IAssignmentStudentDAO {
	public void create(AssignmentStudent as);
	public void update(AssignmentStudent as);
	public AssignmentStudent get(long id);
	public void delete(AssignmentStudent as);
	public AssignmentStudent load(long id);
}
