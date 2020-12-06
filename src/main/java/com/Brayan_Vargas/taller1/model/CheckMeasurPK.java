package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CHECK_MEASUR database table.
 * 
 */
@Embeddable
public class CheckMeasurPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PHYCHE_PHYCHE_ID", insertable=false, updatable=false)
	private long phychePhycheId;

	@Column(name="MEAS_MEAS_ID", insertable=false, updatable=false)
	private long measMeasId;

	public CheckMeasurPK() {
	}
	public long getPhychePhycheId() {
		return this.phychePhycheId;
	}
	public void setPhychePhycheId(long phychePhycheId) {
		this.phychePhycheId = phychePhycheId;
	}
	public long getMeasMeasId() {
		return this.measMeasId;
	}
	public void setMeasMeasId(long measMeasId) {
		this.measMeasId = measMeasId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CheckMeasurPK)) {
			return false;
		}
		CheckMeasurPK castOther = (CheckMeasurPK)other;
		return 
			(this.phychePhycheId == castOther.phychePhycheId)
			&& (this.measMeasId == castOther.measMeasId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.phychePhycheId ^ (this.phychePhycheId >>> 32)));
		hash = hash * prime + ((int) (this.measMeasId ^ (this.measMeasId >>> 32)));
		
		return hash;
	}
}