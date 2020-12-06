package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ROLE_PERMISSION database table.
 *
 */
@Entity
@Table(name = "ROLE_PERMISSION")
@NamedQuery(name = "com.example.taller1.model.RolePermission.findAll", query = "SELECT r FROM RolePermission r")
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolePermissionPK id;

	private String dumy;

	// bi-directional many-to-one association to com.example.taller1.model.Permissionn
	@ManyToOne
	@JoinColumn(name = "PERM_PERM_ID", insertable = false, updatable = false)
	private Permissionn permissionn;

	// bi-directional many-to-one association to com.example.taller1.model.Rolee
	@ManyToOne
	@JoinColumn(name = "ROLE_ROLE_ID", insertable = false, updatable = false)
	private Rolee rolee;

	public RolePermission() {
	}

	public String getDumy() {
		return this.dumy;
	}

	public RolePermissionPK getId() {
		return this.id;
	}

	public Permissionn getPermissionn() {
		return this.permissionn;
	}

	public Rolee getRolee() {
		return this.rolee;
	}

	public void setDumy(String dumy) {
		this.dumy = dumy;
	}

	public void setId(RolePermissionPK id) {
		this.id = id;
	}

	public void setPermissionn(Permissionn permissionn) {
		this.permissionn = permissionn;
	}

	public void setRolee(Rolee rolee) {
		this.rolee = rolee;
	}

}