package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the USV_EPIDEMEVENT database table.
 * 
 */
@Entity
@Table(name="USV_EPIDEMEVENT")
@NamedQuery(name="com.example.taller1.model.UsvEpidemevent.findAll", query="SELECT u FROM UsvEpidemevent u")
public class UsvEpidemevent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USV_EPIDEMEVENT_EPIEVEID_GENERATOR", sequenceName="USV_EPIDEMEVENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USV_EPIDEMEVENT_EPIEVEID_GENERATOR")
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

	public UsvEpidemevent() {
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

}