package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EVENTSTATUS database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Eventstatus.findAll", query="SELECT e FROM Eventstatus e")
public class Eventstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTSTATUS_EVESTATID_GENERATOR", sequenceName="EVENTSTATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTSTATUS_EVESTATID_GENERATOR")
	@Column(name="EVESTAT_ID")
	private long evestatId;

	@Column(name="EVESTAT_ALLOWSMOBILITY")
	private String evestatAllowsmobility;

	@Column(name="EVESTAT_ISACTIVE")
	private String evestatIsactive;

	@Column(name="EVESTAT_NAME")
	private String evestatName;

	//bi-directional many-to-one association to com.example.taller1.model.Autotransition
	@OneToMany(mappedBy="eventstatus1")
	private List<Autotransition> autotransitions1;

	//bi-directional many-to-one association to com.example.taller1.model.Autotransition
	@OneToMany(mappedBy="eventstatus2")
	private List<Autotransition> autotransitions2;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemstatustransition
	@OneToMany(mappedBy="eventstatus1")
	private List<Epidemstatustransition> epidemstatustransitions1;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemstatustransition
	@OneToMany(mappedBy="eventstatus2")
	private List<Epidemstatustransition> epidemstatustransitions2;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemevent
	@ManyToOne
	@JoinColumn(name="EPIEVE_EPIEVE_ID")
	private Epidemevent epidemevent;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemstatus
	@ManyToOne
	@JoinColumn(name="EPISTAT_EPISTAT_ID")
	private Epidemstatus epidemstatus;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemstatuscolor
	@ManyToOne
	@JoinColumn(name="EPISTATCOL_EPISTATCOL_ID")
	private Epidemstatuscolor epidemstatuscolor;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	//bi-directional many-to-one association to com.example.taller1.model.FolltypeEvestat
	@OneToMany(mappedBy="eventstatus")
	private List<FolltypeEvestat> folltypeEvestats;

	public Eventstatus() {
	}

	public long getEvestatId() {
		return this.evestatId;
	}

	public void setEvestatId(long evestatId) {
		this.evestatId = evestatId;
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

	public List<Autotransition> getAutotransitions1() {
		return this.autotransitions1;
	}

	public void setAutotransitions1(List<Autotransition> autotransitions1) {
		this.autotransitions1 = autotransitions1;
	}

	public Autotransition addAutotransitions1(Autotransition autotransitions1) {
		getAutotransitions1().add(autotransitions1);
		autotransitions1.setEventstatus1(this);

		return autotransitions1;
	}

	public Autotransition removeAutotransitions1(Autotransition autotransitions1) {
		getAutotransitions1().remove(autotransitions1);
		autotransitions1.setEventstatus1(null);

		return autotransitions1;
	}

	public List<Autotransition> getAutotransitions2() {
		return this.autotransitions2;
	}

	public void setAutotransitions2(List<Autotransition> autotransitions2) {
		this.autotransitions2 = autotransitions2;
	}

	public Autotransition addAutotransitions2(Autotransition autotransitions2) {
		getAutotransitions2().add(autotransitions2);
		autotransitions2.setEventstatus2(this);

		return autotransitions2;
	}

	public Autotransition removeAutotransitions2(Autotransition autotransitions2) {
		getAutotransitions2().remove(autotransitions2);
		autotransitions2.setEventstatus2(null);

		return autotransitions2;
	}

	public List<Epidemstatustransition> getEpidemstatustransitions1() {
		return this.epidemstatustransitions1;
	}

	public void setEpidemstatustransitions1(List<Epidemstatustransition> epidemstatustransitions1) {
		this.epidemstatustransitions1 = epidemstatustransitions1;
	}

	public Epidemstatustransition addEpidemstatustransitions1(Epidemstatustransition epidemstatustransitions1) {
		getEpidemstatustransitions1().add(epidemstatustransitions1);
		epidemstatustransitions1.setEventstatus1(this);

		return epidemstatustransitions1;
	}

	public Epidemstatustransition removeEpidemstatustransitions1(Epidemstatustransition epidemstatustransitions1) {
		getEpidemstatustransitions1().remove(epidemstatustransitions1);
		epidemstatustransitions1.setEventstatus1(null);

		return epidemstatustransitions1;
	}

	public List<Epidemstatustransition> getEpidemstatustransitions2() {
		return this.epidemstatustransitions2;
	}

	public void setEpidemstatustransitions2(List<Epidemstatustransition> epidemstatustransitions2) {
		this.epidemstatustransitions2 = epidemstatustransitions2;
	}

	public Epidemstatustransition addEpidemstatustransitions2(Epidemstatustransition epidemstatustransitions2) {
		getEpidemstatustransitions2().add(epidemstatustransitions2);
		epidemstatustransitions2.setEventstatus2(this);

		return epidemstatustransitions2;
	}

	public Epidemstatustransition removeEpidemstatustransitions2(Epidemstatustransition epidemstatustransitions2) {
		getEpidemstatustransitions2().remove(epidemstatustransitions2);
		epidemstatustransitions2.setEventstatus2(null);

		return epidemstatustransitions2;
	}

	public Epidemevent getEpidemevent() {
		return this.epidemevent;
	}

	public void setEpidemevent(Epidemevent epidemevent) {
		this.epidemevent = epidemevent;
	}

	public Epidemstatus getEpidemstatus() {
		return this.epidemstatus;
	}

	public void setEpidemstatus(Epidemstatus epidemstatus) {
		this.epidemstatus = epidemstatus;
	}

	public Epidemstatuscolor getEpidemstatuscolor() {
		return this.epidemstatuscolor;
	}

	public void setEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor) {
		this.epidemstatuscolor = epidemstatuscolor;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<FolltypeEvestat> getFolltypeEvestats() {
		return this.folltypeEvestats;
	}

	public void setFolltypeEvestats(List<FolltypeEvestat> folltypeEvestats) {
		this.folltypeEvestats = folltypeEvestats;
	}

	public FolltypeEvestat addFolltypeEvestat(FolltypeEvestat folltypeEvestat) {
		getFolltypeEvestats().add(folltypeEvestat);
		folltypeEvestat.setEventstatus(this);

		return folltypeEvestat;
	}

	public FolltypeEvestat removeFolltypeEvestat(FolltypeEvestat folltypeEvestat) {
		getFolltypeEvestats().remove(folltypeEvestat);
		folltypeEvestat.setEventstatus(null);

		return folltypeEvestat;
	}

}