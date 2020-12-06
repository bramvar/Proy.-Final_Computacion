package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PERSON_VULNER database table.
 *
 */
@Entity
@Table(name = "PERSON_VULNER")
@NamedQuery(name = "com.example.taller1.model.PersonVulner.findAll", query = "SELECT p FROM PersonVulner p")
public class PersonVulner implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonVulnerPK id;

	private String answer;

	@Temporal(TemporalType.DATE)
	private Date answerdate;

	// bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name = "PERS_PERS_ID", insertable = false, updatable = false)
	private Person person;

	// bi-directional many-to-one association to com.example.taller1.model.Vulnerabilityquestion
	@ManyToOne
	@JoinColumn(name = "VULQUES_VULQUES_ID", insertable = false, updatable = false)
	private Vulnerabilityquestion vulnerabilityquestion;

	public PersonVulner() {
	}

	public String getAnswer() {
		return this.answer;
	}

	public Date getAnswerdate() {
		return this.answerdate;
	}

	public PersonVulnerPK getId() {
		return this.id;
	}

	public Person getPerson() {
		return this.person;
	}

	public Vulnerabilityquestion getVulnerabilityquestion() {
		return this.vulnerabilityquestion;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}

	public void setId(PersonVulnerPK id) {
		this.id = id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setVulnerabilityquestion(Vulnerabilityquestion vulnerabilityquestion) {
		this.vulnerabilityquestion = vulnerabilityquestion;
	}

}