package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the QUEUECREATEFENCEHISTORY database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Queuecreatefencehistory.findAll", query="SELECT q FROM Queuecreatefencehistory q")
public class Queuecreatefencehistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUEUECREATEFENCEHISTORY_QUECREFENHISID_GENERATOR", sequenceName="QUEUECREATEFENCEHISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUEUECREATEFENCEHISTORY_QUECREFENHISID_GENERATOR")
	@Column(name="QUECREFENHIS_ID")
	private long quecrefenhisId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Temporal(TemporalType.DATE)
	@Column(name="QUECREFENHIS_POPDATE")
	private Date quecrefenhisPopdate;

	@Temporal(TemporalType.DATE)
	@Column(name="QUECREFENHIS_PUSHDATE")
	private Date quecrefenhisPushdate;

	//bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@ManyToOne
	@JoinColumn(name="CONTFEN_CONTFEN_ID")
	private Contactfence contactfence;

	//bi-directional many-to-one association to com.example.taller1.model.Personautotran
	@ManyToOne
	@JoinColumn(name="PERAUT_PERAUT_ID")
	private Personautotran personautotran;

	public Queuecreatefencehistory() {
	}

	public long getQuecrefenhisId() {
		return this.quecrefenhisId;
	}

	public void setQuecrefenhisId(long quecrefenhisId) {
		this.quecrefenhisId = quecrefenhisId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getQuecrefenhisPopdate() {
		return this.quecrefenhisPopdate;
	}

	public void setQuecrefenhisPopdate(Date quecrefenhisPopdate) {
		this.quecrefenhisPopdate = quecrefenhisPopdate;
	}

	public Date getQuecrefenhisPushdate() {
		return this.quecrefenhisPushdate;
	}

	public void setQuecrefenhisPushdate(Date quecrefenhisPushdate) {
		this.quecrefenhisPushdate = quecrefenhisPushdate;
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