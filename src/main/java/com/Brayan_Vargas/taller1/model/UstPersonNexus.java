package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the UST_PERSON_NEXUS database table.
 * 
 */
@Entity
@Table(name="UST_PERSON_NEXUS")
@NamedQuery(name="com.example.taller1.model.UstPersonNexus.findAll", query="SELECT u FROM UstPersonNexus u")
public class UstPersonNexus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_PERSON_NEXUS_PERSNEXUSID_GENERATOR", sequenceName="UST_PERSON_NEXUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_PERSON_NEXUS_PERSNEXUSID_GENERATOR")
	@Column(name="PERSNEXUS_ID")
	private long persnexusId;

	private String answer;

	@Temporal(TemporalType.DATE)
	private Date answerdate;

	@Temporal(TemporalType.DATE)
	private Date answerexpiration;

	@Temporal(TemporalType.DATE)
	private Date lastdateanswchanged;

	//bi-directional many-to-one association to com.example.taller1.model.Nexusquestion
	@ManyToOne
	@JoinColumn(name="NEXQUES_NEXQUES_ID")
	private Nexusquestion nexusquestion;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public UstPersonNexus() {
	}

	public long getPersnexusId() {
		return this.persnexusId;
	}

	public void setPersnexusId(long persnexusId) {
		this.persnexusId = persnexusId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswerdate() {
		return this.answerdate;
	}

	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}

	public Date getAnswerexpiration() {
		return this.answerexpiration;
	}

	public void setAnswerexpiration(Date answerexpiration) {
		this.answerexpiration = answerexpiration;
	}

	public Date getLastdateanswchanged() {
		return this.lastdateanswchanged;
	}

	public void setLastdateanswchanged(Date lastdateanswchanged) {
		this.lastdateanswchanged = lastdateanswchanged;
	}

	public Nexusquestion getNexusquestion() {
		return this.nexusquestion;
	}

	public void setNexusquestion(Nexusquestion nexusquestion) {
		this.nexusquestion = nexusquestion;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}