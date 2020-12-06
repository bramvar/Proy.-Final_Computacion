package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERM_FOLLTYPE database table.
 * 
 */
@Embeddable
public class PermFolltypePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PERM_PERM_ID", insertable=false, updatable=false)
	private long permPermId;

	@Column(name="FOLTYPE_FOLLOWUP_ID", insertable=false, updatable=false)
	private long foltypeFollowupId;

	public PermFolltypePK() {
	}
	public long getPermPermId() {
		return this.permPermId;
	}
	public void setPermPermId(long permPermId) {
		this.permPermId = permPermId;
	}
	public long getFoltypeFollowupId() {
		return this.foltypeFollowupId;
	}
	public void setFoltypeFollowupId(long foltypeFollowupId) {
		this.foltypeFollowupId = foltypeFollowupId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PermFolltypePK)) {
			return false;
		}
		PermFolltypePK castOther = (PermFolltypePK)other;
		return 
			(this.permPermId == castOther.permPermId)
			&& (this.foltypeFollowupId == castOther.foltypeFollowupId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.permPermId ^ (this.permPermId >>> 32)));
		hash = hash * prime + ((int) (this.foltypeFollowupId ^ (this.foltypeFollowupId >>> 32)));
		
		return hash;
	}
}