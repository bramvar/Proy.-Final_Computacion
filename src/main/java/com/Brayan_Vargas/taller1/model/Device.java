package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEVICE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICE_DEVID_GENERATOR", sequenceName="DEVICE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICE_DEVID_GENERATOR")
	@Column(name="DEV_ID")
	private long devId;

	@Column(name="DEV_DESCRIPTION")
	private String devDescription;

	@Column(name="DEV_MAC")
	private String devMac;

	//bi-directional many-to-one association to com.example.taller1.model.Devicestatus
	@ManyToOne
	@JoinColumn(name="DEVSTAT_DEVSTAT_ID")
	private Devicestatus devicestatus;

	//bi-directional many-to-one association to com.example.taller1.model.Devicetype
	@ManyToOne
	@JoinColumn(name="DEVTYPE_DEVTYPE_ID")
	private Devicetype devicetype;

	//bi-directional many-to-one association to com.example.taller1.model.Institutioncampus
	@ManyToOne
	@JoinColumn(name="INSTCAM_INSTCAM_ID")
	private Institutioncampus institutioncampus;

	//bi-directional many-to-one association to com.example.taller1.model.Posession
	@OneToMany(mappedBy="device")
	private List<Posession> posessions;

	public Device() {
	}

	public long getDevId() {
		return this.devId;
	}

	public void setDevId(long devId) {
		this.devId = devId;
	}

	public String getDevDescription() {
		return this.devDescription;
	}

	public void setDevDescription(String devDescription) {
		this.devDescription = devDescription;
	}

	public String getDevMac() {
		return this.devMac;
	}

	public void setDevMac(String devMac) {
		this.devMac = devMac;
	}

	public Devicestatus getDevicestatus() {
		return this.devicestatus;
	}

	public void setDevicestatus(Devicestatus devicestatus) {
		this.devicestatus = devicestatus;
	}

	public Devicetype getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(Devicetype devicetype) {
		this.devicetype = devicetype;
	}

	public Institutioncampus getInstitutioncampus() {
		return this.institutioncampus;
	}

	public void setInstitutioncampus(Institutioncampus institutioncampus) {
		this.institutioncampus = institutioncampus;
	}

	public List<Posession> getPosessions() {
		return this.posessions;
	}

	public void setPosessions(List<Posession> posessions) {
		this.posessions = posessions;
	}

	public Posession addPosession(Posession posession) {
		getPosessions().add(posession);
		posession.setDevice(this);

		return posession;
	}

	public Posession removePosession(Posession posession) {
		getPosessions().remove(posession);
		posession.setDevice(null);

		return posession;
	}

}