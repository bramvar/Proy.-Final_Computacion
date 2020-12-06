package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FOLLOWUPTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Followuptype.findAll", query="SELECT f FROM Followuptype f")
public class Followuptype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FOLLOWUPTYPE_FOLLOWUPID_GENERATOR", sequenceName="FOLLOWUPTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOLLOWUPTYPE_FOLLOWUPID_GENERATOR")
	@Column(name="FOLLOWUP_ID")
	private long followupId;

	@Column(name="FOLLOWUP_ALLOWSNOTE")
	private String followupAllowsnote;

	@Column(name="FOLLOWUP_DELIVERY")
	private String followupDelivery;

	@Column(name="FOLLOWUP_EXPECTEDANSWER")
	private String followupExpectedanswer;

	@Column(name="FOLLOWUP_MESSAGETEMPLATE")
	private String followupMessagetemplate;

	@Column(name="FOLLOWUP_NAME")
	private String followupName;

	@Column(name="FOLLOWUP_REQUIRESANSWER")
	private String followupRequiresanswer;

	@Column(name="FOLLOWUP_SUBJECTMESSAGE")
	private String followupSubjectmessage;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Followup
	@OneToMany(mappedBy="followuptype")
	private List<Followup> followups;

	//bi-directional many-to-one association to com.example.taller1.model.Followupinterested
	@OneToMany(mappedBy="followuptype")
	private List<Followupinterested> followupinteresteds;

	//bi-directional many-to-one association to com.example.taller1.model.Actionn
	@ManyToOne
	@JoinColumn(name="ACT_ACT_ID")
	private Actionn actionn;

	//bi-directional many-to-one association to com.example.taller1.model.FolltypeEvestat
	@OneToMany(mappedBy="followuptype")
	private List<FolltypeEvestat> folltypeEvestats;

	//bi-directional many-to-one association to com.example.taller1.model.PermFolltype
	@OneToMany(mappedBy="followuptype")
	private List<PermFolltype> permFolltypes;

	public Followuptype() {
	}

	public long getFollowupId() {
		return this.followupId;
	}

	public void setFollowupId(long followupId) {
		this.followupId = followupId;
	}

	public String getFollowupAllowsnote() {
		return this.followupAllowsnote;
	}

	public void setFollowupAllowsnote(String followupAllowsnote) {
		this.followupAllowsnote = followupAllowsnote;
	}

	public String getFollowupDelivery() {
		return this.followupDelivery;
	}

	public void setFollowupDelivery(String followupDelivery) {
		this.followupDelivery = followupDelivery;
	}

	public String getFollowupExpectedanswer() {
		return this.followupExpectedanswer;
	}

	public void setFollowupExpectedanswer(String followupExpectedanswer) {
		this.followupExpectedanswer = followupExpectedanswer;
	}

	public String getFollowupMessagetemplate() {
		return this.followupMessagetemplate;
	}

	public void setFollowupMessagetemplate(String followupMessagetemplate) {
		this.followupMessagetemplate = followupMessagetemplate;
	}

	public String getFollowupName() {
		return this.followupName;
	}

	public void setFollowupName(String followupName) {
		this.followupName = followupName;
	}

	public String getFollowupRequiresanswer() {
		return this.followupRequiresanswer;
	}

	public void setFollowupRequiresanswer(String followupRequiresanswer) {
		this.followupRequiresanswer = followupRequiresanswer;
	}

	public String getFollowupSubjectmessage() {
		return this.followupSubjectmessage;
	}

	public void setFollowupSubjectmessage(String followupSubjectmessage) {
		this.followupSubjectmessage = followupSubjectmessage;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public List<Followup> getFollowups() {
		return this.followups;
	}

	public void setFollowups(List<Followup> followups) {
		this.followups = followups;
	}

	public Followup addFollowup(Followup followup) {
		getFollowups().add(followup);
		followup.setFollowuptype(this);

		return followup;
	}

	public Followup removeFollowup(Followup followup) {
		getFollowups().remove(followup);
		followup.setFollowuptype(null);

		return followup;
	}

	public List<Followupinterested> getFollowupinteresteds() {
		return this.followupinteresteds;
	}

	public void setFollowupinteresteds(List<Followupinterested> followupinteresteds) {
		this.followupinteresteds = followupinteresteds;
	}

	public Followupinterested addFollowupinterested(Followupinterested followupinterested) {
		getFollowupinteresteds().add(followupinterested);
		followupinterested.setFollowuptype(this);

		return followupinterested;
	}

	public Followupinterested removeFollowupinterested(Followupinterested followupinterested) {
		getFollowupinteresteds().remove(followupinterested);
		followupinterested.setFollowuptype(null);

		return followupinterested;
	}

	public Actionn getActionn() {
		return this.actionn;
	}

	public void setActionn(Actionn actionn) {
		this.actionn = actionn;
	}

	public List<FolltypeEvestat> getFolltypeEvestats() {
		return this.folltypeEvestats;
	}

	public void setFolltypeEvestats(List<FolltypeEvestat> folltypeEvestats) {
		this.folltypeEvestats = folltypeEvestats;
	}

	public FolltypeEvestat addFolltypeEvestat(FolltypeEvestat folltypeEvestat) {
		getFolltypeEvestats().add(folltypeEvestat);
		folltypeEvestat.setFollowuptype(this);

		return folltypeEvestat;
	}

	public FolltypeEvestat removeFolltypeEvestat(FolltypeEvestat folltypeEvestat) {
		getFolltypeEvestats().remove(folltypeEvestat);
		folltypeEvestat.setFollowuptype(null);

		return folltypeEvestat;
	}

	public List<PermFolltype> getPermFolltypes() {
		return this.permFolltypes;
	}

	public void setPermFolltypes(List<PermFolltype> permFolltypes) {
		this.permFolltypes = permFolltypes;
	}

	public PermFolltype addPermFolltype(PermFolltype permFolltype) {
		getPermFolltypes().add(permFolltype);
		permFolltype.setFollowuptype(this);

		return permFolltype;
	}

	public PermFolltype removePermFolltype(PermFolltype permFolltype) {
		getPermFolltypes().remove(permFolltype);
		permFolltype.setFollowuptype(null);

		return permFolltype;
	}

}