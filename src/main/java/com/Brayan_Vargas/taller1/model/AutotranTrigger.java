package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the AUTOTRAN_TRIGGER database table.
 *
 */
@Entity
@Table(name = "AUTOTRAN_TRIGGER")
@NamedQuery(name = "com.example.taller1.model.AutotranTrigger.findAll", query = "SELECT a FROM AutotranTrigger a")
public class AutotranTrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AutotranTriggerPK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Autotransition
	@ManyToOne
	@JoinColumn(name = "AUTOTRAN_AUTOTRAN_ID", insertable = false, updatable = false)
	private Autotransition autotransition;

	// bi-directional many-to-one association to com.example.taller1.model.Triggerr
	@ManyToOne
	@JoinColumn(name = "TRIG_TRIG_ID", insertable = false, updatable = false)
	private Triggerr triggerr;

	public AutotranTrigger() {
	}

	public Autotransition getAutotransition() {
		return this.autotransition;
	}

	public String getDumy() {
		return this.dumy;
	}

	public AutotranTriggerPK getId() {
		return this.id;
	}

	public Triggerr getTriggerr() {
		return this.triggerr;
	}

	public void setAutotransition(Autotransition autotransition) {
		this.autotransition = autotransition;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setId(AutotranTriggerPK id) {
		this.id = id;
	}

	public void setTriggerr(Triggerr triggerr) {
		this.triggerr = triggerr;
	}

}