package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the QUEUEDISABLEFENCEHISTORY database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Queuedisablefencehistory.findAll", query="SELECT q FROM Queuedisablefencehistory q")
public class Queuedisablefencehistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUEUEDISABLEFENCEHISTORY_QUEDISFENHISID_GENERATOR", sequenceName="QUEUEDISABLEFENCEHISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUEUEDISABLEFENCEHISTORY_QUEDISFENHISID_GENERATOR")
	@Column(name="QUEDISFENHIS_ID")
	private long quedisfenhisId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Temporal(TemporalType.DATE)
	@Column(name="QUEDISFENHIS_POPDATE")
	private Date quedisfenhisPopdate;

	@Temporal(TemporalType.DATE)
	@Column(name="QUEDISFENHIS_PUSHDATE")
	private Date quedisfenhisPushdate;

	//bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@ManyToOne
	@JoinColumn(name="CONTFEN_CONTFEN_ID")
	private Contactfence contactfence;

	//bi-directional many-to-one association to com.example.taller1.model.Personautotran
	@ManyToOne
	@JoinColumn(name="PERAUT_PERAUT_ID")
	private Personautotran personautotran;

	public Queuedisablefencehistory() {
	}

	public long getQuedisfenhisId() {
		return this.quedisfenhisId;
	}

	public void setQuedisfenhisId(long quedisfenhisId) {
		this.quedisfenhisId = quedisfenhisId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getQuedisfenhisPopdate() {
		return this.quedisfenhisPopdate;
	}

	public void setQuedisfenhisPopdate(Date quedisfenhisPopdate) {
		this.quedisfenhisPopdate = quedisfenhisPopdate;
	}

	public Date getQuedisfenhisPushdate() {
		return this.quedisfenhisPushdate;
	}

	public void setQuedisfenhisPushdate(Date quedisfenhisPushdate) {
		this.quedisfenhisPushdate = quedisfenhisPushdate;
	}

	public Contactfence getContactfence() {
		return this.contactfence;
	}

	public void setContactfence(Contactfence contactfence) {
		this.contactfence = contactfence;
	}

	public Personautotran getPersonautotran() {
		return this.personautotran;
	}

	public void setPersonautotran(Personautotran personautotran) {
		this.personautotran = personautotran;
	}

}