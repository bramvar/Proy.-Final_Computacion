package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEVICETYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Devicetype.findAll", query="SELECT d FROM Devicetype d")
public class Devicetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICETYPE_DEVTYPEID_GENERATOR", sequenceName="DEVICETYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICETYPE_DEVTYPEID_GENERATOR")
	@Column(name="DEVTYPE_ID")
	private long devtypeId;

	@Column(name="DEVTYPE_NAME")
	private String devtypeName;

	//bi-directional many-to-one association to com.example.taller1.model.Device
	@OneToMany(mappedBy="devicetype")
	private List<Device> devices;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	public Devicetype() {
	}

	public long getDevtypeId() {
		return this.devtypeId;
	}

	public void setDevtypeId(long devtypeId) {
		this.devtypeId = devtypeId;
	}

	public String getDevtypeName() {
		return this.devtypeName;
	}

	public void setDevtypeName(String devtypeName) {
		this.devtypeName = devtypeName;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setDevicetype(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setDevicetype(null);

		return device;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}