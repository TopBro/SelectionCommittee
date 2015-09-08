package ua.nure.zhabin.SelectionCommittee.db.entity;

import java.io.Serializable;

/**
 * Root of all entities which have identifier field.
 * 
 * @author A.Zhabin
 *
 */
public class Entity implements Serializable {

	private static final long serialVersionUID = 4264540938408604226L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
