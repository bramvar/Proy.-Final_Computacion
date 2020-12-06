package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PERMISSIONTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Permissiontype.findAll", query="SELECT p FROM Permissiontype p")
public class Permissiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISSIONTYPE_PERMTYPEID_GENERATOR", sequenceName="PERMISSIONTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSIONTYPE_PERMTYPEID_GENERATOR")
	@Column(name="PERMTYPE_ID")
	private long permtypeId;

	@Column(name="PERMTYPE_DISPLAYNAME")
	private String permtypeDisplayname;

	@Column(name="PERMTYPE_ICONNAME")
	private String permtypeIconname;

	@Column(name="PERMTYPE_INDEX")
	private BigDecimal permtypeIndex;

	@Column(name="PERMTYPE_ISACTIVE")
	private String permtypeIsactive;

	@Column(name="PERMTYPE_MOBDISPLAY")
	private String permtypeMobdisplay;

	@Column(name="PERMTYPE_NAME")
	private String permtypeName;

	@Column(name="PERMTYPE_TARGETDISPLAY")
	private String permtypeTargetdisplay;

	@Column(name="PERMTYPE_TYPE")
	private String permtypeType;

	//bi-directional many-to-one association to com.example.taller1.model.Permissionn
	@OneToMany(mappedBy="permissiontype")
	private List<Permissionn> permissionns;

	public Permissiontype() {
	}

	public long getPermtypeId() {
		return this.permtypeId;
	}

	public void setPermtypeId(long permtypeId) {
		this.permtypeId = permtypeId;
	}

	public String getPermtypeDisplayname() {
		return this.permtypeDisplayname;
	}

	public void setPermtypeDisplayname(String permtypeDisplayname) {
		this.permtypeDisplayname = permtypeDisplayname;
	}

	public String getPermtypeIconname() {
		return this.permtypeIconname;
	}

	public void setPermtypeIconname(String permtypeIconname) {
		this.permtypeIconname = permtypeIconname;
	}

	public BigDecimal getPermtypeIndex() {
		return this.permtypeIndex;
	}

	public void setPermtypeIndex(BigDecimal permtypeIndex) {
		this.permtypeIndex = permtypeIndex;
	}

	public String getPermtypeIsactive() {
		return this.permtypeIsactive;
	}

	public void setPermtypeIsactive(String permtypeIsactive) {
		this.permtypeIsactive = permtypeIsactive;
	}

	public String getPermtypeMobdisplay() {
		return this.permtypeMobdisplay;
	}

	public void setPermtypeMobdisplay(String permtypeMobdisplay) {
		this.permtypeMobdisplay = permtypeMobdisplay;
	}

	public String getPermtypeName() {
		return this.permtypeName;
	}

	public void setPermtypeName(String permtypeName) {
		this.permtypeName = permtypeName;
	}

	public String getPermtypeTargetdisplay() {
		return this.permtypeTargetdisplay;
	}

	public void setPermtypeTargetdisplay(String permtypeTargetdisplay) {
		this.permtypeTargetdisplay = permtypeTargetdisplay;
	}

	public String getPermtypeType() {
		return this.permtypeType;
	}

	public void setPermtypeType(String permtypeType) {
		this.permtypeType = permtypeType;
	}

	public List<Permissionn> getPermissionns() {
		return this.permissionns;
	}

	public void setPermissionns(List<Permissionn> permissionns) {
		this.permissionns = permissionns;
	}

	public Permissionn addPermissionn(Permissionn permissionn) {
		getPermissionns().add(permissionn);
		permissionn.setPermissiontype(this);

		return permissionn;
	}

	public Permissionn removePermissionn(Permissionn permissionn) {
		getPermissionns().remove(permissionn);
		permissionn.setPermissiontype(null);

		return permissionn;
	}

}