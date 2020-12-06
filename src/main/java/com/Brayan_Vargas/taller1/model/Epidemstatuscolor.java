package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EPIDEMSTATUSCOLOR database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Epidemstatuscolor.findAll", query="SELECT e FROM Epidemstatuscolor e")
public class Epidemstatuscolor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EPIDEMSTATUSCOLOR_EPISTATCOLID_GENERATOR", sequenceName="EPIDEMSTATUSCOLOR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EPIDEMSTATUSCOLOR_EPISTATCOLID_GENERATOR")
	@Column(name="EPISTATCOL_ID")
	private long epistatcolId;

	@Column(name="EPISTATCOL_HEXCODE")
	private String epistatcolHexcode;

	@Column(name="EPISTATCOL_NAME")
	private String epistatcolName;

	//bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@OneToMany(mappedBy="epidemstatuscolor")
	private List<Eventstatus> eventstatuses;

	public Epidemstatuscolor() {
	}

	public long getEpistatcolId() {
		return this.epistatcolId;
	}

	public void setEpistatcolId(long epistatcolId) {
		this.epistatcolId = epistatcolId;
	}

	public String getEpistatcolHexcode() {
		return this.epistatcolHexcode;
	}

	public void setEpistatcolHexcode(String epistatcolHexcode) {
		this.epistatcolHexcode = epistatcolHexcode;
	}

	public String getEpistatcolName() {
		return this.epistatcolName;
	}

	public void setEpistatcolName(String epistatcolName) {
		this.epistatcolName = epistatcolName;
	}

	public List<Eventstatus> getEventstatuses() {
		return this.eventstatuses;
	}

	public void setEventstatuses(List<Eventstatus> eventstatuses) {
		this.eventstatuses = eventstatuses;
	}

	public Eventstatus addEventstatus(Eventstatus eventstatus) {
		getEventstatuses().add(eventstatus);
		eventstatus.setEpidemstatuscolor(this);

		return eventstatus;
	}

	public Eventstatus removeEventstatus(Eventstatus eventstatus) {
		getEventstatuses().remove(eventstatus);
		eventstatus.setEpidemstatuscolor(null);

		return eventstatus;
	}

}