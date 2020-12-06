package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ROLEE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Rolee.findAll", query="SELECT r FROM Rolee r")
public class Rolee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLEE_ROLEID_GENERATOR", sequenceName="ROLEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLEE_ROLEID_GENERATOR")
	@Column(name="ROLE_ID")
	private long roleId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;

	@Column(name="ROLE_NAME")
	private String roleName;

	//bi-directional many-to-one association to com.example.taller1.model.Followupinterested
	@OneToMany(mappedBy="rolee")
	private List<Followupinterested> followupinteresteds;

	//bi-directional many-to-one association to com.example.taller1.model.PersonRole
	@OneToMany(mappedBy="rolee")
	private List<PersonRole> personRoles;

	//bi-directional many-to-one association to com.example.taller1.model.RolePermission
	@OneToMany(mappedBy="rolee")
	private List<RolePermission> rolePermissions;

	public Rolee() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Followupinterested> getFollowupinteresteds() {
		return this.followupinteresteds;
	}

	public void setFollowupinteresteds(List<Followupinterested> followupinteresteds) {
		this.followupinteresteds = followupinteresteds;
	}

	public Followupinterested addFollowupinterested(Followupinterested followupinterested) {
		getFollowupinteresteds().add(followupinterested);
		followupinterested.setRolee(this);

		return followupinterested;
	}

	public Followupinterested removeFollowupinterested(Followupinterested followupinterested) {
		getFollowupinteresteds().remove(followupinterested);
		followupinterested.setRolee(null);

		return followupinterested;
	}

	public List<PersonRole> getPersonRoles() {
		return this.personRoles;
	}

	public void setPersonRoles(List<PersonRole> personRoles) {
		this.personRoles = personRoles;
	}

	public PersonRole addPersonRole(PersonRole personRole) {
		getPersonRoles().add(personRole);
		personRole.setRolee(this);

		return personRole;
	}

	public PersonRole removePersonRole(PersonRole personRole) {
		getPersonRoles().remove(personRole);
		personRole.setRolee(null);

		return personRole;
	}

	public List<RolePermission> getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public RolePermission addRolePermission(RolePermission rolePermission) {
		getRolePermissions().add(rolePermission);
		rolePermission.setRolee(this);

		return rolePermission;
	}

	public RolePermission removeRolePermission(RolePermission rolePermission) {
		getRolePermissions().remove(rolePermission);
		rolePermission.setRolee(null);

		return rolePermission;
	}

}