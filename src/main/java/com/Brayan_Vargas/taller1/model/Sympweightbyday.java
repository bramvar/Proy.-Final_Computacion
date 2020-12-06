package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SYMPWEIGHTBYDAYS database table.
 * 
 */
@Entity
@Table(name="SYMPWEIGHTBYDAYS")
@NamedQuery(name="com.example.taller1.model.Sympweightbyday.findAll", query="SELECT s FROM Sympweightbyday s")
public class Sympweightbyday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYMPWEIGHTBYDAYS_SYMPWEIDAYSID_GENERATOR", sequenceName="SYMPWEIGHTBYDAYS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYMPWEIGHTBYDAYS_SYMPWEIDAYSID_GENERATOR")
	@Column(name="SYMPWEIDAYS_ID")
	private long sympweidaysId;

	@Column(name="SYMPWEIDAYS_MAX")
	private BigDecimal sympweidaysMax;

	@Column(name="SYMPWEIDAYS_MIN")
	private BigDecimal sympweidaysMin;

	@Column(name="SYMPWEIDAYS_WEIGHT")
	private BigDecimal sympweidaysWeight;

	//bi-directional many-to-one association to com.example.taller1.model.Symptomquestion
	@ManyToOne
	@JoinColumn(name="SYMPQUES_SYMPQUES_ID")
	private Symptomquestion symptomquestion;

	public Sympweightbyday() {
	}

	public long getSympweidaysId() {
		return this.sympweidaysId;
	}

	public void setSympweidaysId(long sympweidaysId) {
		this.sympweidaysId = sympweidaysId;
	}

	public BigDecimal getSympweidaysMax() {
		return this.sympweidaysMax;
	}

	public void setSympweidaysMax(BigDecimal sympweidaysMax) {
		this.sympweidaysMax = sympweidaysMax;
	}

	public BigDecimal getSympweidaysMin() {
		return this.sympweidaysMin;
	}

	public void setSympweidaysMin(BigDecimal sympweidaysMin) {
		this.sympweidaysMin = sympweidaysMin;
	}

	public BigDecimal getSympweidaysWeight() {
		return this.sympweidaysWeight;
	}

	public void setSympweidaysWeight(BigDecimal sympweidaysWeight) {
		this.sympweidaysWeight = sympweidaysWeight;
	}

	public Symptomquestion getSymptomquestion() {
		return this.symptomquestion;
	}

	public void setSymptomquestion(Symptomquestion symptomquestion) {
		this.symptomquestion = symptomquestion;
	}

}