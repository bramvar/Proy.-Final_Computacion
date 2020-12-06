package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the PERSON_ROLE database table.
 *
 */
@Entity
@Table(name = "PERSON_ROLE")
@NamedQuery(name = "com.example.taller1.model.PersonRole.findAll", query = "SELECT p FROM PersonRole p")
public class PersonRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonRolePK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name = "PERS_PERS_ID", insertable = false, updatable = false)
	private Person person;

	// bi-directional many-to-one association to com.example.taller1.model.Rolee
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "ROLE_ROLE_ID", insertable = false, updatable = false)
	private Rolee rolee;

	public PersonRole() {
	}

	public String getDumy() {
		return this.dumy;
	}

	public PersonRolePK getId() {
		return this.id;
	}

	public Person getPerson() {
		return this.person;
	}

	public Rolee getRolee() {
		return this.rolee;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setId(PersonRolePK id) {
		this.id = id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setRolee(Rolee rolee) {
		this.rolee = rolee;
	}

}