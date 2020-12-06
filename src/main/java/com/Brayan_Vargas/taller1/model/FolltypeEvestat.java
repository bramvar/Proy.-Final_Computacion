package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the FOLLTYPE_EVESTAT database table.
 *
 */
@Entity
@Table(name = "FOLLTYPE_EVESTAT")
@NamedQuery(name = "com.example.taller1.model.FolltypeEvestat.findAll", query = "SELECT f FROM FolltypeEvestat f")
public class FolltypeEvestat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolltypeEvestatPK id;

	@Column(name = "DISPLAY_ONCE")
	private String displayOnce;

	// bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@ManyToOne
	@JoinColumn(name = "EVESTAT_EVESTAT_ID", insertable = false, updatable = false)
	private Eventstatus eventstatus;

	// bi-directional many-to-one association to com.example.taller1.model.Followuptype
	@ManyToOne
	@JoinColumn(name = "FOLTYPE_FOLLOWUP_ID", insertable = false, updatable = false)
	private Followuptype followuptype;

	public FolltypeEvestat() {
	}

	public String getDisplayOnce() {
		return this.displayOnce;
	}

	public Eventstatus getEventstatus() {
		return this.eventstatus;
	}

	public Followuptype getFollowuptype() {
		return this.followuptype;
	}

	public FolltypeEvestatPK getId() {
		return this.id;
	}

	public void setDisplayOnce(String displayOnce) {
		this.displayOnce = displayOnce;
	}

	public void setEventstatus(Eventstatus eventstatus) {
		this.eventstatus = eventstatus;
	}

	public void setFollowuptype(Followuptype followuptype) {
		this.followuptype = followuptype;
	}

	public void setId(FolltypeEvestatPK id) {
		this.id = id;
	}

}