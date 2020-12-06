package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the UST_PERSON_STATUS database table.
 * 
 */
@Entity
@Table(name="UST_PERSON_STATUS")
@NamedQuery(name="com.example.taller1.model.UstPersonStatus.findAll", query="SELECT u FROM UstPersonStatus u")
public class UstPersonStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_PERSON_STATUS_PERSTAID_GENERATOR", sequenceName="UST_PERSON_STATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_PERSON_STATUS_PERSTAID_GENERATOR")
	@Column(name="PERSTA_ID")
	private long perstaId;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Column(name="EVESTAT_EVESTAT_ID")
	private BigDecimal evestatEvestatId;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public UstPersonStatus() {
	}

	public long getPerstaId() {
		return this.perstaId;
	}

	public void setPerstaId(long perstaId) {
		this.perstaId = perstaId;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public BigDecimal getEvestatEvestatId() {
		return this.evestatEvestatId;
	}

	public void setEvestatEvestatId(BigDecimal evestatEvestatId) {
		this.evestatEvestatId = evestatEvestatId;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}