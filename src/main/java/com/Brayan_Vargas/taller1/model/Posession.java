package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the POSESSION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Posession.findAll", query="SELECT p FROM Posession p")
public class Posession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POSESSION_POSID_GENERATOR", sequenceName="POSESSION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POSESSION_POSID_GENERATOR")
	@Column(name="POS_ID")
	private long posId;

	@Temporal(TemporalType.DATE)
	@Column(name="POS_ENDDATE")
	private Date posEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="POS_STARTDATE")
	private Date posStartdate;

	private String poslendingcode;

	//bi-directional many-to-one association to com.example.taller1.model.Device
	@ManyToOne
	@JoinColumn(name="DEV_DEV_ID")
	private Device device;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	//bi-directional many-to-one association to com.example.taller1.model.Posessiontype
	@ManyToOne
	@JoinColumn(name="POSTYPE_POSTYPE_ID")
	private Posessiontype posessiontype;

	public Posession() {
	}

	public long getPosId() {
		return this.posId;
	}

	public void setPosId(long posId) {
		this.posId = posId;
	}

	public Date getPosEnddate() {
		return this.posEnddate;
	}

	public void setPosEnddate(Date posEnddate) {
		this.posEnddate = posEnddate;
	}

	public Date getPosStartdate() {
		return this.posStartdate;
	}

	public void setPosStartdate(Date posStartdate) {
		this.posStartdate = posStartdate;
	}

	public String getPoslendingcode() {
		return this.poslendingcode;
	}

	public void setPoslendingcode(String poslendingcode) {
		this.poslendingcode = poslendingcode;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Posessiontype getPosessiontype() {
		return this.posessiontype;
	}

	public void setPosessiontype(Posessiontype posessiontype) {
		this.posessiontype = posessiontype;
	}

}