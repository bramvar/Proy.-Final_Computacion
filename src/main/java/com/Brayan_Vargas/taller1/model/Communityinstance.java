package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMMUNITYINSTANCE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Communityinstance.findAll", query="SELECT c FROM Communityinstance c")
public class Communityinstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="COMMUNITYINSTANCE_COMMINSTID_GENERATOR", sequenceName="COMMUNITYINSTANCE_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMUNITYINSTANCE_COMMINSTID_GENERATOR")
	@Column(name="COMMINST_ID")
	private long comminstId;

	@Column(name="COMMINST_DESCRIPTION")
	private String comminstDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="COMMINST_ENDDATEHOUR")
	private Date comminstEnddatehour;

	@Column(name="COMMINST_EXTID")
	private String comminstExtid;

	@Temporal(TemporalType.DATE)
	@Column(name="COMMINST_STARTDATEHOUR")
	private Date comminstStartdatehour;

	//bi-directional many-to-one association to com.example.taller1.model.Attendance
	@OneToMany(mappedBy="communityinstance")
	private List<Attendance> attendances;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspace
	@ManyToOne
	@JoinColumn(name="PHYSPC_PHYSPC_ID")
	private Physicalspace physicalspace;

	public Communityinstance() {
	}

	public long getComminstId() {
		return this.comminstId;
	}

	public void setComminstId(long comminstId) {
		this.comminstId = comminstId;
	}

	public String getComminstDescription() {
		return this.comminstDescription;
	}

	public void setComminstDescription(String comminstDescription) {
		this.comminstDescription = comminstDescription;
	}

	public Date getComminstEnddatehour() {
		return this.comminstEnddatehour;
	}

	public void setComminstEnddatehour(Date comminstEnddatehour) {
		this.comminstEnddatehour = comminstEnddatehour;
	}

	public String getComminstExtid() {
		return this.comminstExtid;
	}

	public void setComminstExtid(String comminstExtid) {
		this.comminstExtid = comminstExtid;
	}

	public Date getComminstStartdatehour() {
		return this.comminstStartdatehour;
	}

	public void setComminstStartdatehour(Date comminstStartdatehour) {
		this.comminstStartdatehour = comminstStartdatehour;
	}

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Attendance addAttendance(Attendance attendance) {
		getAttendances().add(attendance);
		attendance.setCommunityinstance(this);

		return attendance;
	}

	public Attendance removeAttendance(Attendance attendance) {
		getAttendances().remove(attendance);
		attendance.setCommunityinstance(null);

		return attendance;
	}

	public Physicalspace getPhysicalspace() {
		return this.physicalspace;
	}

	public void setPhysicalspace(Physicalspace physicalspace) {
		this.physicalspace = physicalspace;
	}

}