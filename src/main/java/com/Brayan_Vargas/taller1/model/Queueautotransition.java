package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the QUEUEAUTOTRANSITION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Queueautotransition.findAll", query="SELECT q FROM Queueautotransition q")
public class Queueautotransition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUEUEAUTOTRANSITION_QUEAUTOID_GENERATOR", sequenceName="QUEUEAUTOTRANSITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUEUEAUTOTRANSITION_QUEAUTOID_GENERATOR")
	@Column(name="QUEAUTO_ID")
	private long queautoId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="QUEAUTO_IDVALUE")
	private BigDecimal queautoIdvalue;

	@Temporal(TemporalType.DATE)
	@Column(name="QUEAUTO_PUSHDATE")
	private Date queautoPushdate;

	//bi-directional many-to-one association to com.example.taller1.model.Triggerr
	@ManyToOne
	@JoinColumn(name="TRIG_TRIG_ID")
	private Triggerr triggerr;

	public Queueautotransition() {
	}

	public long getQueautoId() {
		return this.queautoId;
	}

	public void setQueautoId(long queautoId) {
		this.queautoId = queautoId;
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

	public Date getQueautoPushdate() {
		return this.queautoPushdate;
	}

	public void setQueautoPushdate(Date queautoPushdate) {
		this.queautoPushdate = queautoPushdate;
	}

	public Triggerr getTriggerr() {
		return this.triggerr;
	}

	public void setTriggerr(Triggerr triggerr) {
		this.triggerr = triggerr;
	}

}