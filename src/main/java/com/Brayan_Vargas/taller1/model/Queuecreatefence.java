package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the QUEUECREATEFENCE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Queuecreatefence.findAll", query="SELECT q FROM Queuecreatefence q")
public class Queuecreatefence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUEUECREATEFENCE_QUECREFENID_GENERATOR", sequenceName="QUEUECREATEFENCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUEUECREATEFENCE_QUECREFENID_GENERATOR")
	@Column(name="QUECREFEN_ID")
	private long quecrefenId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Temporal(TemporalType.DATE)
	@Column(name="QUECREFEN_PUSHDATE")
	private Date quecrefenPushdate;

	//bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@ManyToOne
	@JoinColumn(name="CONTFEN_CONTFEN_ID")
	private Contactfence contactfence;

	//bi-directional many-to-one association to com.example.taller1.model.Personautotran
	@ManyToOne
	@JoinColumn(name="PERAUT_PERAUT_ID")
	private Personautotran personautotran;

	public Queuecreatefence() {
	}

	public long getQuecrefenId() {
		return this.quecrefenId;
	}

	public void setQuecrefenId(long quecrefenId) {
		this.quecrefenId = quecrefenId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getQuecrefenPushdate() {
		return this.quecrefenPushdate;
	}

	public void setQuecrefenPushdate(Date quecrefenPushdate) {
		this.quecrefenPushdate = quecrefenPushdate;
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