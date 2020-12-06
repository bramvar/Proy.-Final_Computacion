package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TRIGGERR database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Triggerr.findAll", query="SELECT t FROM Triggerr t")
public class Triggerr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRIGGERR_TRIGID_GENERATOR", sequenceName="TRIGGERR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRIGGERR_TRIGID_GENERATOR")
	@Column(name="TRIG_ID")
	private long trigId;

	@Column(name="TRIG_NAME")
	private String trigName;

	@Column(name="TRIG_SCOPE")
	private String trigScope;

	//bi-directional many-to-one association to com.example.taller1.model.AutotranTrigger
	@OneToMany(mappedBy="triggerr")
	private List<AutotranTrigger> autotranTriggers;

	//bi-directional many-to-one association to com.example.taller1.model.Queueautotransition
	@OneToMany(mappedBy="triggerr")
	private List<Queueautotransition> queueautotransitions;

	//bi-directional many-to-one association to com.example.taller1.model.QueueAutohistory
	@OneToMany(mappedBy="triggerr")
	private List<QueueAutohistory> queueAutohistories;

	//bi-directional many-to-one association to com.example.taller1.model.Triggertype
	@ManyToOne
	@JoinColumn(name="TRIGTYPE_TRIGTYPE_ID")
	private Triggertype triggertype;

	//bi-directional many-to-one association to com.example.taller1.model.Userselect
	@OneToMany(mappedBy="triggerr")
	private List<Userselect> userselects;

	public Triggerr() {
	}

	public long getTrigId() {
		return this.trigId;
	}

	public void setTrigId(long trigId) {
		this.trigId = trigId;
	}

	public String getTrigName() {
		return this.trigName;
	}

	public void setTrigName(String trigName) {
		this.trigName = trigName;
	}

	public String getTrigScope() {
		return this.trigScope;
	}

	public void setTrigScope(String trigScope) {
		this.trigScope = trigScope;
	}

	public List<AutotranTrigger> getAutotranTriggers() {
		return this.autotranTriggers;
	}

	public void setAutotranTriggers(List<AutotranTrigger> autotranTriggers) {
		this.autotranTriggers = autotranTriggers;
	}

	public AutotranTrigger addAutotranTrigger(AutotranTrigger autotranTrigger) {
		getAutotranTriggers().add(autotranTrigger);
		autotranTrigger.setTriggerr(this);

		return autotranTrigger;
	}

	public AutotranTrigger removeAutotranTrigger(AutotranTrigger autotranTrigger) {
		getAutotranTriggers().remove(autotranTrigger);
		autotranTrigger.setTriggerr(null);

		return autotranTrigger;
	}

	public List<Queueautotransition> getQueueautotransitions() {
		return this.queueautotransitions;
	}

	public void setQueueautotransitions(List<Queueautotransition> queueautotransitions) {
		this.queueautotransitions = queueautotransitions;
	}

	public Queueautotransition addQueueautotransition(Queueautotransition queueautotransition) {
		getQueueautotransitions().add(queueautotransition);
		queueautotransition.setTriggerr(this);

		return queueautotransition;
	}

	public Queueautotransition removeQueueautotransition(Queueautotransition queueautotransition) {
		getQueueautotransitions().remove(queueautotransition);
		queueautotransition.setTriggerr(null);

		return queueautotransition;
	}

	public List<QueueAutohistory> getQueueAutohistories() {
		return this.queueAutohistories;
	}

	public void setQueueAutohistories(List<QueueAutohistory> queueAutohistories) {
		this.queueAutohistories = queueAutohistories;
	}

	public QueueAutohistory addQueueAutohistory(QueueAutohistory queueAutohistory) {
		getQueueAutohistories().add(queueAutohistory);
		queueAutohistory.setTriggerr(this);

		return queueAutohistory;
	}

	public QueueAutohistory removeQueueAutohistory(QueueAutohistory queueAutohistory) {
		getQueueAutohistories().remove(queueAutohistory);
		queueAutohistory.setTriggerr(null);

		return queueAutohistory;
	}

	public Triggertype getTriggertype() {
		return this.triggertype;
	}

	public void setTriggertype(Triggertype triggertype) {
		this.triggertype = triggertype;
	}

	public List<Userselect> getUserselects() {
		return this.userselects;
	}

	public void setUserselects(List<Userselect> userselects) {
		this.userselects = userselects;
	}

	public Userselect addUserselect(Userselect userselect) {
		getUserselects().add(userselect);
		userselect.setTriggerr(this);

		return userselect;
	}

	public Userselect removeUserselect(Userselect userselect) {
		getUserselects().remove(userselect);
		userselect.setTriggerr(null);

		return userselect;
	}

}