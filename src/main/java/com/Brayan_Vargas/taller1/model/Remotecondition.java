package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REMOTECONDITION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Remotecondition.findAll", query="SELECT r FROM Remotecondition r")
public class Remotecondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REMOTECONDITION_RECONID_GENERATOR", sequenceName="REMOTECONDITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REMOTECONDITION_RECONID_GENERATOR")
	@Column(name="RECON_ID")
	private long reconId;

	@Column(name="RECON_DELEGATENAME")
	private String reconDelegatename;

	@Column(name="RECON_METHODNAME")
	private String reconMethodname;

	@Column(name="RECON_OPERATOR")
	private String reconOperator;

	@Column(name="RECON_PARAMETERNAME")
	private String reconParametername;

	@Column(name="RECON_RETURNVALUETYPE")
	private String reconReturnvaluetype;

	//bi-directional many-to-one association to com.example.taller1.model.Precondition
	@ManyToOne
	@JoinColumn(name="PRECON_PRECON_ID")
	private Precondition precondition;

	//bi-directional many-to-one association to com.example.taller1.model.Threshold
	@ManyToOne
	@JoinColumn(name="THRES_THRES_ID")
	private Threshold threshold;

	public Remotecondition() {
	}

	public long getReconId() {
		return this.reconId;
	}

	public void setReconId(long reconId) {
		this.reconId = reconId;
	}

	public String getReconDelegatename() {
		return this.reconDelegatename;
	}

	public void setReconDelegatename(String reconDelegatename) {
		this.reconDelegatename = reconDelegatename;
	}

	public String getReconMethodname() {
		return this.reconMethodname;
	}

	public void setReconMethodname(String reconMethodname) {
		this.reconMethodname = reconMethodname;
	}

	public String getReconOperator() {
		return this.reconOperator;
	}

	public void setReconOperator(String reconOperator) {
		this.reconOperator = reconOperator;
	}

	public String getReconParametername() {
		return this.reconParametername;
	}

	public void setReconParametername(String reconParametername) {
		this.reconParametername = reconParametername;
	}

	public String getReconReturnvaluetype() {
		return this.reconReturnvaluetype;
	}

	public void setReconReturnvaluetype(String reconReturnvaluetype) {
		this.reconReturnvaluetype = reconReturnvaluetype;
	}

	public Precondition getPrecondition() {
		return this.precondition;
	}

	public void setPrecondition(Precondition precondition) {
		this.precondition = precondition;
	}

	public Threshold getThreshold() {
		return this.threshold;
	}

	public void setThreshold(Threshold threshold) {
		this.threshold = threshold;
	}

}