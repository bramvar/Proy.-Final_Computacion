package com.Brayan_Vargas.taller1.model;

import com.Brayan_Vargas.taller1.validation.newInstitution;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the INSTITUTION database table.
 * 
 */
@Entity
@NamedQuery(name = "com.example.taller1.model.Institution.findAll", query = "SELECT i FROM Institution i")
public class Institution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "INSTITUTION_INSTID_GENERATOR", sequenceName = "INSTITUTION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTITUTION_INSTID_GENERATOR")
	@Column(name = "INST_ID")
	private long instId;

	@Column(name = "INST_ACADEMICSERVERURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcademicserverurl;

	@Column(name = "INST_ACADEXTRADATAURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcadextradataurl;

	@Column(name = "INST_ACADLOGINPASSWORD")
	private String instAcadloginpassword;

	@Column(name = "INST_ACADLOGINURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcadloginurl;

	@Column(name = "INST_ACADLOGINUSERNAME")
	private String instAcadloginusername;

	@Column(name = "INST_ACADPERSONINFODOCURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcadpersoninfodocurl;

	@Column(name = "INST_ACADPERSONINFOIDURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcadpersoninfoidurl;

	@Column(name = "INST_ACADPHYSICALSPACESURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcadphysicalspacesurl;

	@Column(name = "INST_ACADPROGRAMMEDCOURSESURL")
	@NotBlank(groups = {newInstitution.class})
	private String instAcadprogrammedcoursesurl;

	@Column(name = "INST_LDAPBASEDN")
	private String instLdapbasedn;

	@Column(name = "INST_LDAPPASSWORD")
	private String instLdappassword;

	@Column(name = "INST_LDAPURL")
	@NotBlank(groups = {newInstitution.class})
	private String instLdapurl;

	@Column(name = "INST_LDAPUSERNAME")
	private String instLdapusername;

	@Column(name = "INST_LDAPUSERSEARCHBASE")
	private String instLdapusersearchbase;

	@Column(name = "INST_LDAPUSERSEARCHFILTER")
	private String instLdapusersearchfilter;

	@Column(name = "INST_NAME")
	@NotBlank(groups = {newInstitution.class})
	private String instName;

	// bi-directional many-to-one association to com.example.taller1.model.Accessdenialevent
	@OneToMany(mappedBy = "institution")
	private List<Accessdenialevent> accessdenialevents;

	// bi-directional many-to-one association to com.example.taller1.model.Devicestatus
	@OneToMany(mappedBy = "institution")
	private List<Devicestatus> devicestatuses;

	// bi-directional many-to-one association to com.example.taller1.model.Devicetype
	@OneToMany(mappedBy = "institution")
	private List<Devicetype> devicetypes;

	// bi-directional many-to-one association to com.example.taller1.model.Epidemstatustransition
	@OneToMany(mappedBy = "institution")
	private List<Epidemstatustransition> epidemstatustransitions;

	// bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@OneToMany(mappedBy = "institution")
	private List<Eventstatus> eventstatuses;

	// bi-directional many-to-one association to com.example.taller1.model.HatParameter
	@OneToMany(mappedBy = "institution")
	private List<HatParameter> hatParameters;

	// bi-directional many-to-one association to com.example.taller1.model.Institutioncampus
	@OneToMany(mappedBy = "institution")
	private List<Institutioncampus> institutioncampuses;

	// bi-directional many-to-one association to com.example.taller1.model.Measurement
	@OneToMany(mappedBy = "institution")
	private List<Measurement> measurements;

	// bi-directional many-to-one association to com.example.taller1.model.Person
	@OneToMany(mappedBy = "institution")
	private List<Person> persons;

	// bi-directional many-to-one association to com.example.taller1.model.Physicalspacetype
	@OneToMany(mappedBy = "institution")
	private List<Physicalspacetype> physicalspacetypes;

	// bi-directional many-to-one association to com.example.taller1.model.Posessiontype
	@OneToMany(mappedBy = "institution")
	private List<Posessiontype> posessiontypes;

	public Institution() {
	}

	public long getInstId() {
		return this.instId;
	}

	public void setInstId(long instId) {
		this.instId = instId;
	}

	public String getInstAcademicserverurl() {
		return this.instAcademicserverurl;
	}

	public void setInstAcademicserverurl(String instAcademicserverurl) {
		this.instAcademicserverurl = instAcademicserverurl;
	}

	public String getInstAcadextradataurl() {
		return this.instAcadextradataurl;
	}

	public void setInstAcadextradataurl(String instAcadextradataurl) {
		this.instAcadextradataurl = instAcadextradataurl;
	}

	public String getInstAcadloginpassword() {
		return this.instAcadloginpassword;
	}

	public void setInstAcadloginpassword(String instAcadloginpassword) {
		this.instAcadloginpassword = instAcadloginpassword;
	}

	public String getInstAcadloginurl() {
		return this.instAcadloginurl;
	}

	public void setInstAcadloginurl(String instAcadloginurl) {
		this.instAcadloginurl = instAcadloginurl;
	}

	public String getInstAcadloginusername() {
		return this.instAcadloginusername;
	}

	public void setInstAcadloginusername(String instAcadloginusername) {
		this.instAcadloginusername = instAcadloginusername;
	}

	public String getInstAcadpersoninfodocurl() {
		return this.instAcadpersoninfodocurl;
	}

	public void setInstAcadpersoninfodocurl(String instAcadpersoninfodocurl) {
		this.instAcadpersoninfodocurl = instAcadpersoninfodocurl;
	}

	public String getInstAcadpersoninfoidurl() {
		return this.instAcadpersoninfoidurl;
	}

	public void setInstAcadpersoninfoidurl(String instAcadpersoninfoidurl) {
		this.instAcadpersoninfoidurl = instAcadpersoninfoidurl;
	}

	public String getInstAcadphysicalspacesurl() {
		return this.instAcadphysicalspacesurl;
	}

	public void setInstAcadphysicalspacesurl(String instAcadphysicalspacesurl) {
		this.instAcadphysicalspacesurl = instAcadphysicalspacesurl;
	}

	public String getInstAcadprogrammedcoursesurl() {
		return this.instAcadprogrammedcoursesurl;
	}

	public void setInstAcadprogrammedcoursesurl(String instAcadprogrammedcoursesurl) {
		this.instAcadprogrammedcoursesurl = instAcadprogrammedcoursesurl;
	}

	public String getInstLdapbasedn() {
		return this.instLdapbasedn;
	}

	public void setInstLdapbasedn(String instLdapbasedn) {
		this.instLdapbasedn = instLdapbasedn;
	}

	public String getInstLdappassword() {
		return this.instLdappassword;
	}

	public void setInstLdappassword(String instLdappassword) {
		this.instLdappassword = instLdappassword;
	}

	public String getInstLdapurl() {
		return this.instLdapurl;
	}

	public void setInstLdapurl(String instLdapurl) {
		this.instLdapurl = instLdapurl;
	}

	public String getInstLdapusername() {
		return this.instLdapusername;
	}

	public void setInstLdapusername(String instLdapusername) {
		this.instLdapusername = instLdapusername;
	}

	public String getInstLdapusersearchbase() {
		return this.instLdapusersearchbase;
	}

	public void setInstLdapusersearchbase(String instLdapusersearchbase) {
		this.instLdapusersearchbase = instLdapusersearchbase;
	}

	public String getInstLdapusersearchfilter() {
		return this.instLdapusersearchfilter;
	}

	public void setInstLdapusersearchfilter(String instLdapusersearchfilter) {
		this.instLdapusersearchfilter = instLdapusersearchfilter;
	}

	public String getInstName() {
		return this.instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public List<Accessdenialevent> getAccessdenialevents() {
		return this.accessdenialevents;
	}

	public void setAccessdenialevents(List<Accessdenialevent> accessdenialevents) {
		this.accessdenialevents = accessdenialevents;
	}

	public Accessdenialevent addAccessdenialevent(Accessdenialevent accessdenialevent) {
		getAccessdenialevents().add(accessdenialevent);
		accessdenialevent.setInstitution(this);

		return accessdenialevent;
	}

	public Accessdenialevent removeAccessdenialevent(Accessdenialevent accessdenialevent) {
		getAccessdenialevents().remove(accessdenialevent);
		accessdenialevent.setInstitution(null);

		return accessdenialevent;
	}

	public List<Devicestatus> getDevicestatuses() {
		return this.devicestatuses;
	}

	public void setDevicestatuses(List<Devicestatus> devicestatuses) {
		this.devicestatuses = devicestatuses;
	}

	public Devicestatus addDevicestatus(Devicestatus devicestatus) {
		getDevicestatuses().add(devicestatus);
		devicestatus.setInstitution(this);

		return devicestatus;
	}

	public Devicestatus removeDevicestatus(Devicestatus devicestatus) {
		getDevicestatuses().remove(devicestatus);
		devicestatus.setInstitution(null);

		return devicestatus;
	}

	public List<Devicetype> getDevicetypes() {
		return this.devicetypes;
	}

	public void setDevicetypes(List<Devicetype> devicetypes) {
		this.devicetypes = devicetypes;
	}

	public Devicetype addDevicetype(Devicetype devicetype) {
		getDevicetypes().add(devicetype);
		devicetype.setInstitution(this);

		return devicetype;
	}

	public Devicetype removeDevicetype(Devicetype devicetype) {
		getDevicetypes().remove(devicetype);
		devicetype.setInstitution(null);

		return devicetype;
	}

	public List<Epidemstatustransition> getEpidemstatustransitions() {
		return this.epidemstatustransitions;
	}

	public void setEpidemstatustransitions(List<Epidemstatustransition> epidemstatustransitions) {
		this.epidemstatustransitions = epidemstatustransitions;
	}

	public Epidemstatustransition addEpidemstatustransition(Epidemstatustransition epidemstatustransition) {
		getEpidemstatustransitions().add(epidemstatustransition);
		epidemstatustransition.setInstitution(this);

		return epidemstatustransition;
	}

	public Epidemstatustransition removeEpidemstatustransition(Epidemstatustransition epidemstatustransition) {
		getEpidemstatustransitions().remove(epidemstatustransition);
		epidemstatustransition.setInstitution(null);

		return epidemstatustransition;
	}

	public List<Eventstatus> getEventstatuses() {
		return this.eventstatuses;
	}

	public void setEventstatuses(List<Eventstatus> eventstatuses) {
		this.eventstatuses = eventstatuses;
	}

	public Eventstatus addEventstatus(Eventstatus eventstatus) {
		getEventstatuses().add(eventstatus);
		eventstatus.setInstitution(this);

		return eventstatus;
	}

	public Eventstatus removeEventstatus(Eventstatus eventstatus) {
		getEventstatuses().remove(eventstatus);
		eventstatus.setInstitution(null);

		return eventstatus;
	}

	public List<HatParameter> getHatParameters() {
		return this.hatParameters;
	}

	public void setHatParameters(List<HatParameter> hatParameters) {
		this.hatParameters = hatParameters;
	}

	public HatParameter addHatParameter(HatParameter hatParameter) {
		getHatParameters().add(hatParameter);
		hatParameter.setInstitution(this);

		return hatParameter;
	}

	public HatParameter removeHatParameter(HatParameter hatParameter) {
		getHatParameters().remove(hatParameter);
		hatParameter.setInstitution(null);

		return hatParameter;
	}

	public List<Institutioncampus> getInstitutioncampuses() {
		return this.institutioncampuses;
	}

	public void setInstitutioncampuses(List<Institutioncampus> institutioncampuses) {
		this.institutioncampuses = institutioncampuses;
	}

	public Institutioncampus addInstitutioncampus(Institutioncampus institutioncampus) {
		getInstitutioncampuses().add(institutioncampus);
		institutioncampus.setInstitution(this);

		return institutioncampus;
	}

	public Institutioncampus removeInstitutioncampus(Institutioncampus institutioncampus) {
		getInstitutioncampuses().remove(institutioncampus);
		institutioncampus.setInstitution(null);

		return institutioncampus;
	}

	public List<Measurement> getMeasurements() {
		return this.measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public Measurement addMeasurement(Measurement measurement) {
		getMeasurements().add(measurement);
		measurement.setInstitution(this);

		return measurement;
	}

	public Measurement removeMeasurement(Measurement measurement) {
		getMeasurements().remove(measurement);
		measurement.setInstitution(null);

		return measurement;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setInstitution(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setInstitution(null);

		return person;
	}

	public List<Physicalspacetype> getPhysicalspacetypes() {
		return this.physicalspacetypes;
	}

	public void setPhysicalspacetypes(List<Physicalspacetype> physicalspacetypes) {
		this.physicalspacetypes = physicalspacetypes;
	}

	public Physicalspacetype addPhysicalspacetype(Physicalspacetype physicalspacetype) {
		getPhysicalspacetypes().add(physicalspacetype);
		physicalspacetype.setInstitution(this);

		return physicalspacetype;
	}

	public Physicalspacetype removePhysicalspacetype(Physicalspacetype physicalspacetype) {
		getPhysicalspacetypes().remove(physicalspacetype);
		physicalspacetype.setInstitution(null);

		return physicalspacetype;
	}

	public List<Posessiontype> getPosessiontypes() {
		return this.posessiontypes;
	}

	public void setPosessiontypes(List<Posessiontype> posessiontypes) {
		this.posessiontypes = posessiontypes;
	}

	public Posessiontype addPosessiontype(Posessiontype posessiontype) {
		getPosessiontypes().add(posessiontype);
		posessiontype.setInstitution(this);

		return posessiontype;
	}

	public Posessiontype removePosessiontype(Posessiontype posessiontype) {
		getPosessiontypes().remove(posessiontype);
		posessiontype.setInstitution(null);

		return posessiontype;
	}

}