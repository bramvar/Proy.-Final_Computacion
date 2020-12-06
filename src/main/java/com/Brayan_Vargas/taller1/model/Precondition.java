package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRECONDITION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Precondition.findAll", query="SELECT p FROM Precondition p")
public class Precondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRECONDITION_PRECONID_GENERATOR", sequenceName="PRECONDITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRECONDITION_PRECONID_GENERATOR")
	@Column(name="PRECON_ID")
	private long preconId;

	@Column(name="PRECON_LOGICALOPERAND")
	private String preconLogicaloperand;

	//bi-directional many-to-one association to com.example.taller1.model.Localcondition
	@OneToMany(mappedBy="precondition")
	private List<Localcondition> localconditions;

	//bi-directional many-to-one association to com.example.taller1.model.Autotransition
	@ManyToOne
	@JoinColumn(name="AUTOTRAN_AUTOTRAN_ID")
	private Autotransition autotransition;

	//bi-directional many-to-one association to com.example.taller1.model.Remotecondition
	@OneToMany(mappedBy="precondition")
	private List<Remotecondition> remoteconditions;

	public Precondition() {
	}

	public long getPreconId() {
		return this.preconId;
	}

	public void setPreconId(long preconId) {
		this.preconId = preconId;
	}

	public String getPreconLogicaloperand() {
		return this.preconLogicaloperand;
	}

	public void setPreconLogicaloperand(String preconLogicaloperand) {
		this.preconLogicaloperand = preconLogicaloperand;
	}

	public List<Localcondition> getLocalconditions() {
		return this.localconditions;
	}

	public void setLocalconditions(List<Localcondition> localconditions) {
		this.localconditions = localconditions;
	}

	public Localcondition addLocalcondition(Localcondition localcondition) {
		getLocalconditions().add(localcondition);
		localcondition.setPrecondition(this);

		return localcondition;
	}

	public Localcondition removeLocalcondition(Localcondition localcondition) {
		getLocalconditions().remove(localcondition);
		localcondition.setPrecondition(null);

		return localcondition;
	}

	public Autotransition getAutotransition() {
		return this.autotransition;
	}

	public void setAutotransition(Autotransition autotransition) {
		this.autotransition = autotransition;
	}

	public List<Remotecondition> getRemoteconditions() {
		return this.remoteconditions;
	}

	public void setRemoteconditions(List<Remotecondition> remoteconditions) {
		this.remoteconditions = remoteconditions;
	}

	public Remotecondition addRemotecondition(Remotecondition remotecondition) {
		getRemoteconditions().add(remotecondition);
		remotecondition.setPrecondition(this);

		return remotecondition;
	}

	public Remotecondition removeRemotecondition(Remotecondition remotecondition) {
		getRemoteconditions().remove(remotecondition);
		remotecondition.setPrecondition(null);

		return remotecondition;
	}

}