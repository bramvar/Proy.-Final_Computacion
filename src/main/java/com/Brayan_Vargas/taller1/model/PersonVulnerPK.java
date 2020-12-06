package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERSON_VULNER database table.
 * 
 */
@Embeddable
public class PersonVulnerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PERS_PERS_ID", insertable=false, updatable=false)
	private long persPersId;

	@Column(name="VULQUES_VULQUES_ID", insertable=false, updatable=false)
	private long vulquesVulquesId;

	public PersonVulnerPK() {
	}
	public long getPersPersId() {
		return this.persPersId;
	}
	public void setPersPersId(long persPersId) {
		this.persPersId = persPersId;
	}
	public long getVulquesVulquesId() {
		return this.vulquesVulquesId;
	}
	public void setVulquesVulquesId(long vulquesVulquesId) {
		this.vulquesVulquesId = vulquesVulquesId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonVulnerPK)) {
			return false;
		}
		PersonVulnerPK castOther = (PersonVulnerPK)other;
		return 
			(this.persPersId == castOther.persPersId)
			&& (this.vulquesVulquesId == castOther.vulquesVulquesId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.persPersId ^ (this.persPersId >>> 32)));
		hash = hash * prime + ((int) (this.vulquesVulquesId ^ (this.vulquesVulquesId >>> 32)));
		
		return hash;
	}
}