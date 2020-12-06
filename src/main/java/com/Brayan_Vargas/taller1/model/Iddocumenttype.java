package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the IDDOCUMENTTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Iddocumenttype.findAll", query="SELECT i FROM Iddocumenttype i")
public class Iddocumenttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IDDOCUMENTTYPE_IDDOCTYPEID_GENERATOR", sequenceName="IDDOCUMENTTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDDOCUMENTTYPE_IDDOCTYPEID_GENERATOR")
	@Column(name="IDDOCTYPE_ID")
	private long iddoctypeId;

	@Column(name="IDDOCTYPE_NAME")
	private String iddoctypeName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@OneToMany(mappedBy="iddocumenttype")
	private List<Person> persons;

	public Iddocumenttype() {
	}

	public long getIddoctypeId() {
		return this.iddoctypeId;
	}

	public void setIddoctypeId(long iddoctypeId) {
		this.iddoctypeId = iddoctypeId;
	}

	public String getIddoctypeName() {
		return this.iddoctypeName;
	}

	public void setIddoctypeName(String iddoctypeName) {
		this.iddoctypeName = iddoctypeName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setIddocumenttype(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setIddocumenttype(null);

		return person;
	}

}