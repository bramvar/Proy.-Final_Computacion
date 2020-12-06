package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PERSONRELATIONSHIP database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Personrelationship.findAll", query="SELECT p FROM Personrelationship p")
public class Personrelationship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONRELATIONSHIP_PERSRELID_GENERATOR", sequenceName="PERSONRELATIONSHIP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONRELATIONSHIP_PERSRELID_GENERATOR")
	@Column(name="PERSREL_ID")
	private long persrelId;

	@Column(name="PERSREL_APPROVED")
	private String persrelApproved;

	@Temporal(TemporalType.DATE)
	@Column(name="PERSREL_CREATIONDATE")
	private Date persrelCreationdate;

	@Temporal(TemporalType.DATE)
	@Column(name="PERSREL_FINISHDATE")
	private Date persrelFinishdate;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_IDORIGIN")
	private Person person1;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_IDDESTINATION")
	private Person person2;

	//bi-directional many-to-one association to com.example.taller1.model.Personrelationtype
	@ManyToOne
	@JoinColumn(name="PERSRELTYPE_PERSRELTYPE_ID")
	private Personrelationtype personrelationtype;

	public Personrelationship() {
	}

	public long getPersrelId() {
		return this.persrelId;
	}

	public void setPersrelId(long persrelId) {
		this.persrelId = persrelId;
	}

	public String getPersrelApproved() {
		return this.persrelApproved;
	}

	public void setPersrelApproved(String persrelApproved) {
		this.persrelApproved = persrelApproved;
	}

	public Date getPersrelCreationdate() {
		return this.persrelCreationdate;
	}

	public void setPersrelCreationdate(Date persrelCreationdate) {
		this.persrelCreationdate = persrelCreationdate;
	}

	public Date getPersrelFinishdate() {
		return this.persrelFinishdate;
	}

	public void setPersrelFinishdate(Date persrelFinishdate) {
		this.persrelFinishdate = persrelFinishdate;
	}

	public Person getPerson1() {
		return this.person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return this.person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public Personrelationtype getPersonrelationtype() {
		return this.personrelationtype;
	}

	public void setPersonrelationtype(Personrelationtype personrelationtype) {
		this.personrelationtype = personrelationtype;
	}

}