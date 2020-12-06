package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DOCUMENTTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Documenttype.findAll", query="SELECT d FROM Documenttype d")
public class Documenttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTTYPE_DOCTYPEID_GENERATOR", sequenceName="DOCUMENTTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTTYPE_DOCTYPEID_GENERATOR")
	@Column(name="DOCTYPE_ID")
	private long doctypeId;

	@Column(name="DOCTYPE_ISACTIVE")
	private String doctypeIsactive;

	@Column(name="DOCTYPE_NAME")
	private String doctypeName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Documentstate
	@OneToMany(mappedBy="documenttype")
	private List<Documentstate> documentstates;

	//bi-directional many-to-one association to com.example.taller1.model.Documentt
	@OneToMany(mappedBy="documenttype")
	private List<Documentt> documentts;

	public Documenttype() {
	}

	public long getDoctypeId() {
		return this.doctypeId;
	}

	public void setDoctypeId(long doctypeId) {
		this.doctypeId = doctypeId;
	}

	public String getDoctypeIsactive() {
		return this.doctypeIsactive;
	}

	public void setDoctypeIsactive(String doctypeIsactive) {
		this.doctypeIsactive = doctypeIsactive;
	}

	public String getDoctypeName() {
		return this.doctypeName;
	}

	public void setDoctypeName(String doctypeName) {
		this.doctypeName = doctypeName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public List<Documentstate> getDocumentstates() {
		return this.documentstates;
	}

	public void setDocumentstates(List<Documentstate> documentstates) {
		this.documentstates = documentstates;
	}

	public Documentstate addDocumentstate(Documentstate documentstate) {
		getDocumentstates().add(documentstate);
		documentstate.setDocumenttype(this);

		return documentstate;
	}

	public Documentstate removeDocumentstate(Documentstate documentstate) {
		getDocumentstates().remove(documentstate);
		documentstate.setDocumenttype(null);

		return documentstate;
	}

	public List<Documentt> getDocumentts() {
		return this.documentts;
	}

	public void setDocumentts(List<Documentt> documentts) {
		this.documentts = documentts;
	}

	public Documentt addDocumentt(Documentt documentt) {
		getDocumentts().add(documentt);
		documentt.setDocumenttype(this);

		return documentt;
	}

	public Documentt removeDocumentt(Documentt documentt) {
		getDocumentts().remove(documentt);
		documentt.setDocumenttype(null);

		return documentt;
	}

}