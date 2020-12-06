package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the QUEUE_AUTOHISTORY database table.
 * 
 */
@Entity
@Table(name="QUEUE_AUTOHISTORY")
@NamedQuery(name="com.example.taller1.model.QueueAutohistory.findAll", query="SELECT q FROM QueueAutohistory q")
public class QueueAutohistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUEUE_AUTOHISTORY_QUEAUTOHISID_GENERATOR", sequenceName="QUEUE_AUTOHISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUEUE_AUTOHISTORY_QUEAUTOHISID_GENERATOR")
	@Column(name="QUEAUTOHIS_ID")
	private long queautohisId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="QUEAUTO_IDVALUE")
	private BigDecimal queautoIdvalue;

	@Temporal(TemporalType.DATE)
	@Column(name="QUEAUTOHIS_POPDATE")
	private Date queautohisPopdate;

	@Temporal(TemporalType.DATE)
	@Column(name="QUEAUTOHIS_PUSHDATE")
	private Date queautohisPushdate;

	@Column(name="QUEAUTOHIS_SUCCEDED")
	private String queautohisSucceded;

	private BigDecimal queueautotransitionid;

	//bi-directional many-to-one association to com.example.taller1.model.Triggerr
	@ManyToOne
	@JoinColumn(name="TRIG_TRIG_ID")
	private Triggerr triggerr;

	public QueueAutohistory() {
	}

	public long getQueautohisId() {
		return this.queautohisId;
	}

	public void setQueautohisId(long queautohisId) {
		this.queautohisId = queautohisId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public BigDecimal getQueautoIdvalue() {
		return this.queautoIdvalue;
	}

	public void setQueautoIdvalue(BigDecimal queautoIdvalue) {
		this.queautoIdvalue = queautoIdvalue;
	}

	public Date getQueautohisPopdate() {
		return this.queautohisPopdate;
	}

	public void setQueautohisPopdate(Date queautohisPopdate) {
		this.queautohisPopdate = queautohisPopdate;
	}

	public Date getQueautohisPushdate() {
		return this.queautohisPushdate;
	}

	public void setQueautohisPushdate(Date queautohisPushdate) {
		this.queautohisPushdate = queautohisPushdate;
	}

	public String getQueautohisSucceded() {
		return this.queautohisSucceded;
	}

	public void setQueautohisSucceded(String queautohisSucceded) {
		this.queautohisSucceded = queautohisSucceded;
	}

	public BigDecimal getQueueautotransitionid() {
		return this.queueautotransitionid;
	}

	public void setQueueautotransitionid(BigDecimal queueautotransitionid) {
		this.queueautotransitionid = queueautotransitionid;
	}

	public Triggerr getTriggerr() {
		return this.triggerr;
	}

	public void setTriggerr(Triggerr triggerr) {
		this.triggerr = triggerr;
	}

}