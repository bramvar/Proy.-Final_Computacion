package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PERMISSIONN database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Permissionn.findAll", query="SELECT p FROM Permissionn p")
public class Permissionn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISSIONN_PERMID_GENERATOR", sequenceName="PERMISSIONN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSIONN_PERMID_GENERATOR")
	@Column(name="PERM_ID")
	private long permId;

	@Column(name="PERM_DISPLAYNAME")
	private String permDisplayname;

	@Column(name="PERM_ICONNAME")
	private String permIconname;

	@Column(name="PERM_INDEX")
	private BigDecimal permIndex;

	@Column(name="PERM_ISACTIVE")
	private String permIsactive;

	@Column(name="PERM_MOBDISPLAY")
	private String permMobdisplay;

	@Column(name="PERM_NAME")
	private String permName;

	@Column(name="PERM_TARGETDISPLAY")
	private String permTargetdisplay;

	@Column(name="PERM_TECHNICALDESCRIPTION")
	private String permTechnicaldescription;

	@Column(name="PERM_USERDESCRIPTION")
	private String permUserdescription;

	@Column(name="PERM_WEBPATH")
	private String permWebpath;

	//bi-directional many-to-one association to com.example.taller1.model.Devicestatus
	@OneToMany(mappedBy="permissionn")
	private List<Devicestatus> devicestatuses;

	//bi-directional many-to-one association to com.example.taller1.model.Documentstate
	@OneToMany(mappedBy="permissionn")
	private List<Documentstate> documentstates;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemstatustransition
	@OneToMany(mappedBy="permissionn")
	private List<Epidemstatustransition> epidemstatustransitions;

	//bi-directional many-to-one association to com.example.taller1.model.Permissiontype
	@ManyToOne
	@JoinColumn(name="PERMTYPE_PERMTYPE_ID")
	private Permissiontype permissiontype;

	//bi-directional many-to-one association to com.example.taller1.model.PermFolltype
	@OneToMany(mappedBy="permissionn")
	private List<PermFolltype> permFolltypes;

	//bi-directional many-to-one association to com.example.taller1.model.RolePermission
	@OneToMany(mappedBy="permissionn")
	private List<RolePermission> rolePermissions;

	public Permissionn() {
	}

	public long getPermId() {
		return this.permId;
	}

	public void setPermId(long permId) {
		this.permId = permId;
	}

	public String getPermDisplayname() {
		return this.permDisplayname;
	}

	public void setPermDisplayname(String permDisplayname) {
		this.permDisplayname = permDisplayname;
	}

	public String getPermIconname() {
		return this.permIconname;
	}

	public void setPermIconname(String permIconname) {
		this.permIconname = permIconname;
	}

	public BigDecimal getPermIndex() {
		return this.permIndex;
	}

	public void setPermIndex(BigDecimal permIndex) {
		this.permIndex = permIndex;
	}

	public String getPermIsactive() {
		return this.permIsactive;
	}

	public void setPermIsactive(String permIsactive) {
		this.permIsactive = permIsactive;
	}

	public String getPermMobdisplay() {
		return this.permMobdisplay;
	}

	public void setPermMobdisplay(String permMobdisplay) {
		this.permMobdisplay = permMobdisplay;
	}

	public String getPermName() {
		return this.permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getPermTargetdisplay() {
		return this.permTargetdisplay;
	}

	public void setPermTargetdisplay(String permTargetdisplay) {
		this.permTargetdisplay = permTargetdisplay;
	}

	public String getPermTechnicaldescription() {
		return this.permTechnicaldescription;
	}

	public void setPermTechnicaldescription(String permTechnicaldescription) {
		this.permTechnicaldescription = permTechnicaldescription;
	}

	public String getPermUserdescription() {
		return this.permUserdescription;
	}

	public void setPermUserdescription(String permUserdescription) {
		this.permUserdescription = permUserdescription;
	}

	public String getPermWebpath() {
		return this.permWebpath;
	}

	public void setPermWebpath(String permWebpath) {
		this.permWebpath = permWebpath;
	}

	public List<Devicestatus> getDevicestatuses() {
		return this.devicestatuses;
	}

	public void setDevicestatuses(List<Devicestatus> devicestatuses) {
		this.devicestatuses = devicestatuses;
	}

	public Devicestatus addDevicestatus(Devicestatus devicestatus) {
		getDevicestatuses().add(devicestatus);
		devicestatus.setPermissionn(this);

		return devicestatus;
	}

	public Devicestatus removeDevicestatus(Devicestatus devicestatus) {
		getDevicestatuses().remove(devicestatus);
		devicestatus.setPermissionn(null);

		return devicestatus;
	}

	public List<Documentstate> getDocumentstates() {
		return this.documentstates;
	}

	public void setDocumentstates(List<Documentstate> documentstates) {
		this.documentstates = documentstates;
	}

	public Documentstate addDocumentstate(Documentstate documentstate) {
		getDocumentstates().add(documentstate);
		documentstate.setPermissionn(this);

		return documentstate;
	}

	public Documentstate removeDocumentstate(Documentstate documentstate) {
		getDocumentstates().remove(documentstate);
		documentstate.setPermissionn(null);

		return documentstate;
	}

	public List<Epidemstatustransition> getEpidemstatustransitions() {
		return this.epidemstatustransitions;
	}

	public void setEpidemstatustransitions(List<Epidemstatustransition> epidemstatustransitions) {
		this.epidemstatustransitions = epidemstatustransitions;
	}

	public Epidemstatustransition addEpidemstatustransition(Epidemstatustransition epidemstatustransition) {
		getEpidemstatustransitions().add(epidemstatustransition);
		epidemstatustransition.setPermissionn(this);

		return epidemstatustransition;
	}

	public Epidemstatustransition removeEpidemstatustransition(Epidemstatustransition epidemstatustransition) {
		getEpidemstatustransitions().remove(epidemstatustransition);
		epidemstatustransition.setPermissionn(null);

		return epidemstatustransition;
	}

	public Permissiontype getPermissiontype() {
		return this.permissiontype;
	}

	public void setPermissiontype(Permissiontype permissiontype) {
		this.permissiontype = permissiontype;
	}

	public List<PermFolltype> getPermFolltypes() {
		return this.permFolltypes;
	}

	public void setPermFolltypes(List<PermFolltype> permFolltypes) {
		this.permFolltypes = permFolltypes;
	}

	public PermFolltype addPermFolltype(PermFolltype permFolltype) {
		getPermFolltypes().add(permFolltype);
		permFolltype.setPermissionn(this);

		return permFolltype;
	}

	public PermFolltype removePermFolltype(PermFolltype permFolltype) {
		getPermFolltypes().remove(permFolltype);
		permFolltype.setPermissionn(null);

		return permFolltype;
	}

	public List<RolePermission> getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public RolePermission addRolePermission(RolePermission rolePermission) {
		getRolePermissions().add(rolePermission);
		rolePermission.setPermissionn(this);

		return rolePermission;
	}

	public RolePermission removeRolePermission(RolePermission rolePermission) {
		getRolePermissions().remove(rolePermission);
		rolePermission.setPermissionn(null);

		return rolePermission;
	}

}