package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CHECK_MEASUR database table.
 *
 */
@Entity
@Table(name = "CHECK_MEASUR")
@NamedQuery(name = "com.example.taller1.model.CheckMeasur.findAll", query = "SELECT c FROM CheckMeasur c")
public class CheckMeasur implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CheckMeasurPK id;

	private BigDecimal measvalue;

	// bi-directional many-to-one association to com.example.taller1.model.Measurement
	@ManyToOne
	@JoinColumn(name = "MEAS_MEAS_ID", insertable = false, updatable = false)
	private Measurement measurement;

	// bi-directional many-to-one association to com.example.taller1.model.Physicalcheckup
	@ManyToOne
	@JoinColumn(name = "PHYCHE_PHYCHE_ID", insertable = false, updatable = false)
	private Physicalcheckup physicalcheckup;

	public CheckMeasur() {
	}

	public CheckMeasurPK getId() {
		return this.id;
	}

	public Measurement getMeasurement() {
		return this.measurement;
	}

	public BigDecimal getMeasvalue() {
		return this.measvalue;
	}

	public Physicalcheckup getPhysicalcheckup() {
		return this.physicalcheckup;
	}

	public void setId(CheckMeasurPK id) {
		this.id = id;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public void setMeasvalue(BigDecimal measvalue) {
		this.measvalue = measvalue;
	}

	public void setPhysicalcheckup(Physicalcheckup physicalcheckup) {
		this.physicalcheckup = physicalcheckup;
	}

}