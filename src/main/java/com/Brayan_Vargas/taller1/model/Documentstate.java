package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DOCUMENTSTATE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Documentstate.findAll", query="SELECT d FROM Documentstate d")
public class Documentstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTSTATE_DOCSTATID_GENERATOR", sequenceName="DOCUMENTSTATE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTSTATE_DOCSTATID_GENERATOR")
	@Column(name="DOCSTAT_ID")
	private long docstatId;

	@Column(name="DOCSTAT_NAME")
	private String docstatName;

	@Column(name="DOCSTAT_UPLOADDOC")
	private String docstatUploaddoc;

	//bi-directional many-to-one association to com.example.taller1.model.Docstateinstance
	@OneToMany(mappedBy="documentstate")
	private List<Docstateinstance> docstateinstances;

	//bi-directional many-to-one association to com.example.taller1.model.Documenttype
	@ManyToOne
	@JoinColumn(name="DOCTYPE_DOCTYPE_ID")
	private Documenttype documenttype;

	//bi-directional many-to-one association to com.example.taller1.model.Permissionn
	@ManyToOne
	@JoinColumn(name="PERM_PERM_ID")
	private Permissionn permissionn;

	public Documentstate() {
	}

	public long getDocstatId() {
		return this.docstatId;
	}

	public void setDocstatId(long docstatId) {
		this.docstatId = docstatId;
	}

	public String getDocstatName() {
		return this.docstatName;
	}

	public void setDocstatName(String docstatName) {
		this.docstatName = docstatName;
	}

	public String getDocstatUploaddoc() {
		return this.docstatUploaddoc;
	}

	public void setDocstatUploaddoc(String docstatUploaddoc) {
		this.docstatUploaddoc = docstatUploaddoc;
	}

	public List<Docstateinstance> getDocstateinstances() {
		return this.docstateinstances;
	}

	public void setDocstateinstances(List<Docstateinstance> docstateinstances) {
		this.docstateinstances = docstateinstances;
	}

	public Docstateinstance addDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().add(docstateinstance);
		docstateinstance.setDocumentstate(this);

		return docstateinstance;
	}

	public Docstateinstance removeDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().remove(docstateinstance);
		docstateinstance.setDocumentstate(null);

		return docstateinstance;
	}

	public Documenttype getDocumenttype() {
		return this.documenttype;
	}

	public void setDocumenttype(Documenttype documenttype) {
		this.documenttype = documenttype;
	}

	public Permissionn getPermissionn() {
		return this.permissionn;
	}

	public void setPermissionn(Permissionn permissionn) {
		this.permissionn = permissionn;
	}

}