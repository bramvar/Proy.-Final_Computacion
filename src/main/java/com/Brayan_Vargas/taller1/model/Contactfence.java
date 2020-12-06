package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CONTACTFENCE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Contactfence.findAll", query="SELECT c FROM Contactfence c")
public class Contactfence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACTFENCE_CONTFENID_GENERATOR", sequenceName="CONTACTFENCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACTFENCE_CONTFENID_GENERATOR")
	@Column(name="CONTFEN_ID")
	private long contfenId;

	@Temporal(TemporalType.DATE)
	@Column(name="CONTFEN_CREATIONDATE")
	private Date contfenCreationdate;

	@Temporal(TemporalType.DATE)
	@Column(name="CONTFEN_DISABLEDATE")
	private Date contfenDisabledate;

	@Column(name="CONTFEN_ISACTIVE")
	private String contfenIsactive;

	@Column(name="CONTFEN_TYPE")
	private String contfenType;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@ManyToOne
	@JoinColumn(name="CONTFEN_CONTFEN_IDPARENT")
	private Contactfence contactfence;

	//bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@OneToMany(mappedBy="contactfence")
	private List<Contactfence> contactfences;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	//bi-directional many-to-one association to com.example.taller1.model.PersonFence
	@OneToMany(mappedBy="contactfence")
	private List<PersonFence> personFences;

	//bi-directional many-to-one association to com.example.taller1.model.Queuecreatefence
	@OneToMany(mappedBy="contactfence")
	private List<Queuecreatefence> queuecreatefences;

	//bi-directional many-to-one association to com.example.taller1.model.Queuecreatefencehistory
	@OneToMany(mappedBy="contactfence")
	private List<Queuecreatefencehistory> queuecreatefencehistories;

	//bi-directional many-to-one association to com.example.taller1.model.Queuedisablefence
	@OneToMany(mappedBy="contactfence")
	private List<Queuedisablefence> queuedisablefences;

	//bi-directional many-to-one association to com.example.taller1.model.Queuedisablefencehistory
	@OneToMany(mappedBy="contactfence")
	private List<Queuedisablefencehistory> queuedisablefencehistories;

	public Contactfence() {
	}

	public long getContfenId() {
		return this.contfenId;
	}

	public void setContfenId(long contfenId) {
		this.contfenId = contfenId;
	}

	public Date getContfenCreationdate() {
		return this.contfenCreationdate;
	}

	public void setContfenCreationdate(Date contfenCreationdate) {
		this.contfenCreationdate = contfenCreationdate;
	}

	public Date getContfenDisabledate() {
		return this.contfenDisabledate;
	}

	public void setContfenDisabledate(Date contfenDisabledate) {
		this.contfenDisabledate = contfenDisabledate;
	}

	public String getContfenIsactive() {
		return this.contfenIsactive;
	}

	public void setContfenIsactive(String contfenIsactive) {
		this.contfenIsactive = contfenIsactive;
	}

	public String getContfenType() {
		return this.contfenType;
	}

	public void setContfenType(String contfenType) {
		this.contfenType = contfenType;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Contactfence getContactfence() {
		return this.contactfence;
	}

	public void setContactfence(Contactfence contactfence) {
		this.contactfence = contactfence;
	}

	public List<Contactfence> getContactfences() {
		return this.contactfences;
	}

	public void setContactfences(List<Contactfence> contactfences) {
		this.contactfences = contactfences;
	}

	public Contactfence addContactfence(Contactfence contactfence) {
		getContactfences().add(contactfence);
		contactfence.setContactfence(this);

		return contactfence;
	}

	public Contactfence removeContactfence(Contactfence contactfence) {
		getContactfences().remove(contactfence);
		contactfence.setContactfence(null);

		return contactfence;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<PersonFence> getPersonFences() {
		return this.personFences;
	}

	public void setPersonFences(List<PersonFence> personFences) {
		this.personFences = personFences;
	}

	public PersonFence addPersonFence(PersonFence personFence) {
		getPersonFences().add(personFence);
		personFence.setContactfence(this);

		return personFence;
	}

	public PersonFence removePersonFence(PersonFence personFence) {
		getPersonFences().remove(personFence);
		personFence.setContactfence(null);

		return personFence;
	}

	public List<Queuecreatefence> getQueuecreatefences() {
		return this.queuecreatefences;
	}

	public void setQueuecreatefences(List<Queuecreatefence> queuecreatefences) {
		this.queuecreatefences = queuecreatefences;
	}

	public Queuecreatefence addQueuecreatefence(Queuecreatefence queuecreatefence) {
		getQueuecreatefences().add(queuecreatefence);
		queuecreatefence.setContactfence(this);

		return queuecreatefence;
	}

	public Queuecreatefence removeQueuecreatefence(Queuecreatefence queuecreatefence) {
		getQueuecreatefences().remove(queuecreatefence);
		queuecreatefence.setContactfence(null);

		return queuecreatefence;
	}

	public List<Queuecreatefencehistory> getQueuecreatefencehistories() {
		return this.queuecreatefencehistories;
	}

	public void setQueuecreatefencehistories(List<Queuecreatefencehistory> queuecreatefencehistories) {
		this.queuecreatefencehistories = queuecreatefencehistories;
	}

	public Queuecreatefencehistory addQueuecreatefencehistory(Queuecreatefencehistory queuecreatefencehistory) {
		getQueuecreatefencehistories().add(queuecreatefencehistory);
		queuecreatefencehistory.setContactfence(this);

		return queuecreatefencehistory;
	}

	public Queuecreatefencehistory removeQueuecreatefencehistory(Queuecreatefencehistory queuecreatefencehistory) {
		getQueuecreatefencehistories().remove(queuecreatefencehistory);
		queuecreatefencehistory.setContactfence(null);

		return queuecreatefencehistory;
	}

	public List<Queuedisablefence> getQueuedisablefences() {
		return this.queuedisablefences;
	}

	public void setQueuedisablefences(List<Queuedisablefence> queuedisablefences) {
		this.queuedisablefences = queuedisablefences;
	}

	public Queuedisablefence addQueuedisablefence(Queuedisablefence queuedisablefence) {
		getQueuedisablefences().add(queuedisablefence);
		queuedisablefence.setContactfence(this);

		return queuedisablefence;
	}

	public Queuedisablefence removeQueuedisablefence(Queuedisablefence queuedisablefence) {
		getQueuedisablefences().remove(queuedisablefence);
		queuedisablefence.setContactfence(null);

		return queuedisablefence;
	}

	public List<Queuedisablefencehistory> getQueuedisablefencehistories() {
		return this.queuedisablefencehistories;
	}

	public void setQueuedisablefencehistories(List<Queuedisablefencehistory> queuedisablefencehistories) {
		this.queuedisablefencehistories = queuedisablefencehistories;
	}

	public Queuedisablefencehistory addQueuedisablefencehistory(Queuedisablefencehistory queuedisablefencehistory) {
		getQueuedisablefencehistories().add(queuedisablefencehistory);
		queuedisablefencehistory.setContactfence(this);

		return queuedisablefencehistory;
	}

	public Queuedisablefencehistory removeQueuedisablefencehistory(Queuedisablefencehistory queuedisablefencehistory) {
		getQueuedisablefencehistories().remove(queuedisablefencehistory);
		queuedisablefencehistory.setContactfence(null);

		return queuedisablefencehistory;
	}

}