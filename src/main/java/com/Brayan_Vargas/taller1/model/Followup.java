package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the FOLLOWUP database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Followup.findAll", query="SELECT f FROM Followup f")
public class Followup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FOLLOWUP_FOLLID_GENERATOR", sequenceName="FOLLOWUP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOLLOWUP_FOLLID_GENERATOR")
	@Column(name="FOLL_ID")
	private long follId;

	@Column(name="FOLL_ALLOWSNOTE")
	private String follAllowsnote;

	@Column(name="FOLL_ANSWER")
	private String follAnswer;

	@Temporal(TemporalType.DATE)
	@Column(name="FOLL_DATE")
	private Date follDate;

	@Column(name="FOLL_EXPECTEDANSWER")
	private String follExpectedanswer;

	@Column(name="FOLL_ISREADED")
	private String follIsreaded;

	@Column(name="FOLL_MESSAGE")
	private String follMessage;

	@Column(name="FOLL_NOTE")
	private String follNote;

	@Column(name="FOLL_REQUIRESANSWER")
	private String follRequiresanswer;

	//bi-directional many-to-one association to com.example.taller1.model.Actionn
	@ManyToOne
	@JoinColumn(name="ACT_ACT_ID")
	private Actionn actionn;

	//bi-directional many-to-one association to com.example.taller1.model.Followuptype
	@ManyToOne
	@JoinColumn(name="FOLTYPE_FOLLOWUP_ID")
	private Followuptype followuptype;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_IDREPORTER")
	private Person person1;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_IDSUBJECT")
	private Person person2;

	public Followup() {
	}

	public long getFollId() {
		return this.follId;
	}

	public void setFollId(long follId) {
		this.follId = follId;
	}

	public String getFollAllowsnote() {
		return this.follAllowsnote;
	}

	public void setFollAllowsnote(String follAllowsnote) {
		this.follAllowsnote = follAllowsnote;
	}

	public String getFollAnswer() {
		return this.follAnswer;
	}

	public void setFollAnswer(String follAnswer) {
		this.follAnswer = follAnswer;
	}

	public Date getFollDate() {
		return this.follDate;
	}

	public void setFollDate(Date follDate) {
		this.follDate = follDate;
	}

	public String getFollExpectedanswer() {
		return this.follExpectedanswer;
	}

	public void setFollExpectedanswer(String follExpectedanswer) {
		this.follExpectedanswer = follExpectedanswer;
	}

	public String getFollIsreaded() {
		return this.follIsreaded;
	}

	public void setFollIsreaded(String follIsreaded) {
		this.follIsreaded = follIsreaded;
	}

	public String getFollMessage() {
		return this.follMessage;
	}

	public void setFollMessage(String follMessage) {
		this.follMessage = follMessage;
	}

	public String getFollNote() {
		return this.follNote;
	}

	public void setFollNote(String follNote) {
		this.follNote = follNote;
	}

	public String getFollRequiresanswer() {
		return this.follRequiresanswer;
	}

	public void setFollRequiresanswer(String follRequiresanswer) {
		this.follRequiresanswer = follRequiresanswer;
	}

	public Actionn getActionn() {
		return this.actionn;
	}

	public void setActionn(Actionn actionn) {
		this.actionn = actionn;
	}

	public Followuptype getFollowuptype() {
		return this.followuptype;
	}

	public void setFollowuptype(Followuptype followuptype) {
		this.followuptype = followuptype;
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

}