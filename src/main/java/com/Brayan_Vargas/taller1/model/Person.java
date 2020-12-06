package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_PERSID_GENERATOR", sequenceName="PERSON_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSID_GENERATOR")
	@Column(name="PERS_ID")
	private long persId;

	@Column(name="PERS_ADDRESS")
	private String persAddress;

	@Column(name="PERS_CONTACTNUMBER")
	private String persContactnumber;

	@Column(name="PERS_EMAIL")
	private String persEmail;

	@Column(name="PERS_EXTID")
	private String persExtid;

	@Column(name="PERS_IDDOCUMENT")
	private String persIddocument;

	@Column(name="PERS_ISACTIVE")
	private String persIsactive;

	@Column(name="PERS_LASTNAME")
	private String persLastname;

	@Column(name="PERS_LATITUDE")
	private String persLatitude;

	@Column(name="PERS_LOCALDATA")
	private String persLocaldata;

	@Column(name="PERS_LONGITUDE")
	private String persLongitude;

	@Column(name="PERS_NAME")
	private String persName;

	@Temporal(TemporalType.DATE)
	@Column(name="PERS_ONSETDATE")
	private Date persOnsetdate;

	@Column(name="PERS_POLITICSACCEPTED")
	private String persPoliticsaccepted;

	@Temporal(TemporalType.DATE)
	@Column(name="PERS_POLITICSACCEPTEDDATE")
	private Date persPoliticsaccepteddate;

	//bi-directional many-to-one association to com.example.taller1.model.Accessdenialevent
	@OneToMany(mappedBy="person1")
	private List<Accessdenialevent> accessdenialevents1;

	//bi-directional many-to-one association to com.example.taller1.model.Accessdenialevent
	@OneToMany(mappedBy="person2")
	private List<Accessdenialevent> accessdenialevents2;

	//bi-directional many-to-one association to com.example.taller1.model.Attendance
	@OneToMany(mappedBy="person")
	private List<Attendance> attendances;

	//bi-directional many-to-one association to com.example.taller1.model.Contactfence
	@OneToMany(mappedBy="person")
	private List<Contactfence> contactfences;

	//bi-directional many-to-one association to com.example.taller1.model.Docstateinstance
	@OneToMany(mappedBy="person")
	private List<Docstateinstance> docstateinstances;

	//bi-directional many-to-one association to com.example.taller1.model.Documentt
	@OneToMany(mappedBy="person")
	private List<Documentt> documentts;

	//bi-directional many-to-one association to com.example.taller1.model.Followup
	@OneToMany(mappedBy="person1")
	private List<Followup> followups1;

	//bi-directional many-to-one association to com.example.taller1.model.Followup
	@OneToMany(mappedBy="person2")
	private List<Followup> followups2;

	//bi-directional many-to-one association to com.example.taller1.model.Iddocumenttype
	@ManyToOne
	@JoinColumn(name="IDDOCTYPE_IDDOCTYPE_ID")
	private Iddocumenttype iddocumenttype;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	//bi-directional many-to-one association to com.example.taller1.model.Personautotran
	@OneToMany(mappedBy="person")
	private List<Personautotran> personautotrans;

	//bi-directional many-to-one association to com.example.taller1.model.Personrelationship
	@OneToMany(mappedBy="person1")
	private List<Personrelationship> personrelationships1;

	//bi-directional many-to-one association to com.example.taller1.model.Personrelationship
	@OneToMany(mappedBy="person2")
	private List<Personrelationship> personrelationships2;

	//bi-directional many-to-one association to com.example.taller1.model.PersonFence
	@OneToMany(mappedBy="person")
	private List<PersonFence> personFences;

	//bi-directional many-to-one association to com.example.taller1.model.PersonRole
	@OneToMany(fetch = FetchType.EAGER, mappedBy="person")
	private List<PersonRole> personRoles;

	//bi-directional many-to-one association to com.example.taller1.model.PersonVulner
	@OneToMany(mappedBy="person")
	private List<PersonVulner> personVulners;

	//bi-directional many-to-one association to com.example.taller1.model.Physicalcheckup
	@OneToMany(mappedBy="person")
	private List<Physicalcheckup> physicalcheckups;

	//bi-directional many-to-one association to com.example.taller1.model.Posession
	@OneToMany(mappedBy="person")
	private List<Posession> posessions;

	//bi-directional many-to-one association to com.example.taller1.model.Userr
	@OneToMany(mappedBy="person")
	private List<Userr> userrs;

	//bi-directional many-to-one association to com.example.taller1.model.UstPersonNexus
	@OneToMany(mappedBy="person")
	private List<UstPersonNexus> ustPersonNexuses;

	//bi-directional many-to-one association to com.example.taller1.model.UstPersonStatus
	@OneToMany(mappedBy="person")
	private List<UstPersonStatus> ustPersonStatuses;

	//bi-directional many-to-one association to com.example.taller1.model.UstPersonSymptom
	@OneToMany(mappedBy="person")
	private List<UstPersonSymptom> ustPersonSymptoms;

	//bi-directional many-to-one association to com.example.taller1.model.UstSocialclosecontact
	@OneToMany(mappedBy="person")
	private List<UstSocialclosecontact> ustSocialclosecontacts;

	//bi-directional many-to-one association to com.example.taller1.model.Visit
	@OneToMany(mappedBy="person")
	private List<Visit> visits;

	public Person() {
	}

	public long getPersId() {
		return this.persId;
	}

	public void setPersId(long persId) {
		this.persId = persId;
	}

	public String getPersAddress() {
		return this.persAddress;
	}

	public void setPersAddress(String persAddress) {
		this.persAddress = persAddress;
	}

	public String getPersContactnumber() {
		return this.persContactnumber;
	}

	public void setPersContactnumber(String persContactnumber) {
		this.persContactnumber = persContactnumber;
	}

	public String getPersEmail() {
		return this.persEmail;
	}

	public void setPersEmail(String persEmail) {
		this.persEmail = persEmail;
	}

	public String getPersExtid() {
		return this.persExtid;
	}

	public void setPersExtid(String persExtid) {
		this.persExtid = persExtid;
	}

	public String getPersIddocument() {
		return this.persIddocument;
	}

	public void setPersIddocument(String persIddocument) {
		this.persIddocument = persIddocument;
	}

	public String getPersIsactive() {
		return this.persIsactive;
	}

	public void setPersIsactive(String persIsactive) {
		this.persIsactive = persIsactive;
	}

	public String getPersLastname() {
		return this.persLastname;
	}

	public void setPersLastname(String persLastname) {
		this.persLastname = persLastname;
	}

	public String getPersLatitude() {
		return this.persLatitude;
	}

	public void setPersLatitude(String persLatitude) {
		this.persLatitude = persLatitude;
	}

	public String getPersLocaldata() {
		return this.persLocaldata;
	}

	public void setPersLocaldata(String persLocaldata) {
		this.persLocaldata = persLocaldata;
	}

	public String getPersLongitude() {
		return this.persLongitude;
	}

	public void setPersLongitude(String persLongitude) {
		this.persLongitude = persLongitude;
	}

	public String getPersName() {
		return this.persName;
	}

	public void setPersName(String persName) {
		this.persName = persName;
	}

	public Date getPersOnsetdate() {
		return this.persOnsetdate;
	}

	public void setPersOnsetdate(Date persOnsetdate) {
		this.persOnsetdate = persOnsetdate;
	}

	public String getPersPoliticsaccepted() {
		return this.persPoliticsaccepted;
	}

	public void setPersPoliticsaccepted(String persPoliticsaccepted) {
		this.persPoliticsaccepted = persPoliticsaccepted;
	}

	public Date getPersPoliticsaccepteddate() {
		return this.persPoliticsaccepteddate;
	}

	public void setPersPoliticsaccepteddate(Date persPoliticsaccepteddate) {
		this.persPoliticsaccepteddate = persPoliticsaccepteddate;
	}

	public List<Accessdenialevent> getAccessdenialevents1() {
		return this.accessdenialevents1;
	}

	public void setAccessdenialevents1(List<Accessdenialevent> accessdenialevents1) {
		this.accessdenialevents1 = accessdenialevents1;
	}

	public Accessdenialevent addAccessdenialevents1(Accessdenialevent accessdenialevents1) {
		getAccessdenialevents1().add(accessdenialevents1);
		accessdenialevents1.setPerson1(this);

		return accessdenialevents1;
	}

	public Accessdenialevent removeAccessdenialevents1(Accessdenialevent accessdenialevents1) {
		getAccessdenialevents1().remove(accessdenialevents1);
		accessdenialevents1.setPerson1(null);

		return accessdenialevents1;
	}

	public List<Accessdenialevent> getAccessdenialevents2() {
		return this.accessdenialevents2;
	}

	public void setAccessdenialevents2(List<Accessdenialevent> accessdenialevents2) {
		this.accessdenialevents2 = accessdenialevents2;
	}

	public Accessdenialevent addAccessdenialevents2(Accessdenialevent accessdenialevents2) {
		getAccessdenialevents2().add(accessdenialevents2);
		accessdenialevents2.setPerson2(this);

		return accessdenialevents2;
	}

	public Accessdenialevent removeAccessdenialevents2(Accessdenialevent accessdenialevents2) {
		getAccessdenialevents2().remove(accessdenialevents2);
		accessdenialevents2.setPerson2(null);

		return accessdenialevents2;
	}

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Attendance addAttendance(Attendance attendance) {
		getAttendances().add(attendance);
		attendance.setPerson(this);

		return attendance;
	}

	public Attendance removeAttendance(Attendance attendance) {
		getAttendances().remove(attendance);
		attendance.setPerson(null);

		return attendance;
	}

	public List<Contactfence> getContactfences() {
		return this.contactfences;
	}

	public void setContactfences(List<Contactfence> contactfences) {
		this.contactfences = contactfences;
	}

	public Contactfence addContactfence(Contactfence contactfence) {
		getContactfences().add(contactfence);
		contactfence.setPerson(this);

		return contactfence;
	}

	public Contactfence removeContactfence(Contactfence contactfence) {
		getContactfences().remove(contactfence);
		contactfence.setPerson(null);

		return contactfence;
	}

	public List<Docstateinstance> getDocstateinstances() {
		return this.docstateinstances;
	}

	public void setDocstateinstances(List<Docstateinstance> docstateinstances) {
		this.docstateinstances = docstateinstances;
	}

	public Docstateinstance addDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().add(docstateinstance);
		docstateinstance.setPerson(this);

		return docstateinstance;
	}

	public Docstateinstance removeDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().remove(docstateinstance);
		docstateinstance.setPerson(null);

		return docstateinstance;
	}

	public List<Documentt> getDocumentts() {
		return this.documentts;
	}

	public void setDocumentts(List<Documentt> documentts) {
		this.documentts = documentts;
	}

	public Documentt addDocumentt(Documentt documentt) {
		getDocumentts().add(documentt);
		documentt.setPerson(this);

		return documentt;
	}

	public Documentt removeDocumentt(Documentt documentt) {
		getDocumentts().remove(documentt);
		documentt.setPerson(null);

		return documentt;
	}

	public List<Followup> getFollowups1() {
		return this.followups1;
	}

	public void setFollowups1(List<Followup> followups1) {
		this.followups1 = followups1;
	}

	public Followup addFollowups1(Followup followups1) {
		getFollowups1().add(followups1);
		followups1.setPerson1(this);

		return followups1;
	}

	public Followup removeFollowups1(Followup followups1) {
		getFollowups1().remove(followups1);
		followups1.setPerson1(null);

		return followups1;
	}

	public List<Followup> getFollowups2() {
		return this.followups2;
	}

	public void setFollowups2(List<Followup> followups2) {
		this.followups2 = followups2;
	}

	public Followup addFollowups2(Followup followups2) {
		getFollowups2().add(followups2);
		followups2.setPerson2(this);

		return followups2;
	}

	public Followup removeFollowups2(Followup followups2) {
		getFollowups2().remove(followups2);
		followups2.setPerson2(null);

		return followups2;
	}

	public Iddocumenttype getIddocumenttype() {
		return this.iddocumenttype;
	}

	public void setIddocumenttype(Iddocumenttype iddocumenttype) {
		this.iddocumenttype = iddocumenttype;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Personautotran> getPersonautotrans() {
		return this.personautotrans;
	}

	public void setPersonautotrans(List<Personautotran> personautotrans) {
		this.personautotrans = personautotrans;
	}

	public Personautotran addPersonautotran(Personautotran personautotran) {
		getPersonautotrans().add(personautotran);
		personautotran.setPerson(this);

		return personautotran;
	}

	public Personautotran removePersonautotran(Personautotran personautotran) {
		getPersonautotrans().remove(personautotran);
		personautotran.setPerson(null);

		return personautotran;
	}

	public List<Personrelationship> getPersonrelationships1() {
		return this.personrelationships1;
	}

	public void setPersonrelationships1(List<Personrelationship> personrelationships1) {
		this.personrelationships1 = personrelationships1;
	}

	public Personrelationship addPersonrelationships1(Personrelationship personrelationships1) {
		getPersonrelationships1().add(personrelationships1);
		personrelationships1.setPerson1(this);

		return personrelationships1;
	}

	public Personrelationship removePersonrelationships1(Personrelationship personrelationships1) {
		getPersonrelationships1().remove(personrelationships1);
		personrelationships1.setPerson1(null);

		return personrelationships1;
	}

	public List<Personrelationship> getPersonrelationships2() {
		return this.personrelationships2;
	}

	public void setPersonrelationships2(List<Personrelationship> personrelationships2) {
		this.personrelationships2 = personrelationships2;
	}

	public Personrelationship addPersonrelationships2(Personrelationship personrelationships2) {
		getPersonrelationships2().add(personrelationships2);
		personrelationships2.setPerson2(this);

		return personrelationships2;
	}

	public Personrelationship removePersonrelationships2(Personrelationship personrelationships2) {
		getPersonrelationships2().remove(personrelationships2);
		personrelationships2.setPerson2(null);

		return personrelationships2;
	}

	public List<PersonFence> getPersonFences() {
		return this.personFences;
	}

	public void setPersonFences(List<PersonFence> personFences) {
		this.personFences = personFences;
	}

	public PersonFence addPersonFence(PersonFence personFence) {
		getPersonFences().add(personFence);
		personFence.setPerson(this);

		return personFence;
	}

	public PersonFence removePersonFence(PersonFence personFence) {
		getPersonFences().remove(personFence);
		personFence.setPerson(null);

		return personFence;
	}

	public List<PersonRole> getPersonRoles() {
		return this.personRoles;
	}

	public void setPersonRoles(List<PersonRole> personRoles) {
		this.personRoles = personRoles;
	}

	public PersonRole addPersonRole(PersonRole personRole) {
		getPersonRoles().add(personRole);
		personRole.setPerson(this);

		return personRole;
	}

	public PersonRole removePersonRole(PersonRole personRole) {
		getPersonRoles().remove(personRole);
		personRole.setPerson(null);

		return personRole;
	}

	public List<PersonVulner> getPersonVulners() {
		return this.personVulners;
	}

	public void setPersonVulners(List<PersonVulner> personVulners) {
		this.personVulners = personVulners;
	}

	public PersonVulner addPersonVulner(PersonVulner personVulner) {
		getPersonVulners().add(personVulner);
		personVulner.setPerson(this);

		return personVulner;
	}

	public PersonVulner removePersonVulner(PersonVulner personVulner) {
		getPersonVulners().remove(personVulner);
		personVulner.setPerson(null);

		return personVulner;
	}

	public List<Physicalcheckup> getPhysicalcheckups() {
		return this.physicalcheckups;
	}

	public void setPhysicalcheckups(List<Physicalcheckup> physicalcheckups) {
		this.physicalcheckups = physicalcheckups;
	}

	public Physicalcheckup addPhysicalcheckup(Physicalcheckup physicalcheckup) {
		getPhysicalcheckups().add(physicalcheckup);
		physicalcheckup.setPerson(this);

		return physicalcheckup;
	}

	public Physicalcheckup removePhysicalcheckup(Physicalcheckup physicalcheckup) {
		getPhysicalcheckups().remove(physicalcheckup);
		physicalcheckup.setPerson(null);

		return physicalcheckup;
	}

	public List<Posession> getPosessions() {
		return this.posessions;
	}

	public void setPosessions(List<Posession> posessions) {
		this.posessions = posessions;
	}

	public Posession addPosession(Posession posession) {
		getPosessions().add(posession);
		posession.setPerson(this);

		return posession;
	}

	public Posession removePosession(Posession posession) {
		getPosessions().remove(posession);
		posession.setPerson(null);

		return posession;
	}

	public List<Userr> getUserrs() {
		return this.userrs;
	}

	public void setUserrs(List<Userr> userrs) {
		this.userrs = userrs;
	}

	public Userr addUserr(Userr userr) {
		getUserrs().add(userr);
		userr.setPerson(this);

		return userr;
	}

	public Userr removeUserr(Userr userr) {
		getUserrs().remove(userr);
		userr.setPerson(null);

		return userr;
	}

	public List<UstPersonNexus> getUstPersonNexuses() {
		return this.ustPersonNexuses;
	}

	public void setUstPersonNexuses(List<UstPersonNexus> ustPersonNexuses) {
		this.ustPersonNexuses = ustPersonNexuses;
	}

	public UstPersonNexus addUstPersonNexus(UstPersonNexus ustPersonNexus) {
		getUstPersonNexuses().add(ustPersonNexus);
		ustPersonNexus.setPerson(this);

		return ustPersonNexus;
	}

	public UstPersonNexus removeUstPersonNexus(UstPersonNexus ustPersonNexus) {
		getUstPersonNexuses().remove(ustPersonNexus);
		ustPersonNexus.setPerson(null);

		return ustPersonNexus;
	}

	public List<UstPersonStatus> getUstPersonStatuses() {
		return this.ustPersonStatuses;
	}

	public void setUstPersonStatuses(List<UstPersonStatus> ustPersonStatuses) {
		this.ustPersonStatuses = ustPersonStatuses;
	}

	public UstPersonStatus addUstPersonStatus(UstPersonStatus ustPersonStatus) {
		getUstPersonStatuses().add(ustPersonStatus);
		ustPersonStatus.setPerson(this);

		return ustPersonStatus;
	}

	public UstPersonStatus removeUstPersonStatus(UstPersonStatus ustPersonStatus) {
		getUstPersonStatuses().remove(ustPersonStatus);
		ustPersonStatus.setPerson(null);

		return ustPersonStatus;
	}

	public List<UstPersonSymptom> getUstPersonSymptoms() {
		return this.ustPersonSymptoms;
	}

	public void setUstPersonSymptoms(List<UstPersonSymptom> ustPersonSymptoms) {
		this.ustPersonSymptoms = ustPersonSymptoms;
	}

	public UstPersonSymptom addUstPersonSymptom(UstPersonSymptom ustPersonSymptom) {
		getUstPersonSymptoms().add(ustPersonSymptom);
		ustPersonSymptom.setPerson(this);

		return ustPersonSymptom;
	}

	public UstPersonSymptom removeUstPersonSymptom(UstPersonSymptom ustPersonSymptom) {
		getUstPersonSymptoms().remove(ustPersonSymptom);
		ustPersonSymptom.setPerson(null);

		return ustPersonSymptom;
	}

	public List<UstSocialclosecontact> getUstSocialclosecontacts() {
		return this.ustSocialclosecontacts;
	}

	public void setUstSocialclosecontacts(List<UstSocialclosecontact> ustSocialclosecontacts) {
		this.ustSocialclosecontacts = ustSocialclosecontacts;
	}

	public UstSocialclosecontact addUstSocialclosecontact(UstSocialclosecontact ustSocialclosecontact) {
		getUstSocialclosecontacts().add(ustSocialclosecontact);
		ustSocialclosecontact.setPerson(this);

		return ustSocialclosecontact;
	}

	public UstSocialclosecontact removeUstSocialclosecontact(UstSocialclosecontact ustSocialclosecontact) {
		getUstSocialclosecontacts().remove(ustSocialclosecontact);
		ustSocialclosecontact.setPerson(null);

		return ustSocialclosecontact;
	}

	public List<Visit> getVisits() {
		return this.visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public Visit addVisit(Visit visit) {
		getVisits().add(visit);
		visit.setPerson(this);

		return visit;
	}

	public Visit removeVisit(Visit visit) {
		getVisits().remove(visit);
		visit.setPerson(null);

		return visit;
	}

}