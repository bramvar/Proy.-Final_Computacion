package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the POSESSIONTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Posessiontype.findAll", query="SELECT p FROM Posessiontype p")
public class Posessiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POSESSIONTYPE_POSTYPEID_GENERATOR", sequenceName="POSESSIONTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POSESSIONTYPE_POSTYPEID_GENERATOR")
	@Column(name="POSTYPE_ID")
	private long postypeId;

	@Column(name="POSTYPE_NAME")
	private String postypeName;

	//bi-directional many-to-one association to com.example.taller1.model.Posession
	@OneToMany(mappedBy="posessiontype")
	private List<Posession> posessions;

	//bi-directional many-to-one association to com.example.taller1.model.Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	public Posessiontype() {
	}

	public long getPostypeId() {
		return this.postypeId;
	}

	public void setPostypeId(long postypeId) {
		this.postypeId = postypeId;
	}

	public String getPostypeName() {
		return this.postypeName;
	}

	public void setPostypeName(String postypeName) {
		this.postypeName = postypeName;
	}

	public List<Posession> getPosessions() {
		return this.posessions;
	}

	public void setPosessions(List<Posession> posessions) {
		this.posessions = posessions;
	}

	public Posession addPosession(Posession posession) {
		getPosessions().add(posession);
		posession.setPosessiontype(this);

		return posession;
	}

	public Posession removePosession(Posession posession) {
		getPosessions().remove(posession);
		posession.setPosessiontype(null);

		return posession;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}