package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EPIDEMSTATUSTRANSITION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Epidemstatustransition.findAll", query="SELECT e FROM Epidemstatustransition e")
public class Epidemstatustransition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EPIDEMSTATUSTRANSITION_EPISTATTRANID_GENERATOR", sequenceName="EPIDEMSTATUSTRANSITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EPIDEMSTATUSTRANSITION_EPISTATTRANID_GENERATOR")
	@Column(name="EPISTATTRAN_ID")
	private long epistattranId;

	@Column(name="EPISTATTRAN_ISACTIVE")
	private String epistattranIsactive;

	@Column(name="EPISTATTRAN_NAME")
	private String epistattranName;

	//bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@ManyToOne
	@JoinColumn(name="EVESTAT_EVESTAT_IDDESTINATION")
	private Eventstatus eventstatus1;

	//bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@ManyToOne
	@JoinColumn(name="EVESTAT_EVESTAT_IDORIGIN")
	private Eventstatus eventstatus2;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	//bi-directional many-to-one association to com.example.taller1.model.Permissionn
	@ManyToOne
	@JoinColumn(name="PERM_PERM_ID")
	private Permissionn permissionn;

	public Epidemstatustransition() {
	}

	public long getEpistattranId() {
		return this.epistattranId;
	}

	public void setEpistattranId(long epistattranId) {
		this.epistattranId = epistattranId;
	}

	public String getEpistattranIsactive() {
		return this.epistattranIsactive;
	}

	public void setEpistattranIsactive(String epistattranIsactive) {
		this.epistattranIsactive = epistattranIsactive;
	}

	public String getEpistattranName() {
		return this.epistattranName;
	}

	public void setEpistattranName(String epistattranName) {
		this.epistattranName = epistattranName;
	}

	public Eventstatus getEventstatus1() {
		return this.eventstatus1;
	}

	public void setEventstatus1(Eventstatus eventstatus1) {
		this.eventstatus1 = eventstatus1;
	}

	public Eventstatus getEventstatus2() {
		return this.eventstatus2;
	}

	public void setEventstatus2(Eventstatus eventstatus2) {
		this.eventstatus2 = eventstatus2;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Permissionn getPermissionn() {
		return this.permissionn;
	}

	public void setPermissionn(Permissionn permissionn) {
		this.permissionn = permissionn;
	}

}