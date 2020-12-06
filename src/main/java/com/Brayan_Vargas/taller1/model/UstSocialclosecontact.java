package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the UST_SOCIALCLOSECONTACT database table.
 * 
 */
@Entity
@Table(name="UST_SOCIALCLOSECONTACT")
@NamedQuery(name="com.example.taller1.model.UstSocialclosecontact.findAll", query="SELECT u FROM UstSocialclosecontact u")
public class UstSocialclosecontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_SOCIALCLOSECONTACT_SOCIALID_GENERATOR", sequenceName="UST_SOCIALCLOSECONTACT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_SOCIALCLOSECONTACT_SOCIALID_GENERATOR")
	@Column(name="SOCIAL_ID")
	private long socialId;

	@Temporal(TemporalType.DATE)
	@Column(name="SOCIAL_LASTCONTACTDATE")
	private Date socialLastcontactdate;

	@Column(name="SOCIAL_NAME")
	private String socialName;

	//bi-directional many-to-one association to com.example.taller1.model.Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public UstSocialclosecontact() {
	}

	public long getSocialId() {
		return this.socialId;
	}

	public void setSocialId(long socialId) {
		this.socialId = socialId;
	}

	public Date getSocialLastcontactdate() {
		return this.socialLastcontactdate;
	}

	public void setSocialLastcontactdate(Date socialLastcontactdate) {
		this.socialLastcontactdate = socialLastcontactdate;
	}

	public String getSocialName() {
		return this.socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}