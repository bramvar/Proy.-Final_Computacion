package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEVICESTATUS database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Devicestatus.findAll", query="SELECT d FROM Devicestatus d")
public class Devicestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICESTATUS_DEVSTATID_GENERATOR", sequenceName="DEVICESTATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICESTATUS_DEVSTATID_GENERATOR")
	@Column(name="DEVSTAT_ID")
	private long devstatId;

	@Column(name="DEVSTAT_NAME")
	private String devstatName;

	//bi-directional many-to-one association to com.example.taller1.model.Device
	@OneToMany(mappedBy="devicestatus")
	private List<Device> devices;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	//bi-directional many-to-one association to com.example.taller1.model.Permissionn
	@ManyToOne
	@JoinColumn(name="PERM_PERM_ID")
	private Permissionn permissionn;

	public Devicestatus() {
	}

	public long getDevstatId() {
		return this.devstatId;
	}

	public void setDevstatId(long devstatId) {
		this.devstatId = devstatId;
	}

	public String getDevstatName() {
		return this.devstatName;
	}

	public void setDevstatName(String devstatName) {
		this.devstatName = devstatName;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setDevicestatus(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setDevicestatus(null);

		return device;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Permissionn getPermissionn() {
		return this.permissionn;
	}

	public void setPermissionn(Permissionn permissionn) {
		this.permissionn = permissionn;
	}

}