package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EPIDEMEVENT database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Epidemevent.findAll", query="SELECT e FROM Epidemevent e")
public class Epidemevent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EPIDEMEVENT_EPIEVEID_GENERATOR", sequenceName="EPIDEMEVENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EPIDEMEVENT_EPIEVEID_GENERATOR")
	@Column(name="EPIEVE_ID")
	private long epieveId;

	@Column(name="EPIEVE_DESCRIPTION")
	private String epieveDescription;

	@Column(name="EPIEVE_ICD")
	private String epieveIcd;

	@Column(name="EPIEVE_NAME")
	private String epieveName;

	@Column(name="EPIEVE_QUARANTINETIME")
	private BigDecimal epieveQuarantinetime;

	@Column(name="EPIEVE_VULNERABILTYHEADER")
	private String epieveVulnerabiltyheader;

	//bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@OneToMany(mappedBy="epidemevent")
	private List<Eventstatus> eventstatuses;

	//bi-directional many-to-one association to com.example.taller1.model.Nexuspoll
	@OneToMany(mappedBy="epidemevent")
	private List<Nexuspoll> nexuspolls;

	//bi-directional many-to-one association to com.example.taller1.model.Symptompoll
	@OneToMany(mappedBy="epidemevent")
	private List<Symptompoll> symptompolls;

	//bi-directional many-to-one association to com.example.taller1.model.Vulnerabilitypoll
	@OneToMany(mappedBy="epidemevent")
	private List<Vulnerabilitypoll> vulnerabilitypolls;

	public Epidemevent() {
	}

	public long getEpieveId() {
		return this.epieveId;
	}

	public void setEpieveId(long epieveId) {
		this.epieveId = epieveId;
	}

	public String getEpieveDescription() {
		return this.epieveDescription;
	}

	public void setEpieveDescription(String epieveDescription) {
		this.epieveDescription = epieveDescription;
	}

	public String getEpieveIcd() {
		return this.epieveIcd;
	}

	public void setEpieveIcd(String epieveIcd) {
		this.epieveIcd = epieveIcd;
	}

	public String getEpieveName() {
		return this.epieveName;
	}

	public void setEpieveName(String epieveName) {
		this.epieveName = epieveName;
	}

	public BigDecimal getEpieveQuarantinetime() {
		return this.epieveQuarantinetime;
	}

	public void setEpieveQuarantinetime(BigDecimal epieveQuarantinetime) {
		this.epieveQuarantinetime = epieveQuarantinetime;
	}

	public String getEpieveVulnerabiltyheader() {
		return this.epieveVulnerabiltyheader;
	}

	public void setEpieveVulnerabiltyheader(String epieveVulnerabiltyheader) {
		this.epieveVulnerabiltyheader = epieveVulnerabiltyheader;
	}

	public List<Eventstatus> getEventstatuses() {
		return this.eventstatuses;
	}

	public void setEventstatuses(List<Eventstatus> eventstatuses) {
		this.eventstatuses = eventstatuses;
	}

	public Eventstatus addEventstatus(Eventstatus eventstatus) {
		getEventstatuses().add(eventstatus);
		eventstatus.setEpidemevent(this);

		return eventstatus;
	}

	public Eventstatus removeEventstatus(Eventstatus eventstatus) {
		getEventstatuses().remove(eventstatus);
		eventstatus.setEpidemevent(null);

		return eventstatus;
	}

	public List<Nexuspoll> getNexuspolls() {
		return this.nexuspolls;
	}

	public void setNexuspolls(List<Nexuspoll> nexuspolls) {
		this.nexuspolls = nexuspolls;
	}

	public Nexuspoll addNexuspoll(Nexuspoll nexuspoll) {
		getNexuspolls().add(nexuspoll);
		nexuspoll.setEpidemevent(this);

		return nexuspoll;
	}

	public Nexuspoll removeNexuspoll(Nexuspoll nexuspoll) {
		getNexuspolls().remove(nexuspoll);
		nexuspoll.setEpidemevent(null);

		return nexuspoll;
	}

	public List<Symptompoll> getSymptompolls() {
		return this.symptompolls;
	}

	public void setSymptompolls(List<Symptompoll> symptompolls) {
		this.symptompolls = symptompolls;
	}

	public Symptompoll addSymptompoll(Symptompoll symptompoll) {
		getSymptompolls().add(symptompoll);
		symptompoll.setEpidemevent(this);

		return symptompoll;
	}

	public Symptompoll removeSymptompoll(Symptompoll symptompoll) {
		getSymptompolls().remove(symptompoll);
		symptompoll.setEpidemevent(null);

		return symptompoll;
	}

	public List<Vulnerabilitypoll> getVulnerabilitypolls() {
		return this.vulnerabilitypolls;
	}

	public void setVulnerabilitypolls(List<Vulnerabilitypoll> vulnerabilitypolls) {
		this.vulnerabilitypolls = vulnerabilitypolls;
	}

	public Vulnerabilitypoll addVulnerabilitypoll(Vulnerabilitypoll vulnerabilitypoll) {
		getVulnerabilitypolls().add(vulnerabilitypoll);
		vulnerabilitypoll.setEpidemevent(this);

		return vulnerabilitypoll;
	}

	public Vulnerabilitypoll removeVulnerabilitypoll(Vulnerabilitypoll vulnerabilitypoll) {
		getVulnerabilitypolls().remove(vulnerabilitypoll);
		vulnerabilitypoll.setEpidemevent(null);

		return vulnerabilitypoll;
	}

}