package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PERM_FOLLTYPE database table.
 *
 */
@Entity
@Table(name = "PERM_FOLLTYPE")
@NamedQuery(name = "com.example.taller1.model.PermFolltype.findAll", query = "SELECT p FROM PermFolltype p")
public class PermFolltype implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermFolltypePK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Followuptype
	@ManyToOne
	@JoinColumn(name = "FOLTYPE_FOLLOWUP_ID", insertable = false, updatable = false)
	private Followuptype followuptype;

	// bi-directional many-to-one association to com.example.taller1.model.Permissionn
	@ManyToOne
	@JoinColumn(name = "PERM_PERM_ID", insertable = false, updatable = false)
	private Permissionn permissionn;

	public PermFolltype() {
	}

	public String getDumy() {
		return this.dumy;
	}

	public Followuptype getFollowuptype() {
		return this.followuptype;
	}

	public PermFolltypePK getId() {
		return this.id;
	}

	public Permissionn getPermissionn() {
		return this.permissionn;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setFollowuptype(Followuptype followuptype) {
		this.followuptype = followuptype;
	}

	public void setId(PermFolltypePK id) {
		this.id = id;
	}

	public void setPermissionn(Permissionn permissionn) {
		this.permissionn = permissionn;
	}

}