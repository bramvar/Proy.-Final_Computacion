package com.Brayan_Vargas.taller1.model;

import com.Brayan_Vargas.taller1.validation.newCampus;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the INSTITUTIONCAMPUS database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Institutioncampus.findAll", query="SELECT i FROM Institutioncampus i")
public class Institutioncampus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="INSTITUTIONCAMPUS_INSTCAMID_GENERATOR", sequenceName="INSTITUTIONCAMPUS_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTITUTIONCAMPUS_INSTCAMID_GENERATOR")
	@Column(name="INSTCAM_ID")
	private long instcamId;

	@NotBlank(groups = {newCampus.class})
	@Column(name="INSTCAM_NAME")
	private String instcamName;

	@NotNull(groups = {newCampus.class})
	@Column(name="INSTCAM_OCCUPATION")
	private BigDecimal instcamOccupation;

	//bi-directional many-to-one association to com.example.taller1.model.Device
	@OneToMany(mappedBy="institutioncampus")
	private List<Device> devices;

	//bi-directional many-to-one association to com.example.taller1.model.HatCapacitydetail
	@OneToMany(mappedBy="institutioncampus")
	private List<HatCapacitydetail> hatCapacitydetails;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@NotNull(groups = {newCampus.class})
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspace
	@OneToMany(mappedBy="institutioncampus")
	private List<Physicalspace> physicalspaces;

	//bi-directional many-to-one association to com.example.taller1.model.Visit
	@OneToMany(mappedBy="institutioncampus")
	private List<Visit> visits;

	//bi-directional many-to-one association to com.example.taller1.model.Visitreason
	@OneToMany(mappedBy="institutioncampus")
	private List<Visitreason> visitreasons;

	public Institutioncampus() {
	}

	public long getInstcamId() {
		return this.instcamId;
	}

	public void setInstcamId(long instcamId) {
		this.instcamId = instcamId;
	}

	public String getInstcamName() {
		return this.instcamName;
	}

	public void setInstcamName(String instcamName) {
		this.instcamName = instcamName;
	}

	public BigDecimal getInstcamOccupation() {
		return this.instcamOccupation;
	}

	public void setInstcamOccupation(BigDecimal instcamOccupation) {
		this.instcamOccupation = instcamOccupation;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setInstitutioncampus(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setInstitutioncampus(null);

		return device;
	}

	public List<HatCapacitydetail> getHatCapacitydetails() {
		return this.hatCapacitydetails;
	}

	public void setHatCapacitydetails(List<HatCapacitydetail> hatCapacitydetails) {
		this.hatCapacitydetails = hatCapacitydetails;
	}

	public HatCapacitydetail addHatCapacitydetail(HatCapacitydetail hatCapacitydetail) {
		getHatCapacitydetails().add(hatCapacitydetail);
		hatCapacitydetail.setInstitutioncampus(this);

		return hatCapacitydetail;
	}

	public HatCapacitydetail removeHatCapacitydetail(HatCapacitydetail hatCapacitydetail) {
		getHatCapacitydetails().remove(hatCapacitydetail);
		hatCapacitydetail.setInstitutioncampus(null);

		return hatCapacitydetail;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Physicalspace> getPhysicalspaces() {
		return this.physicalspaces;
	}

	public void setPhysicalspaces(List<Physicalspace> physicalspaces) {
		this.physicalspaces = physicalspaces;
	}

	public Physicalspace addPhysicalspace(Physicalspace physicalspace) {
		getPhysicalspaces().add(physicalspace);
		physicalspace.setInstitutioncampus(this);

		return physicalspace;
	}

	public Physicalspace removePhysicalspace(Physicalspace physicalspace) {
		getPhysicalspaces().remove(physicalspace);
		physicalspace.setInstitutioncampus(null);

		return physicalspace;
	}

	public List<Visit> getVisits() {
		return this.visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public Visit addVisit(Visit visit) {
		getVisits().add(visit);
		visit.setInstitutioncampus(this);

		return visit;
	}

	public Visit removeVisit(Visit visit) {
		getVisits().remove(visit);
		visit.setInstitutioncampus(null);

		return visit;
	}

	public List<Visitreason> getVisitreasons() {
		return this.visitreasons;
	}

	public void setVisitreasons(List<Visitreason> visitreasons) {
		this.visitreasons = visitreasons;
	}

	public Visitreason addVisitreason(Visitreason visitreason) {
		getVisitreasons().add(visitreason);
		visitreason.setInstitutioncampus(this);

		return visitreason;
	}

	public Visitreason removeVisitreason(Visitreason visitreason) {
		getVisitreasons().remove(visitreason);
		visitreason.setInstitutioncampus(null);

		return visitreason;
	}

}