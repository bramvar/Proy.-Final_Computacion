package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the VISIT_VISITREASON database table.
 *
 */
@Entity
@Table(name = "VISIT_VISITREASON")
@NamedQuery(name = "com.example.taller1.model.VisitVisitreason.findAll", query = "SELECT v FROM VisitVisitreason v")
public class VisitVisitreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VisitVisitreasonPK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Visit
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Visit visit;

	// bi-directional many-to-one association to com.example.taller1.model.Visitreason
	@ManyToOne
	@JoinColumn(name = "VISREA_VISREA_ID", insertable = false, updatable = false)
	private Visitreason visitreason;

	public VisitVisitreason() {
	}

	public String getDumy() {
		return this.dumy;
	}

	public VisitVisitreasonPK getId() {
		return this.id;
	}

	public Visit getVisit() {
		return this.visit;
	}

	public Visitreason getVisitreason() {
		return this.visitreason;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setId(VisitVisitreasonPK id) {
		this.id = id;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public void setVisitreason(Visitreason visitreason) {
		this.visitreason = visitreason;
	}

}