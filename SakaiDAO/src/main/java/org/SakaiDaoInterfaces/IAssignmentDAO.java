package org.SakaiDaoInterfaces;

import org.SakaiCommons.Assignment;


public interface IAssignmentDAO {
	public void create(Assignment a);
	public void update(Assignment a);
	public Assignment get(long id);
	public void delete(Assignment a);
	public Assignment load(long id);
}
