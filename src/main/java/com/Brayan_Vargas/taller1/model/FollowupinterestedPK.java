package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FOLLOWUPINTERESTED database table.
 * 
 */
@Embeddable
public class FollowupinterestedPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FOLTYPE_FOLLOWUP_ID", insertable=false, updatable=false)
	private long foltypeFollowupId;

	@Column(name="ROLE_ROLE_ID", insertable=false, updatable=false)
	private long roleRoleId;

	public FollowupinterestedPK() {
	}
	public long getFoltypeFollowupId() {
		return this.foltypeFollowupId;
	}
	public void setFoltypeFollowupId(long foltypeFollowupId) {
		this.foltypeFollowupId = foltypeFollowupId;
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
		if (!(other instanceof FollowupinterestedPK)) {
			return false;
		}
		FollowupinterestedPK castOther = (FollowupinterestedPK)other;
		return 
			(this.foltypeFollowupId == castOther.foltypeFollowupId)
			&& (this.roleRoleId == castOther.roleRoleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.foltypeFollowupId ^ (this.foltypeFollowupId >>> 32)));
		hash = hash * prime + ((int) (this.roleRoleId ^ (this.roleRoleId >>> 32)));
		
		return hash;
	}
}