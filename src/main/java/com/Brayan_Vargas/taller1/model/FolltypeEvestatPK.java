package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FOLLTYPE_EVESTAT database table.
 * 
 */
@Embeddable
public class FolltypeEvestatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FOLTYPE_FOLLOWUP_ID", insertable=false, updatable=false)
	private long foltypeFollowupId;

	@Column(name="EVESTAT_EVESTAT_ID")
	private long evestatEvestatId;

	public FolltypeEvestatPK() {
	}
	public long getFoltypeFollowupId() {
		return this.foltypeFollowupId;
	}
	public void setFoltypeFollowupId(long foltypeFollowupId) {
		this.foltypeFollowupId = foltypeFollowupId;
	}
	public long getEvestatEvestatId() {
		return this.evestatEvestatId;
	}
	public void setEvestatEvestatId(long evestatEvestatId) {
		this.evestatEvestatId = evestatEvestatId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FolltypeEvestatPK)) {
			return false;
		}
		FolltypeEvestatPK castOther = (FolltypeEvestatPK)other;
		return 
			(this.foltypeFollowupId == castOther.foltypeFollowupId)
			&& (this.evestatEvestatId == castOther.evestatEvestatId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.foltypeFollowupId ^ (this.foltypeFollowupId >>> 32)));
		hash = hash * prime + ((int) (this.evestatEvestatId ^ (this.evestatEvestatId >>> 32)));
		
		return hash;
	}
}