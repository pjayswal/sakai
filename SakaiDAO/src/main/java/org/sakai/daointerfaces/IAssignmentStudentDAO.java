package org.sakai.daointerfaces;

import org.sakai.commons.AssignmentSolution;

public interface IAssignmentStudentDAO {
	public void create(AssignmentSolution as);
	public void update(AssignmentSolution as);
	public AssignmentSolution get(long id);
	public void delete(AssignmentSolution as);
	public AssignmentSolution load(long id);
}
