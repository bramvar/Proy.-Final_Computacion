package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the THRESHOLD database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Threshold.findAll", query="SELECT t FROM Threshold t")
public class Threshold implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="THRESHOLD_THRESID_GENERATOR", sequenceName="THRESHOLD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="THRESHOLD_THRESID_GENERATOR")
	@Column(name="THRES_ID")
	private long thresId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="THRES_NAME")
	private String thresName;

	@Column(name="THRES_VALUE")
	private String thresValue;

	@Column(name="THRES_VALUETYPE")
	private String thresValuetype;

	//bi-directional many-to-one association to com.example.taller1.model.Localcondition
	@OneToMany(mappedBy="threshold")
	private List<Localcondition> localconditions;

	//bi-directional many-to-one association to com.example.taller1.model.Remotecondition
	@OneToMany(mappedBy="threshold")
	private List<Remotecondition> remoteconditions;

	public Threshold() {
	}

	public long getThresId() {
		return this.thresId;
	}

	public void setThresId(long thresId) {
		this.thresId = thresId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getThresName() {
		return this.thresName;
	}

	public void setThresName(String thresName) {
		this.thresName = thresName;
	}

	public String getThresValue() {
		return this.thresValue;
	}

	public void setThresValue(String thresValue) {
		this.thresValue = thresValue;
	}

	public String getThresValuetype() {
		return this.thresValuetype;
	}

	public void setThresValuetype(String thresValuetype) {
		this.thresValuetype = thresValuetype;
	}

	public List<Localcondition> getLocalconditions() {
		return this.localconditions;
	}

	public void setLocalconditions(List<Localcondition> localconditions) {
		this.localconditions = localconditions;
	}

	public Localcondition addLocalcondition(Localcondition localcondition) {
		getLocalconditions().add(localcondition);
		localcondition.setThreshold(this);

		return localcondition;
	}

	public Localcondition removeLocalcondition(Localcondition localcondition) {
		getLocalconditions().remove(localcondition);
		localcondition.setThreshold(null);

		return localcondition;
	}

	public List<Remotecondition> getRemoteconditions() {
		return this.remoteconditions;
	}

	public void setRemoteconditions(List<Remotecondition> remoteconditions) {
		this.remoteconditions = remoteconditions;
	}

	public Remotecondition addRemotecondition(Remotecondition remotecondition) {
		getRemoteconditions().add(remotecondition);
		remotecondition.setThreshold(this);

		return remotecondition;
	}

	public Remotecondition removeRemotecondition(Remotecondition remotecondition) {
		getRemoteconditions().remove(remotecondition);
		remotecondition.setThreshold(null);

		return remotecondition;
	}

}