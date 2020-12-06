package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SYMPTOMPOLL database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Symptompoll.findAll", query="SELECT s FROM Symptompoll s")
public class Symptompoll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYMPTOMPOLL_SYMPOLLID_GENERATOR", sequenceName="SYMPTOMPOLL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYMPTOMPOLL_SYMPOLLID_GENERATOR")
	@Column(name="SYMPOLL_ID")
	private long sympollId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Temporal(TemporalType.DATE)
	@Column(name="SYMPOLL_ENDDATE")
	private Date sympollEnddate;

	@Column(name="SYMPOLL_NAME")
	private String sympollName;

	@Temporal(TemporalType.DATE)
	@Column(name="SYMPOLL_STARTDATE")
	private Date sympollStartdate;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemevent
	@ManyToOne
	@JoinColumn(name="EPIEVE_EPIEVE_ID")
	private Epidemevent epidemevent;

	//bi-directional many-to-one association to com.example.taller1.model.Symptomquestion
	@OneToMany(mappedBy="symptompoll")
	private List<Symptomquestion> symptomquestions;

	public Symptompoll() {
	}

	public long getSympollId() {
		return this.sympollId;
	}

	public void setSympollId(long sympollId) {
		this.sympollId = sympollId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getSympollEnddate() {
		return this.sympollEnddate;
	}

	public void setSympollEnddate(Date sympollEnddate) {
		this.sympollEnddate = sympollEnddate;
	}

	public String getSympollName() {
		return this.sympollName;
	}

	public void setSympollName(String sympollName) {
		this.sympollName = sympollName;
	}

	public Date getSympollStartdate() {
		return this.sympollStartdate;
	}

	public void setSympollStartdate(Date sympollStartdate) {
		this.sympollStartdate = sympollStartdate;
	}

	public Epidemevent getEpidemevent() {
		return this.epidemevent;
	}

	public void setEpidemevent(Epidemevent epidemevent) {
		this.epidemevent = epidemevent;
	}

	public List<Symptomquestion> getSymptomquestions() {
		return this.symptomquestions;
	}

	public void setSymptomquestions(List<Symptomquestion> symptomquestions) {
		this.symptomquestions = symptomquestions;
	}

	public Symptomquestion addSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().add(symptomquestion);
		symptomquestion.setSymptompoll(this);

		return symptomquestion;
	}

	public Symptomquestion removeSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().remove(symptomquestion);
		symptomquestion.setSymptompoll(null);

		return symptomquestion;
	}

}