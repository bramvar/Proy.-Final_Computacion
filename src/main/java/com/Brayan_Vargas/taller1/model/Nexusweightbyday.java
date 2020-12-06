package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the NEXUSWEIGHTBYDAYS database table.
 * 
 */
@Entity
@Table(name="NEXUSWEIGHTBYDAYS")
@NamedQuery(name="com.example.taller1.model.Nexusweightbyday.findAll", query="SELECT n FROM Nexusweightbyday n")
public class Nexusweightbyday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NEXUSWEIGHTBYDAYS_NEXWEIDAYSID_GENERATOR", sequenceName="NEXUSWEIGHTBYDAYS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NEXUSWEIGHTBYDAYS_NEXWEIDAYSID_GENERATOR")
	@Column(name="NEXWEIDAYS_ID")
	private long nexweidaysId;

	@Column(name="NEXWEIDAYS_MAX")
	private BigDecimal nexweidaysMax;

	@Column(name="NEXWEIDAYS_MIN")
	private BigDecimal nexweidaysMin;

	@Column(name="NEXWEIDAYS_WEIGHT")
	private BigDecimal nexweidaysWeight;

	//bi-directional many-to-one association to com.example.taller1.model.Nexusquestion
	@ManyToOne
	@JoinColumn(name="NEXQUES_NEXQUES_ID")
	private Nexusquestion nexusquestion;

	public Nexusweightbyday() {
	}

	public long getNexweidaysId() {
		return this.nexweidaysId;
	}

	public void setNexweidaysId(long nexweidaysId) {
		this.nexweidaysId = nexweidaysId;
	}

	public BigDecimal getNexweidaysMax() {
		return this.nexweidaysMax;
	}

	public void setNexweidaysMax(BigDecimal nexweidaysMax) {
		this.nexweidaysMax = nexweidaysMax;
	}

	public BigDecimal getNexweidaysMin() {
		return this.nexweidaysMin;
	}

	public void setNexweidaysMin(BigDecimal nexweidaysMin) {
		this.nexweidaysMin = nexweidaysMin;
	}

	public BigDecimal getNexweidaysWeight() {
		return this.nexweidaysWeight;
	}

	public void setNexweidaysWeight(BigDecimal nexweidaysWeight) {
		this.nexweidaysWeight = nexweidaysWeight;
	}

	public Nexusquestion getNexusquestion() {
		return this.nexusquestion;
	}

	public void setNexusquestion(Nexusquestion nexusquestion) {
		this.nexusquestion = nexusquestion;
	}

}