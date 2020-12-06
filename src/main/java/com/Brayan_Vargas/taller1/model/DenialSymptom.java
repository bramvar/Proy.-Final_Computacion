package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the DENIAL_SYMPTOM database table.
 *
 */
@Entity
@Table(name = "DENIAL_SYMPTOM")
@NamedQuery(name = "com.example.taller1.model.DenialSymptom.findAll", query = "SELECT d FROM DenialSymptom d")
public class DenialSymptom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DenialSymptomPK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Accessdenialevent
	@ManyToOne
	@JoinColumn(name = "ACCDENEVE_ACCDENEVE_ID", insertable = false, updatable = false)
	private Accessdenialevent accessdenialevent;

	// bi-directional many-to-one association to com.example.taller1.model.Symptom
	@ManyToOne
	@JoinColumn(name = "SYMP_SYMP_ID", insertable = false, updatable = false)
	private Symptom symptom;

	public DenialSymptom() {
	}

	public Accessdenialevent getAccessdenialevent() {
		return this.accessdenialevent;
	}

	public String getDumy() {
		return this.dumy;
	}

	public DenialSymptomPK getId() {
		return this.id;
	}

	public Symptom getSymptom() {
		return this.symptom;
	}

	public void setAccessdenialevent(Accessdenialevent accessdenialevent) {
		this.accessdenialevent = accessdenialevent;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setId(DenialSymptomPK id) {
		this.id = id;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

}