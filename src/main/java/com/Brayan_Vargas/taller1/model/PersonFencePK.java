package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERSON_FENCE database table.
 * 
 */
@Embeddable
public class PersonFencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PERS_PERS_ID", insertable=false, updatable=false)
	private long persPersId;

	@Column(name="CONTFEN_CONTFEN_ID", insertable=false, updatable=false)
	private long contfenContfenId;

	public PersonFencePK() {
	}
	public long getPersPersId() {
		return this.persPersId;
	}
	public void setPersPersId(long persPersId) {
		this.persPersId = persPersId;
	}
	public long getContfenContfenId() {
		return this.contfenContfenId;
	}
	public void setContfenContfenId(long contfenContfenId) {
		this.contfenContfenId = contfenContfenId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonFencePK)) {
			return false;
		}
		PersonFencePK castOther = (PersonFencePK)other;
		return 
			(this.persPersId == castOther.persPersId)
			&& (this.contfenContfenId == castOther.contfenContfenId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.persPersId ^ (this.persPersId >>> 32)));
		hash = hash * prime + ((int) (this.contfenContfenId ^ (this.contfenContfenId >>> 32)));
		
		return hash;
	}
}