package com.Brayan_Vargas.taller1.model;

import com.Brayan_Vargas.taller1.validation.newPhysicalSpaceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * The persistent class for the PHYSICALSPACETYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Physicalspacetype.findAll", query="SELECT p FROM Physicalspacetype p")
public class Physicalspacetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="PHYSICALSPACETYPE_PHYSPCTYPEID_GENERATOR", sequenceName="PHYSICALSPACETYPE_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHYSICALSPACETYPE_PHYSPCTYPEID_GENERATOR")
	@Column(name="PHYSPCTYPE_ID")
	private long physpctypeId;

	@Column(name="PHYSPCTYPE_EXTID")
	private String physpctypeExtid;


	@Column(name="PHYSPCTYPE_IMPLIESCOMM")
	@NotBlank(groups = {newPhysicalSpaceType.class})
	private String physpctypeImpliescomm;


	@Column(name="PHYSPCTYPE_NAME")
	@NotBlank(groups = {newPhysicalSpaceType.class})
	private String physpctypeName;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspace
	@OneToMany(mappedBy="physicalspacetype")
	@JsonIgnore
	private List<Physicalspace> physicalspaces;

	//bi-directional many-to-one association to com.example.taller1.model.Institution

	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	@NotNull(groups = {newPhysicalSpaceType.class})

	private Institution institution;

	public Physicalspacetype() {
	}

	public long getPhyspctypeId() {
		return this.physpctypeId;
	}

	public void setPhyspctypeId(long physpctypeId) {
		this.physpctypeId = physpctypeId;
	}

	public String getPhyspctypeExtid() {
		return this.physpctypeExtid;
	}

	public void setPhyspctypeExtid(String physpctypeExtid) {
		this.physpctypeExtid = physpctypeExtid;
	}

	public String getPhyspctypeImpliescomm() {
		return this.physpctypeImpliescomm;
	}

	public void setPhyspctypeImpliescomm(String physpctypeImpliescomm) {
		this.physpctypeImpliescomm = physpctypeImpliescomm;
	}

	public String getPhyspctypeName() {
		return this.physpctypeName;
	}

	public void setPhyspctypeName(String physpctypeName) {
		this.physpctypeName = physpctypeName;
	}

	public List<Physicalspace> getPhysicalspaces() {
		return this.physicalspaces;
	}

	public void setPhysicalspaces(List<Physicalspace> physicalspaces) {
		this.physicalspaces = physicalspaces;
	}

	public Physicalspace addPhysicalspace(Physicalspace physicalspace) {
		getPhysicalspaces().add(physicalspace);
		physicalspace.setPhysicalspacetype(this);

		return physicalspace;
	}

	public Physicalspace removePhysicalspace(Physicalspace physicalspace) {
		getPhysicalspaces().remove(physicalspace);
		physicalspace.setPhysicalspacetype(null);

		return physicalspace;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}