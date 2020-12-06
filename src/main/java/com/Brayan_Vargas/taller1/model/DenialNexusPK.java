package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DENIAL_NEXUS database table.
 * 
 */
@Embeddable
public class DenialNexusPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EPINEX_EPINEX_ID", insertable=false, updatable=false)
	private long epinexEpinexId;

	@Column(name="ACCDENEVE_ACCDENEVE_ID", insertable=false, updatable=false)
	private long accdeneveAccdeneveId;

	public DenialNexusPK() {
	}
	public long getEpinexEpinexId() {
		return this.epinexEpinexId;
	}
	public void setEpinexEpinexId(long epinexEpinexId) {
		this.epinexEpinexId = epinexEpinexId;
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
		if (!(other instanceof DenialNexusPK)) {
			return false;
		}
		DenialNexusPK castOther = (DenialNexusPK)other;
		return 
			(this.epinexEpinexId == castOther.epinexEpinexId)
			&& (this.accdeneveAccdeneveId == castOther.accdeneveAccdeneveId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.epinexEpinexId ^ (this.epinexEpinexId >>> 32)));
		hash = hash * prime + ((int) (this.accdeneveAccdeneveId ^ (this.accdeneveAccdeneveId >>> 32)));
		
		return hash;
	}
}