package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ATTENDANCE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATTENDANCE_ATTEID_GENERATOR", sequenceName="ATTENDANCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATTENDANCE_ATTEID_GENERATOR")
	@Column(name="ATTE_ID")
	private long atteId;

	@Column(name="ATTE_ATTENDED")
	private String atteAttended;

	@Temporal(TemporalType.DATE)
	@Column(name="ATTE_CHECKINDATEHOUR")
	private Date atteCheckindatehour;

	@Temporal(TemporalType.DATE)
	@Column(name="ATTE_CHECKOUTDATEHOUR")
	private Date atteCheckoutdatehour;

	//bi-directional many-to-one association to com.example.taller1.model.Commattendertype
	@ManyToOne
	@JoinColumn(name="COMMATTETYPE_COMMATTETYPE_ID")
	private Commattendertype commattendertype;

	//bi-directional many-to-one association to com.example.taller1.model.Communityinstance
	@ManyToOne
	@JoinColumn(name="COMMINST_COMMINST_ID")
	private Communityinstance communityinstance;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public Attendance() {
	}

	public long getAtteId() {
		return this.atteId;
	}

	public void setAtteId(long atteId) {
		this.atteId = atteId;
	}

	public String getAtteAttended() {
		return this.atteAttended;
	}

	public void setAtteAttended(String atteAttended) {
		this.atteAttended = atteAttended;
	}

	public Date getAtteCheckindatehour() {
		return this.atteCheckindatehour;
	}

	public void setAtteCheckindatehour(Date atteCheckindatehour) {
		this.atteCheckindatehour = atteCheckindatehour;
	}

	public Date getAtteCheckoutdatehour() {
		return this.atteCheckoutdatehour;
	}

	public void setAtteCheckoutdatehour(Date atteCheckoutdatehour) {
		this.atteCheckoutdatehour = atteCheckoutdatehour;
	}

	public Commattendertype getCommattendertype() {
		return this.commattendertype;
	}

	public void setCommattendertype(Commattendertype commattendertype) {
		this.commattendertype = commattendertype;
	}

	public Communityinstance getCommunityinstance() {
		return this.communityinstance;
	}

	public void setCommunityinstance(Communityinstance communityinstance) {
		this.communityinstance = communityinstance;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}