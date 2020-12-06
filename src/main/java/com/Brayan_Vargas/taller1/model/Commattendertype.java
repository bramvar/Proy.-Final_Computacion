package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the COMMATTENDERTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Commattendertype.findAll", query="SELECT c FROM Commattendertype c")
public class Commattendertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMATTENDERTYPE_COMMATTETYPEID_GENERATOR", sequenceName="COMMATTENDERTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMATTENDERTYPE_COMMATTETYPEID_GENERATOR")
	@Column(name="COMMATTETYPE_ID")
	private long commattetypeId;

	@Column(name="COMMATTETYPE_NAME")
	private String commattetypeName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Attendance
	@OneToMany(mappedBy="commattendertype")
	private List<Attendance> attendances;

	public Commattendertype() {
	}

	public long getCommattetypeId() {
		return this.commattetypeId;
	}

	public void setCommattetypeId(long commattetypeId) {
		this.commattetypeId = commattetypeId;
	}

	public String getCommattetypeName() {
		return this.commattetypeName;
	}

	public void setCommattetypeName(String commattetypeName) {
		this.commattetypeName = commattetypeName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Attendance addAttendance(Attendance attendance) {
		getAttendances().add(attendance);
		attendance.setCommattendertype(this);

		return attendance;
	}

	public Attendance removeAttendance(Attendance attendance) {
		getAttendances().remove(attendance);
		attendance.setCommattendertype(null);

		return attendance;
	}

}