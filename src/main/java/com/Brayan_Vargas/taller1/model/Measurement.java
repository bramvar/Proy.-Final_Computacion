package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MEASUREMENT database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Measurement.findAll", query="SELECT m FROM Measurement m")
public class Measurement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEASUREMENT_MEASID_GENERATOR", sequenceName="MEASUREMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASUREMENT_MEASID_GENERATOR")
	@Column(name="MEAS_ID")
	private long measId;

	@Column(name="MEAS_DESCRIPTION")
	private String measDescription;

	@Column(name="MEAS_MAXTHRESHOLD")
	private BigDecimal measMaxthreshold;

	@Column(name="MEAS_MINTHRESHOLD")
	private BigDecimal measMinthreshold;

	@Column(name="MEAS_NAME")
	private String measName;

	@Column(name="MEAS_UNIT")
	private String measUnit;

	//bi-directional many-to-one association to com.example.taller1.model.CheckMeasur
	@OneToMany(mappedBy="measurement")
	private List<CheckMeasur> checkMeasurs;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	public Measurement() {
	}

	public long getMeasId() {
		return this.measId;
	}

	public void setMeasId(long measId) {
		this.measId = measId;
	}

	public String getMeasDescription() {
		return this.measDescription;
	}

	public void setMeasDescription(String measDescription) {
		this.measDescription = measDescription;
	}

	public BigDecimal getMeasMaxthreshold() {
		return this.measMaxthreshold;
	}

	public void setMeasMaxthreshold(BigDecimal measMaxthreshold) {
		this.measMaxthreshold = measMaxthreshold;
	}

	public BigDecimal getMeasMinthreshold() {
		return this.measMinthreshold;
	}

	public void setMeasMinthreshold(BigDecimal measMinthreshold) {
		this.measMinthreshold = measMinthreshold;
	}

	public String getMeasName() {
		return this.measName;
	}

	public void setMeasName(String measName) {
		this.measName = measName;
	}

	public String getMeasUnit() {
		return this.measUnit;
	}

	public void setMeasUnit(String measUnit) {
		this.measUnit = measUnit;
	}

	public List<CheckMeasur> getCheckMeasurs() {
		return this.checkMeasurs;
	}

	public void setCheckMeasurs(List<CheckMeasur> checkMeasurs) {
		this.checkMeasurs = checkMeasurs;
	}

	public CheckMeasur addCheckMeasur(CheckMeasur checkMeasur) {
		getCheckMeasurs().add(checkMeasur);
		checkMeasur.setMeasurement(this);

		return checkMeasur;
	}

	public CheckMeasur removeCheckMeasur(CheckMeasur checkMeasur) {
		getCheckMeasurs().remove(checkMeasur);
		checkMeasur.setMeasurement(null);

		return checkMeasur;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}