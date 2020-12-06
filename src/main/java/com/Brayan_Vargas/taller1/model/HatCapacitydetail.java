package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the HAT_CAPACITYDETAIL database table.
 * 
 */
@Entity
@Table(name="HAT_CAPACITYDETAIL")
@NamedQuery(name="com.example.taller1.model.HatCapacitydetail.findAll", query="SELECT h FROM HatCapacitydetail h")
public class HatCapacitydetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HAT_CAPACITYDETAIL_CAPID_GENERATOR", sequenceName="HAT_CAPACITYDETAIL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAT_CAPACITYDETAIL_CAPID_GENERATOR")
	@Column(name="CAP_ID")
	private long capId;

	@Column(name="CAP_CAPACITY")
	private BigDecimal capCapacity;

	@Temporal(TemporalType.DATE)
	@Column(name="CAP_MODDATE")
	private Date capModdate;

	@Column(name="CAP_PERCENT")
	private BigDecimal capPercent;

	//bi-directional many-to-one association to com.example.taller1.model.Institutioncampus
	@ManyToOne
	@JoinColumn(name="INSTCAM_INSTCAM_ID")
	private Institutioncampus institutioncampus;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalspace
	@ManyToOne
	@JoinColumn(name="PHYSPC_PHYSPC_ID")
	private Physicalspace physicalspace;

	public HatCapacitydetail() {
	}

	public long getCapId() {
		return this.capId;
	}

	public void setCapId(long capId) {
		this.capId = capId;
	}

	public BigDecimal getCapCapacity() {
		return this.capCapacity;
	}

	public void setCapCapacity(BigDecimal capCapacity) {
		this.capCapacity = capCapacity;
	}

	public Date getCapModdate() {
		return this.capModdate;
	}

	public void setCapModdate(Date capModdate) {
		this.capModdate = capModdate;
	}

	public BigDecimal getCapPercent() {
		return this.capPercent;
	}

	public void setCapPercent(BigDecimal capPercent) {
		this.capPercent = capPercent;
	}

	public Institutioncampus getInstitutioncampus() {
		return this.institutioncampus;
	}

	public void setInstitutioncampus(Institutioncampus institutioncampus) {
		this.institutioncampus = institutioncampus;
	}

	public Physicalspace getPhysicalspace() {
		return this.physicalspace;
	}

	public void setPhysicalspace(Physicalspace physicalspace) {
		this.physicalspace = physicalspace;
	}

}