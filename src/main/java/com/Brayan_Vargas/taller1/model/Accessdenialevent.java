package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ACCESSDENIALEVENT database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Accessdenialevent.findAll", query="SELECT a FROM Accessdenialevent a")
public class Accessdenialevent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCESSDENIALEVENT_ACCDENEVEID_GENERATOR", sequenceName="ACCESSDENIALEVENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCESSDENIALEVENT_ACCDENEVEID_GENERATOR")
	@Column(name="ACCDENEVE_ID")
	private long accdeneveId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACCDENEVE_DATE")
	private Date accdeneveDate;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_IDDENIED")
	private Person person1;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_IDCREATOR")
	private Person person2;

	//bi-directional many-to-one association to com.example.taller1.model.DenialNexus
	@OneToMany(mappedBy="accessdenialevent")
	private List<DenialNexus> denialNexuses;

	//bi-directional many-to-one association to com.example.taller1.model.DenialSymptom
	@OneToMany(mappedBy="accessdenialevent")
	private List<DenialSymptom> denialSymptoms;

	public Accessdenialevent() {
	}

	public long getAccdeneveId() {
		return this.accdeneveId;
	}

	public void setAccdeneveId(long accdeneveId) {
		this.accdeneveId = accdeneveId;
	}

	public Date getAccdeneveDate() {
		return this.accdeneveDate;
	}

	public void setAccdeneveDate(Date accdeneveDate) {
		this.accdeneveDate = accdeneveDate;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Person getPerson1() {
		return this.person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return this.person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public List<DenialNexus> getDenialNexuses() {
		return this.denialNexuses;
	}

	public void setDenialNexuses(List<DenialNexus> denialNexuses) {
		this.denialNexuses = denialNexuses;
	}

	public DenialNexus addDenialNexus(DenialNexus denialNexus) {
		getDenialNexuses().add(denialNexus);
		denialNexus.setAccessdenialevent(this);

		return denialNexus;
	}

	public DenialNexus removeDenialNexus(DenialNexus denialNexus) {
		getDenialNexuses().remove(denialNexus);
		denialNexus.setAccessdenialevent(null);

		return denialNexus;
	}

	public List<DenialSymptom> getDenialSymptoms() {
		return this.denialSymptoms;
	}

	public void setDenialSymptoms(List<DenialSymptom> denialSymptoms) {
		this.denialSymptoms = denialSymptoms;
	}

	public DenialSymptom addDenialSymptom(DenialSymptom denialSymptom) {
		getDenialSymptoms().add(denialSymptom);
		denialSymptom.setAccessdenialevent(this);

		return denialSymptom;
	}

	public DenialSymptom removeDenialSymptom(DenialSymptom denialSymptom) {
		getDenialSymptoms().remove(denialSymptom);
		denialSymptom.setAccessdenialevent(null);

		return denialSymptom;
	}

}