package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the NEXUSPOLL database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Nexuspoll.findAll", query="SELECT n FROM Nexuspoll n")
public class Nexuspoll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NEXUSPOLL_NEXPOLLID_GENERATOR", sequenceName="NEXUSPOLL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NEXUSPOLL_NEXPOLLID_GENERATOR")
	@Column(name="NEXPOLL_ID")
	private long nexpollId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Temporal(TemporalType.DATE)
	@Column(name="NEXPOLL_ENDDATE")
	private Date nexpollEnddate;

	@Column(name="NEXPOLL_NAME")
	private String nexpollName;

	@Temporal(TemporalType.DATE)
	@Column(name="NEXPOLL_STARTDATE")
	private Date nexpollStartdate;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemevent
	@ManyToOne
	@JoinColumn(name="EPIEVE_EPIEVE_ID")
	private Epidemevent epidemevent;

	//bi-directional many-to-one association to com.example.taller1.model.Nexusquestion
	@OneToMany(mappedBy="nexuspoll")
	private List<Nexusquestion> nexusquestions;

	public Nexuspoll() {
	}

	public long getNexpollId() {
		return this.nexpollId;
	}

	public void setNexpollId(long nexpollId) {
		this.nexpollId = nexpollId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getNexpollEnddate() {
		return this.nexpollEnddate;
	}

	public void setNexpollEnddate(Date nexpollEnddate) {
		this.nexpollEnddate = nexpollEnddate;
	}

	public String getNexpollName() {
		return this.nexpollName;
	}

	public void setNexpollName(String nexpollName) {
		this.nexpollName = nexpollName;
	}

	public Date getNexpollStartdate() {
		return this.nexpollStartdate;
	}

	public void setNexpollStartdate(Date nexpollStartdate) {
		this.nexpollStartdate = nexpollStartdate;
	}

	public Epidemevent getEpidemevent() {
		return this.epidemevent;
	}

	public void setEpidemevent(Epidemevent epidemevent) {
		this.epidemevent = epidemevent;
	}

	public List<Nexusquestion> getNexusquestions() {
		return this.nexusquestions;
	}

	public void setNexusquestions(List<Nexusquestion> nexusquestions) {
		this.nexusquestions = nexusquestions;
	}

	public Nexusquestion addNexusquestion(Nexusquestion nexusquestion) {
		getNexusquestions().add(nexusquestion);
		nexusquestion.setNexuspoll(this);

		return nexusquestion;
	}

	public Nexusquestion removeNexusquestion(Nexusquestion nexusquestion) {
		getNexusquestions().remove(nexusquestion);
		nexusquestion.setNexuspoll(null);

		return nexusquestion;
	}

}