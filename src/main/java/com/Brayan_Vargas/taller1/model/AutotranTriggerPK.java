package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AUTOTRAN_TRIGGER database table.
 * 
 */
@Embeddable
public class AutotranTriggerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="AUTOTRAN_AUTOTRAN_ID", insertable=false, updatable=false)
	private long autotranAutotranId;

	@Column(name="TRIG_TRIG_ID", insertable=false, updatable=false)
	private long trigTrigId;

	public AutotranTriggerPK() {
	}
	public long getAutotranAutotranId() {
		return this.autotranAutotranId;
	}
	public void setAutotranAutotranId(long autotranAutotranId) {
		this.autotranAutotranId = autotranAutotranId;
	}
	public long getTrigTrigId() {
		return this.trigTrigId;
	}
	public void setTrigTrigId(long trigTrigId) {
		this.trigTrigId = trigTrigId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AutotranTriggerPK)) {
			return false;
		}
		AutotranTriggerPK castOther = (AutotranTriggerPK)other;
		return 
			(this.autotranAutotranId == castOther.autotranAutotranId)
			&& (this.trigTrigId == castOther.trigTrigId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.autotranAutotranId ^ (this.autotranAutotranId >>> 32)));
		hash = hash * prime + ((int) (this.trigTrigId ^ (this.trigTrigId >>> 32)));
		
		return hash;
	}
}