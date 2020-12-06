package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DOCSTATEINSTANCE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Docstateinstance.findAll", query="SELECT d FROM Docstateinstance d")
public class Docstateinstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCSTATEINSTANCE_DOCSTATINSID_GENERATOR", sequenceName="DOCSTATEINSTANCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCSTATEINSTANCE_DOCSTATINSID_GENERATOR")
	@Column(name="DOCSTATINS_ID")
	private long docstatinsId;

	@Temporal(TemporalType.DATE)
	@Column(name="DOCSTATINS_ENDDATE")
	private Date docstatinsEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="DOCSTATINS_STARTDATE")
	private Date docstatinsStartdate;

	//bi-directional many-to-one association to com.example.taller1.model.Documentstate
	@ManyToOne
	@JoinColumn(name="DOCSTAT_DOCSTAT_ID")
	private Documentstate documentstate;

	//bi-directional many-to-one association to com.example.taller1.model.Documentt
	@ManyToOne
	@JoinColumn(name="DOC_DOC_ID")
	private Documentt documentt;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public Docstateinstance() {
	}

	public long getDocstatinsId() {
		return this.docstatinsId;
	}

	public void setDocstatinsId(long docstatinsId) {
		this.docstatinsId = docstatinsId;
	}

	public Date getDocstatinsEnddate() {
		return this.docstatinsEnddate;
	}

	public void setDocstatinsEnddate(Date docstatinsEnddate) {
		this.docstatinsEnddate = docstatinsEnddate;
	}

	public Date getDocstatinsStartdate() {
		return this.docstatinsStartdate;
	}

	public void setDocstatinsStartdate(Date docstatinsStartdate) {
		this.docstatinsStartdate = docstatinsStartdate;
	}

	public Documentstate getDocumentstate() {
		return this.documentstate;
	}

	public void setDocumentstate(Documentstate documentstate) {
		this.documentstate = documentstate;
	}

	public Documentt getDocumentt() {
		return this.documentt;
	}

	public void setDocumentt(Documentt documentt) {
		this.documentt = documentt;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}