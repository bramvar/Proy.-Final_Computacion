package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VISIT_VISITREASON database table.
 * 
 */
@Embeddable
public class VisitVisitreasonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="VISIT_VISIT_ID", insertable=false, updatable=false)
	private long visitVisitId;

	@Column(name="VISREA_VISREA_ID", insertable=false, updatable=false)
	private long visreaVisreaId;

	public VisitVisitreasonPK() {
	}
	public long getVisitVisitId() {
		return this.visitVisitId;
	}
	public void setVisitVisitId(long visitVisitId) {
		this.visitVisitId = visitVisitId;
	}
	public long getVisreaVisreaId() {
		return this.visreaVisreaId;
	}
	public void setVisreaVisreaId(long visreaVisreaId) {
		this.visreaVisreaId = visreaVisreaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VisitVisitreasonPK)) {
			return false;
		}
		VisitVisitreasonPK castOther = (VisitVisitreasonPK)other;
		return 
			(this.visitVisitId == castOther.visitVisitId)
			&& (this.visreaVisreaId == castOther.visreaVisreaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.visitVisitId ^ (this.visitVisitId >>> 32)));
		hash = hash * prime + ((int) (this.visreaVisreaId ^ (this.visreaVisreaId >>> 32)));
		
		return hash;
	}
}