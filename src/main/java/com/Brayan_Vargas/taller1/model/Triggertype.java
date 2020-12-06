package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TRIGGERTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Triggertype.findAll", query="SELECT t FROM Triggertype t")
public class Triggertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRIGGERTYPE_TRIGTYPEID_GENERATOR", sequenceName="TRIGGERTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRIGGERTYPE_TRIGTYPEID_GENERATOR")
	@Column(name="TRIGTYPE_ID")
	private long trigtypeId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="TRIGTYPE_NAME")
	private String trigtypeName;

	//bi-directional many-to-one association to com.example.taller1.model.Triggerr
	@OneToMany(mappedBy="triggertype")
	private List<Triggerr> triggerrs;

	public Triggertype() {
	}

	public long getTrigtypeId() {
		return this.trigtypeId;
	}

	public void setTrigtypeId(long trigtypeId) {
		this.trigtypeId = trigtypeId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getTrigtypeName() {
		return this.trigtypeName;
	}

	public void setTrigtypeName(String trigtypeName) {
		this.trigtypeName = trigtypeName;
	}

	public List<Triggerr> getTriggerrs() {
		return this.triggerrs;
	}

	public void setTriggerrs(List<Triggerr> triggerrs) {
		this.triggerrs = triggerrs;
	}

	public Triggerr addTriggerr(Triggerr triggerr) {
		getTriggerrs().add(triggerr);
		triggerr.setTriggertype(this);

		return triggerr;
	}

	public Triggerr removeTriggerr(Triggerr triggerr) {
		getTriggerrs().remove(triggerr);
		triggerr.setTriggertype(null);

		return triggerr;
	}

}