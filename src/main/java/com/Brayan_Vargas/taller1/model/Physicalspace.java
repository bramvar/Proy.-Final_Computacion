package com.Brayan_Vargas.taller1.model;

import com.Brayan_Vargas.taller1.validation.newPhysicalSpace;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PHYSICALSPACE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Physicalspace.findAll", query="SELECT p FROM Physicalspace p")
public class Physicalspace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="PHYSICALSPACE_PHYSPCID_GENERATOR", sequenceName="PHYSICALSPACE_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHYSICALSPACE_PHYSPCID_GENERATOR")
	@Column(name="PHYSPC_ID")
	private long physpcId;

	@Size(min = 5,max = 5,groups = newPhysicalSpace.class)
	@Column(name="PHYSPC_EXTID")
	private String physpcExtid;

	@NotBlank(groups = newPhysicalSpace.class)
	@Column(name="PHYSPC_NAME")
	private String physpcName;

	@Column(name="PHYSPC_OCCUPATION")
	private BigDecimal physpcOccupation;

	//bi-directional many-to-one association to com.example.taller1.model.Communityinstance
	@OneToMany(mappedBy="physicalspace")
	private List<Communityinstance> communityinstances;

	//bi-directional many-to-one association to com.example.taller1.model.HatCapacitydetail
	@OneToMany(mappedBy="physicalspace")
	private List<HatCapacitydetail> hatCapacitydetails;

	//bi-directional many-to-one association to com.example.taller1.model.Institutioncampus
	@NotNull(groups = newPhysicalSpace.class)
	@ManyToOne
	@JoinColumn(name="INSTCAM_INSTCAM_ID")
	private Institutioncampus institutioncampus;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspace
	@ManyToOne
	@JoinColumn(name="PHYSPC_PHYSPC_IDPARENT")
	private Physicalspace physicalspace;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspace
	@OneToMany(mappedBy="physicalspace")
	private List<Physicalspace> physicalspaces;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspacetype
	@NotNull(groups = newPhysicalSpace.class)
	@ManyToOne
	@JoinColumn(name="PHYSPCTYPE_PHYSPCTYPE_ID")
	private Physicalspacetype physicalspacetype;

	public Physicalspace() {
	}

	public long getPhyspcId() {
		return this.physpcId;
	}

	public void setPhyspcId(long physpcId) {
		this.physpcId = physpcId;
	}

	public String getPhyspcExtid() {
		return this.physpcExtid;
	}

	public void setPhyspcExtid(String physpcExtid) {
		this.physpcExtid = physpcExtid;
	}

	public String getPhyspcName() {
		return this.physpcName;
	}

	public void setPhyspcName(String physpcName) {
		this.physpcName = physpcName;
	}

	public BigDecimal getPhyspcOccupation() {
		return this.physpcOccupation;
	}

	public void setPhyspcOccupation(BigDecimal physpcOccupation) {
		this.physpcOccupation = physpcOccupation;
	}

	public List<Communityinstance> getCommunityinstances() {
		return this.communityinstances;
	}

	public void setCommunityinstances(List<Communityinstance> communityinstances) {
		this.communityinstances = communityinstances;
	}

	public Communityinstance addCommunityinstance(Communityinstance communityinstance) {
		getCommunityinstances().add(communityinstance);
		communityinstance.setPhysicalspace(this);

		return communityinstance;
	}

	public Communityinstance removeCommunityinstance(Communityinstance communityinstance) {
		getCommunityinstances().remove(communityinstance);
		communityinstance.setPhysicalspace(null);

		return communityinstance;
	}

	public List<HatCapacitydetail> getHatCapacitydetails() {
		return this.hatCapacitydetails;
	}

	public void setHatCapacitydetails(List<HatCapacitydetail> hatCapacitydetails) {
		this.hatCapacitydetails = hatCapacitydetails;
	}

	public HatCapacitydetail addHatCapacitydetail(HatCapacitydetail hatCapacitydetail) {
		getHatCapacitydetails().add(hatCapacitydetail);
		hatCapacitydetail.setPhysicalspace(this);

		return hatCapacitydetail;
	}

	public HatCapacitydetail removeHatCapacitydetail(HatCapacitydetail hatCapacitydetail) {
		getHatCapacitydetails().remove(hatCapacitydetail);
		hatCapacitydetail.setPhysicalspace(null);

		return hatCapacitydetail;
	}

	public Institutioncampus getInstitutioncampus() {
		return this.institutioncampus;
	}

	public void setInstitutioncampus(Institutioncampus institutioncampus) {
		this.institutioncampus = institutioncampus;
	}

	public Physicalspace getPhysicalspace() {
		return this.physicalspace;
	}

	public void setPhysicalspace(Physicalspace physicalspace) {
		this.physicalspace = physicalspace;
	}

	public List<Physicalspace> getPhysicalspaces() {
		return this.physicalspaces;
	}

	public void setPhysicalspaces(List<Physicalspace> physicalspaces) {
		this.physicalspaces = physicalspaces;
	}

	public Physicalspace addPhysicalspace(Physicalspace physicalspace) {
		getPhysicalspaces().add(physicalspace);
		physicalspace.setPhysicalspace(this);

		return physicalspace;
	}

	public Physicalspace removePhysicalspace(Physicalspace physicalspace) {
		getPhysicalspaces().remove(physicalspace);
		physicalspace.setPhysicalspace(null);

		return physicalspace;
	}

	public Physicalspacetype getPhysicalspacetype() {
		return this.physicalspacetype;
	}

	public void setPhysicalspacetype(Physicalspacetype physicalspacetype) {
		this.physicalspacetype = physicalspacetype;
	}

}