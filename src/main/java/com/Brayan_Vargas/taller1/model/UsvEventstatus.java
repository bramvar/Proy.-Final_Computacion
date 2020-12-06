package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the USV_EVENTSTATUS database table.
 * 
 */
@Entity
@Table(name="USV_EVENTSTATUS")
@NamedQuery(name="com.example.taller1.model.UsvEventstatus.findAll", query="SELECT u FROM UsvEventstatus u")
public class UsvEventstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USV_EVENTSTATUS_EVESTATID_GENERATOR", sequenceName="USV_EVENTSTATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USV_EVENTSTATUS_EVESTATID_GENERATOR")
	@Column(name="EVESTAT_ID")
	private long evestatId;

	@Column(name="EPIEVE_EPIEVE_ID")
	private BigDecimal epieveEpieveId;

	@Column(name="EPISTAT_EPISTAT_ID")
	private BigDecimal epistatEpistatId;

	@Column(name="EPISTATCOL_EPISTATCOL_ID")
	private BigDecimal epistatcolEpistatcolId;

	@Column(name="EVESTAT_ALLOWSMOBILITY")
	private String evestatAllowsmobility;

	@Column(name="EVESTAT_ISACTIVE")
	private String evestatIsactive;

	@Column(name="EVESTAT_NAME")
	private String evestatName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	public UsvEventstatus() {
	}

	public long getEvestatId() {
		return this.evestatId;
	}

	public void setEvestatId(long evestatId) {
		this.evestatId = evestatId;
	}

	public BigDecimal getEpieveEpieveId() {
		return this.epieveEpieveId;
	}

	public void setEpieveEpieveId(BigDecimal epieveEpieveId) {
		this.epieveEpieveId = epieveEpieveId;
	}

	public BigDecimal getEpistatEpistatId() {
		return this.epistatEpistatId;
	}

	public void setEpistatEpistatId(BigDecimal epistatEpistatId) {
		this.epistatEpistatId = epistatEpistatId;
	}

	public BigDecimal getEpistatcolEpistatcolId() {
		return this.epistatcolEpistatcolId;
	}

	public void setEpistatcolEpistatcolId(BigDecimal epistatcolEpistatcolId) {
		this.epistatcolEpistatcolId = epistatcolEpistatcolId;
	}

	public String getEvestatAllowsmobility() {
		return this.evestatAllowsmobility;
	}

	public void setEvestatAllowsmobility(String evestatAllowsmobility) {
		this.evestatAllowsmobility = evestatAllowsmobility;
	}

	public String getEvestatIsactive() {
		return this.evestatIsactive;
	}

	public void setEvestatIsactive(String evestatIsactive) {
		this.evestatIsactive = evestatIsactive;
	}

	public String getEvestatName() {
		return this.evestatName;
	}

	public void setEvestatName(String evestatName) {
		this.evestatName = evestatName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

}