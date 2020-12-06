package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DENIAL_SYMPTOM database table.
 * 
 */
@Embeddable
public class DenialSymptomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SYMP_SYMP_ID", insertable=false, updatable=false)
	private long sympSympId;

	@Column(name="ACCDENEVE_ACCDENEVE_ID", insertable=false, updatable=false)
	private long accdeneveAccdeneveId;

	public DenialSymptomPK() {
	}
	public long getSympSympId() {
		return this.sympSympId;
	}
	public void setSympSympId(long sympSympId) {
		this.sympSympId = sympSympId;
	}
	public long getAccdeneveAccdeneveId() {
		return this.accdeneveAccdeneveId;
	}
	public void setAccdeneveAccdeneveId(long accdeneveAccdeneveId) {
		this.accdeneveAccdeneveId = accdeneveAccdeneveId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DenialSymptomPK)) {
			return false;
		}
		DenialSymptomPK castOther = (DenialSymptomPK)other;
		return 
			(this.sympSympId == castOther.sympSympId)
			&& (this.accdeneveAccdeneveId == castOther.accdeneveAccdeneveId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.sympSympId ^ (this.sympSympId >>> 32)));
		hash = hash * prime + ((int) (this.accdeneveAccdeneveId ^ (this.accdeneveAccdeneveId >>> 32)));
		
		return hash;
	}
}