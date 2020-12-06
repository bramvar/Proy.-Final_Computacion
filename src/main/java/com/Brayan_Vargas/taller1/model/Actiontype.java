package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACTIONTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Actiontype.findAll", query="SELECT a FROM Actiontype a")
public class Actiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIONTYPE_ACTTYPEID_GENERATOR", sequenceName="ACTIONTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIONTYPE_ACTTYPEID_GENERATOR")
	@Column(name="ACTTYPE_ID")
	private long acttypeId;

	@Column(name="ACTTYPE_NAME")
	private String acttypeName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Actionn
	@OneToMany(mappedBy="actiontype")
	private List<Actionn> actionns;

	public Actiontype() {
	}

	public long getActtypeId() {
		return this.acttypeId;
	}

	public void setActtypeId(long acttypeId) {
		this.acttypeId = acttypeId;
	}

	public String getActtypeName() {
		return this.acttypeName;
	}

	public void setActtypeName(String acttypeName) {
		this.acttypeName = acttypeName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public List<Actionn> getActionns() {
		return this.actionns;
	}

	public void setActionns(List<Actionn> actionns) {
		this.actionns = actionns;
	}

	public Actionn addActionn(Actionn actionn) {
		getActionns().add(actionn);
		actionn.setActiontype(this);

		return actionn;
	}

	public Actionn removeActionn(Actionn actionn) {
		getActionns().remove(actionn);
		actionn.setActiontype(null);

		return actionn;
	}

}