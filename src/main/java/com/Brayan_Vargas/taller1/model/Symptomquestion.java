package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SYMPTOMQUESTION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Symptomquestion.findAll", query="SELECT s FROM Symptomquestion s")
public class Symptomquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYMPTOMQUESTION_SYMPQUESID_GENERATOR", sequenceName="SYMPTOMQUESTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYMPTOMQUESTION_SYMPQUESID_GENERATOR")
	@Column(name="SYMPQUES_ID")
	private long sympquesId;

	@Column(name="SYMPQUES_ACTIVATIONANSWER")
	private String sympquesActivationanswer;

	@Column(name="SYMPQUES_ISACTIVE")
	private String sympquesIsactive;

	@Column(name="SYMPQUES_NAME")
	private String sympquesName;

	@Column(name="SYMPQUES_WEIGHT")
	private BigDecimal sympquesWeight;

	//bi-directional many-to-one association to com.example.taller1.model.Symptom
	@ManyToOne
	@JoinColumn(name="SYMP_SYMP_ID")
	private Symptom symptom;

	//bi-directional many-to-one association to com.example.taller1.model.Symptompoll
	@ManyToOne
	@JoinColumn(name="SYMPOLL_SYMPOLL_ID")
	private Symptompoll symptompoll;

	//bi-directional many-to-one association to com.example.taller1.model.Sympweightbyday
	@OneToMany(mappedBy="symptomquestion")
	private List<Sympweightbyday> sympweightbydays;

	//bi-directional many-to-one association to com.example.taller1.model.UstPersonSymptom
	@OneToMany(mappedBy="symptomquestion")
	private List<UstPersonSymptom> ustPersonSymptoms;

	public Symptomquestion() {
	}

	public long getSympquesId() {
		return this.sympquesId;
	}

	public void setSympquesId(long sympquesId) {
		this.sympquesId = sympquesId;
	}

	public String getSympquesActivationanswer() {
		return this.sympquesActivationanswer;
	}

	public void setSympquesActivationanswer(String sympquesActivationanswer) {
		this.sympquesActivationanswer = sympquesActivationanswer;
	}

	public String getSympquesIsactive() {
		return this.sympquesIsactive;
	}

	public void setSympquesIsactive(String sympquesIsactive) {
		this.sympquesIsactive = sympquesIsactive;
	}

	public String getSympquesName() {
		return this.sympquesName;
	}

	public void setSympquesName(String sympquesName) {
		this.sympquesName = sympquesName;
	}

	public BigDecimal getSympquesWeight() {
		return this.sympquesWeight;
	}

	public void setSympquesWeight(BigDecimal sympquesWeight) {
		this.sympquesWeight = sympquesWeight;
	}

	public Symptom getSymptom() {
		return this.symptom;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

	public Symptompoll getSymptompoll() {
		return this.symptompoll;
	}

	public void setSymptompoll(Symptompoll symptompoll) {
		this.symptompoll = symptompoll;
	}

	public List<Sympweightbyday> getSympweightbydays() {
		return this.sympweightbydays;
	}

	public void setSympweightbydays(List<Sympweightbyday> sympweightbydays) {
		this.sympweightbydays = sympweightbydays;
	}

	public Sympweightbyday addSympweightbyday(Sympweightbyday sympweightbyday) {
		getSympweightbydays().add(sympweightbyday);
		sympweightbyday.setSymptomquestion(this);

		return sympweightbyday;
	}

	public Sympweightbyday removeSympweightbyday(Sympweightbyday sympweightbyday) {
		getSympweightbydays().remove(sympweightbyday);
		sympweightbyday.setSymptomquestion(null);

		return sympweightbyday;
	}

	public List<UstPersonSymptom> getUstPersonSymptoms() {
		return this.ustPersonSymptoms;
	}

	public void setUstPersonSymptoms(List<UstPersonSymptom> ustPersonSymptoms) {
		this.ustPersonSymptoms = ustPersonSymptoms;
	}

	public UstPersonSymptom addUstPersonSymptom(UstPersonSymptom ustPersonSymptom) {
		getUstPersonSymptoms().add(ustPersonSymptom);
		ustPersonSymptom.setSymptomquestion(this);

		return ustPersonSymptom;
	}

	public UstPersonSymptom removeUstPersonSymptom(UstPersonSymptom ustPersonSymptom) {
		getUstPersonSymptoms().remove(ustPersonSymptom);
		ustPersonSymptom.setSymptomquestion(null);

		return ustPersonSymptom;
	}

}