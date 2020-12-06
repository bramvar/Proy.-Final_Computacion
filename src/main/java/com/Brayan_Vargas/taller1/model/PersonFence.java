package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PERSON_FENCE database table.
 *
 */
@Entity
@Table(name = "PERSON_FENCE")
@NamedQuery(name = "com.example.taller1.model.PersonFence.findAll", query = "SELECT p FROM PersonFence p")
public class PersonFence implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonFencePK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@ManyToOne
	@JoinColumn(name = "CONTFEN_CONTFEN_ID", insertable = false, updatable = false)
	private Contactfence contactfence;

	// bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name = "PERS_PERS_ID", insertable = false, updatable = false)
	private Person person;

	public PersonFence() {
	}

	public Contactfence getContactfence() {
		return this.contactfence;
	}

	public String getDumy() {
		return this.dumy;
	}

	public PersonFencePK getId() {
		return this.id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setContactfence(Contactfence contactfence) {
		this.contactfence = contactfence;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setId(PersonFencePK id) {
		this.id = id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}