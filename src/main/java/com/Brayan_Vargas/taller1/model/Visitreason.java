package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VISITREASON database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Visitreason.findAll", query="SELECT v FROM Visitreason v")
public class Visitreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VISITREASON_VISREAID_GENERATOR", sequenceName="VISITREASON_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VISITREASON_VISREAID_GENERATOR")
	@Column(name="VISREA_ID")
	private long visreaId;

	@Column(name="VISREA_NAME")
	private String visreaName;

	//bi-directional many-to-one association to com.example.taller1.model.Institutioncampus
	@ManyToOne
	@JoinColumn(name="INSTCAM_INSTCAM_ID")
	private Institutioncampus institutioncampus;

	//bi-directional many-to-one association to com.example.taller1.model.VisitVisitreason
	@OneToMany(mappedBy="visitreason")
	private List<VisitVisitreason> visitVisitreasons;

	public Visitreason() {
	}

	public long getVisreaId() {
		return this.visreaId;
	}

	public void setVisreaId(long visreaId) {
		this.visreaId = visreaId;
	}

	public String getVisreaName() {
		return this.visreaName;
	}

	public void setVisreaName(String visreaName) {
		this.visreaName = visreaName;
	}

	public Institutioncampus getInstitutioncampus() {
		return this.institutioncampus;
	}

	public void setInstitutioncampus(Institutioncampus institutioncampus) {
		this.institutioncampus = institutioncampus;
	}

	public List<VisitVisitreason> getVisitVisitreasons() {
		return this.visitVisitreasons;
	}

	public void setVisitVisitreasons(List<VisitVisitreason> visitVisitreasons) {
		this.visitVisitreasons = visitVisitreasons;
	}

	public VisitVisitreason addVisitVisitreason(VisitVisitreason visitVisitreason) {
		getVisitVisitreasons().add(visitVisitreason);
		visitVisitreason.setVisitreason(this);

		return visitVisitreason;
	}

	public VisitVisitreason removeVisitVisitreason(VisitVisitreason visitVisitreason) {
		getVisitVisitreasons().remove(visitVisitreason);
		visitVisitreason.setVisitreason(null);

		return visitVisitreason;
	}

}