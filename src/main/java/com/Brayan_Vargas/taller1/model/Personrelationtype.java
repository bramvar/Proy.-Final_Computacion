package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PERSONRELATIONTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Personrelationtype.findAll", query="SELECT p FROM Personrelationtype p")
public class Personrelationtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONRELATIONTYPE_PERSRELTYPEID_GENERATOR", sequenceName="PERSONRELATIONTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONRELATIONTYPE_PERSRELTYPEID_GENERATOR")
	@Column(name="PERSRELTYPE_ID")
	private long persreltypeId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="PERSRELTYPE_NAME")
	private String persreltypeName;

	//bi-directional many-to-one association to com.example.taller1.model.Personrelationship
	@OneToMany(mappedBy="personrelationtype")
	private List<Personrelationship> personrelationships;

	public Personrelationtype() {
	}

	public long getPersreltypeId() {
		return this.persreltypeId;
	}

	public void setPersreltypeId(long persreltypeId) {
		this.persreltypeId = persreltypeId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getPersreltypeName() {
		return this.persreltypeName;
	}

	public void setPersreltypeName(String persreltypeName) {
		this.persreltypeName = persreltypeName;
	}

	public List<Personrelationship> getPersonrelationships() {
		return this.personrelationships;
	}

	public void setPersonrelationships(List<Personrelationship> personrelationships) {
		this.personrelationships = personrelationships;
	}

	public Personrelationship addPersonrelationship(Personrelationship personrelationship) {
		getPersonrelationships().add(personrelationship);
		personrelationship.setPersonrelationtype(this);

		return personrelationship;
	}

	public Personrelationship removePersonrelationship(Personrelationship personrelationship) {
		getPersonrelationships().remove(personrelationship);
		personrelationship.setPersonrelationtype(null);

		return personrelationship;
	}

}