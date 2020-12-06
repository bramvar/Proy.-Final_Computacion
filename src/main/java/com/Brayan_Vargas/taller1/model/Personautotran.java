package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERSONAUTOTRAN database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Personautotran.findAll", query="SELECT p FROM Personautotran p")
public class Personautotran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONAUTOTRAN_PERAUTID_GENERATOR", sequenceName="PERSONAUTOTRAN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAUTOTRAN_PERAUTID_GENERATOR")
	@Column(name="PERAUT_ID")
	private long perautId;

	@Temporal(TemporalType.DATE)
	@Column(name="PERAUT_DATE")
	private Date perautDate;

	//bi-directional many-to-one association to com.example.taller1.model.Autotransition
	@ManyToOne
	@JoinColumn(name="AUTOTRAN_AUTOTRAN_ID")
	private Autotransition autotransition;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	//bi-directional many-to-one association to com.example.taller1.model.Queuecreatefence
	@OneToMany(mappedBy="personautotran")
	private List<Queuecreatefence> queuecreatefences;

	//bi-directional many-to-one association to com.example.taller1.model.Queuecreatefencehistory
	@OneToMany(mappedBy="personautotran")
	private List<Queuecreatefencehistory> queuecreatefencehistories;

	//bi-directional many-to-one association to com.example.taller1.model.Queuedisablefence
	@OneToMany(mappedBy="personautotran")
	private List<Queuedisablefence> queuedisablefences;

	//bi-directional many-to-one association to com.example.taller1.model.Queuedisablefencehistory
	@OneToMany(mappedBy="personautotran")
	private List<Queuedisablefencehistory> queuedisablefencehistories;

	public Personautotran() {
	}

	public long getPerautId() {
		return this.perautId;
	}

	public void setPerautId(long perautId) {
		this.perautId = perautId;
	}

	public Date getPerautDate() {
		return this.perautDate;
	}

	public void setPerautDate(Date perautDate) {
		this.perautDate = perautDate;
	}

	public Autotransition getAutotransition() {
		return this.autotransition;
	}

	public void setAutotransition(Autotransition autotransition) {
		this.autotransition = autotransition;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Queuecreatefence> getQueuecreatefences() {
		return this.queuecreatefences;
	}

	public void setQueuecreatefences(List<Queuecreatefence> queuecreatefences) {
		this.queuecreatefences = queuecreatefences;
	}

	public Queuecreatefence addQueuecreatefence(Queuecreatefence queuecreatefence) {
		getQueuecreatefences().add(queuecreatefence);
		queuecreatefence.setPersonautotran(this);

		return queuecreatefence;
	}

	public Queuecreatefence removeQueuecreatefence(Queuecreatefence queuecreatefence) {
		getQueuecreatefences().remove(queuecreatefence);
		queuecreatefence.setPersonautotran(null);

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
		queuecreatefencehistory.setPersonautotran(this);

		return queuecreatefencehistory;
	}

	public Queuecreatefencehistory removeQueuecreatefencehistory(Queuecreatefencehistory queuecreatefencehistory) {
		getQueuecreatefencehistories().remove(queuecreatefencehistory);
		queuecreatefencehistory.setPersonautotran(null);

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
		queuedisablefence.setPersonautotran(this);

		return queuedisablefence;
	}

	public Queuedisablefence removeQueuedisablefence(Queuedisablefence queuedisablefence) {
		getQueuedisablefences().remove(queuedisablefence);
		queuedisablefence.setPersonautotran(null);

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
		queuedisablefencehistory.setPersonautotran(this);

		return queuedisablefencehistory;
	}

	public Queuedisablefencehistory removeQueuedisablefencehistory(Queuedisablefencehistory queuedisablefencehistory) {
		getQueuedisablefencehistories().remove(queuedisablefencehistory);
		queuedisablefencehistory.setPersonautotran(null);

		return queuedisablefencehistory;
	}

}