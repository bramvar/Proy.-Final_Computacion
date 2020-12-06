package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACTIONN database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Actionn.findAll", query="SELECT a FROM Actionn a")
public class Actionn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIONN_ACTID_GENERATOR", sequenceName="ACTIONN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIONN_ACTID_GENERATOR")
	@Column(name="ACT_ID")
	private long actId;

	//bi-directional many-to-one association to com.example.taller1.model.Actiontype
	@ManyToOne
	@JoinColumn(name="ACTTYPE_ACTTYPE_ID")
	private Actiontype actiontype;

	//bi-directional many-to-one association to com.example.taller1.model.Autotransition
	@ManyToOne
	@JoinColumn(name="AUTOTRAN_AUTOTRAN_ID")
	private Autotransition autotransition;

	//bi-directional many-to-one association to com.example.taller1.model.Followup
	@OneToMany(mappedBy="actionn")
	private List<Followup> followups;

	//bi-directional many-to-one association to com.example.taller1.model.Followuptype
	@OneToMany(mappedBy="actionn")
	private List<Followuptype> followuptypes;

	//bi-directional many-to-one association to com.example.taller1.model.Task
	@OneToMany(mappedBy="actionn")
	private List<Task> tasks;

	public Actionn() {
	}

	public long getActId() {
		return this.actId;
	}

	public void setActId(long actId) {
		this.actId = actId;
	}

	public Actiontype getActiontype() {
		return this.actiontype;
	}

	public void setActiontype(Actiontype actiontype) {
		this.actiontype = actiontype;
	}

	public Autotransition getAutotransition() {
		return this.autotransition;
	}

	public void setAutotransition(Autotransition autotransition) {
		this.autotransition = autotransition;
	}

	public List<Followup> getFollowups() {
		return this.followups;
	}

	public void setFollowups(List<Followup> followups) {
		this.followups = followups;
	}

	public Followup addFollowup(Followup followup) {
		getFollowups().add(followup);
		followup.setActionn(this);

		return followup;
	}

	public Followup removeFollowup(Followup followup) {
		getFollowups().remove(followup);
		followup.setActionn(null);

		return followup;
	}

	public List<Followuptype> getFollowuptypes() {
		return this.followuptypes;
	}

	public void setFollowuptypes(List<Followuptype> followuptypes) {
		this.followuptypes = followuptypes;
	}

	public Followuptype addFollowuptype(Followuptype followuptype) {
		getFollowuptypes().add(followuptype);
		followuptype.setActionn(this);

		return followuptype;
	}

	public Followuptype removeFollowuptype(Followuptype followuptype) {
		getFollowuptypes().remove(followuptype);
		followuptype.setActionn(null);

		return followuptype;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setActionn(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setActionn(null);

		return task;
	}

}