package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AUTOTRANSITION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Autotransition.findAll", query="SELECT a FROM Autotransition a")
public class Autotransition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTOTRANSITION_AUTOTRANID_GENERATOR", sequenceName="AUTOTRANSITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTOTRANSITION_AUTOTRANID_GENERATOR")
	@Column(name="AUTOTRAN_ID")
	private long autotranId;

	@Column(name="AUTOTRAN_ISACTIVE")
	private String autotranIsactive;

	@Column(name="AUTOTRAN_LOGICALOPERAND")
	private String autotranLogicaloperand;

	@Column(name="AUTOTRAN_NAME")
	private String autotranName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	//bi-directional many-to-one association to com.example.taller1.model.Actionn
	@OneToMany(mappedBy="autotransition")
	private List<Actionn> actionns;

	//bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@ManyToOne
	@JoinColumn(name="EVESTAT_EVESTAT_IDORIGIN")
	private Eventstatus eventstatus1;

	//bi-directional many-to-one association to com.example.taller1.model.Eventstatus
	@ManyToOne
	@JoinColumn(name="EVESTAT_EVESTAT_IDDESTINATION")
	private Eventstatus eventstatus2;

	//bi-directional many-to-one association to com.example.taller1.model.AutotranTrigger
	@OneToMany(mappedBy="autotransition")
	private List<AutotranTrigger> autotranTriggers;

	//bi-directional many-to-one association to com.example.taller1.model.Personautotran
	@OneToMany(mappedBy="autotransition")
	private List<Personautotran> personautotrans;

	//bi-directional many-to-one association to com.example.taller1.model.Precondition
	@OneToMany(mappedBy="autotransition")
	private List<Precondition> preconditions;

	public Autotransition() {
	}

	public long getAutotranId() {
		return this.autotranId;
	}

	public void setAutotranId(long autotranId) {
		this.autotranId = autotranId;
	}

	public String getAutotranIsactive() {
		return this.autotranIsactive;
	}

	public void setAutotranIsactive(String autotranIsactive) {
		this.autotranIsactive = autotranIsactive;
	}

	public String getAutotranLogicaloperand() {
		return this.autotranLogicaloperand;
	}

	public void setAutotranLogicaloperand(String autotranLogicaloperand) {
		this.autotranLogicaloperand = autotranLogicaloperand;
	}

	public String getAutotranName() {
		return this.autotranName;
	}

	public void setAutotranName(String autotranName) {
		this.autotranName = autotranName;
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
		actionn.setAutotransition(this);

		return actionn;
	}

	public Actionn removeActionn(Actionn actionn) {
		getActionns().remove(actionn);
		actionn.setAutotransition(null);

		return actionn;
	}

	public Eventstatus getEventstatus1() {
		return this.eventstatus1;
	}

	public void setEventstatus1(Eventstatus eventstatus1) {
		this.eventstatus1 = eventstatus1;
	}

	public Eventstatus getEventstatus2() {
		return this.eventstatus2;
	}

	public void setEventstatus2(Eventstatus eventstatus2) {
		this.eventstatus2 = eventstatus2;
	}

	public List<AutotranTrigger> getAutotranTriggers() {
		return this.autotranTriggers;
	}

	public void setAutotranTriggers(List<AutotranTrigger> autotranTriggers) {
		this.autotranTriggers = autotranTriggers;
	}

	public AutotranTrigger addAutotranTrigger(AutotranTrigger autotranTrigger) {
		getAutotranTriggers().add(autotranTrigger);
		autotranTrigger.setAutotransition(this);

		return autotranTrigger;
	}

	public AutotranTrigger removeAutotranTrigger(AutotranTrigger autotranTrigger) {
		getAutotranTriggers().remove(autotranTrigger);
		autotranTrigger.setAutotransition(null);

		return autotranTrigger;
	}

	public List<Personautotran> getPersonautotrans() {
		return this.personautotrans;
	}

	public void setPersonautotrans(List<Personautotran> personautotrans) {
		this.personautotrans = personautotrans;
	}

	public Personautotran addPersonautotran(Personautotran personautotran) {
		getPersonautotrans().add(personautotran);
		personautotran.setAutotransition(this);

		return personautotran;
	}

	public Personautotran removePersonautotran(Personautotran personautotran) {
		getPersonautotrans().remove(personautotran);
		personautotran.setAutotransition(null);

		return personautotran;
	}

	public List<Precondition> getPreconditions() {
		return this.preconditions;
	}

	public void setPreconditions(List<Precondition> preconditions) {
		this.preconditions = preconditions;
	}

	public Precondition addPrecondition(Precondition precondition) {
		getPreconditions().add(precondition);
		precondition.setAutotransition(this);

		return precondition;
	}

	public Precondition removePrecondition(Precondition precondition) {
		getPreconditions().remove(precondition);
		precondition.setAutotransition(null);

		return precondition;
	}

}