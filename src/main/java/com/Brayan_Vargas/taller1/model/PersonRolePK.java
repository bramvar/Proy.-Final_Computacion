package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERSON_ROLE database table.
 * 
 */
@Embeddable
public class PersonRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PERS_PERS_ID", insertable=false, updatable=false)
	private long persPersId;

	@Column(name="ROLE_ROLE_ID", insertable=false, updatable=false)
	private long roleRoleId;

	public PersonRolePK() {
	}
	public long getPersPersId() {
		return this.persPersId;
	}
	public void setPersPersId(long persPersId) {
		this.persPersId = persPersId;
	}
	public long getRoleRoleId() {
		return this.roleRoleId;
	}
	public void setRoleRoleId(long roleRoleId) {
		this.roleRoleId = roleRoleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonRolePK)) {
			return false;
		}
		PersonRolePK castOther = (PersonRolePK)other;
		return 
			(this.persPersId == castOther.persPersId)
			&& (this.roleRoleId == castOther.roleRoleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.persPersId ^ (this.persPersId >>> 32)));
		hash = hash * prime + ((int) (this.roleRoleId ^ (this.roleRoleId >>> 32)));
		
		return hash;
	}
}