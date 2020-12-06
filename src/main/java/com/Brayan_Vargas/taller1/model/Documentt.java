package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DOCUMENTT database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Documentt.findAll", query="SELECT d FROM Documentt d")
public class Documentt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTT_DOCID_GENERATOR", sequenceName="DOCUMENTT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTT_DOCID_GENERATOR")
	@Column(name="DOC_ID")
	private long docId;

	@Column(name="DOC_ISPOSITIVE")
	private String docIspositive;

	@Column(name="DOC_NAME")
	private String docName;

	@Column(name="DOC_URL")
	private String docUrl;

	//bi-directional many-to-one association to com.example.taller1.model.Docstateinstance
	@OneToMany(mappedBy="documentt")
	private List<Docstateinstance> docstateinstances;

	//bi-directional many-to-one association to com.example.taller1.model.Documenttype
	@ManyToOne
	@JoinColumn(name="DOCTYPE_DOCTYPE_ID")
	private Documenttype documenttype;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public Documentt() {
	}

	public long getDocId() {
		return this.docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public String getDocIspositive() {
		return this.docIspositive;
	}

	public void setDocIspositive(String docIspositive) {
		this.docIspositive = docIspositive;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocUrl() {
		return this.docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public List<Docstateinstance> getDocstateinstances() {
		return this.docstateinstances;
	}

	public void setDocstateinstances(List<Docstateinstance> docstateinstances) {
		this.docstateinstances = docstateinstances;
	}

	public Docstateinstance addDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().add(docstateinstance);
		docstateinstance.setDocumentt(this);

		return docstateinstance;
	}

	public Docstateinstance removeDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().remove(docstateinstance);
		docstateinstance.setDocumentt(null);

		return docstateinstance;
	}

	public Documenttype getDocumenttype() {
		return this.documenttype;
	}

	public void setDocumenttype(Documenttype documenttype) {
		this.documenttype = documenttype;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}