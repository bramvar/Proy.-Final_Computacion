package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TASK database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASK_TASKID_GENERATOR", sequenceName="TASK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASK_TASKID_GENERATOR")
	@Column(name="TASK_ID")
	private long taskId;

	@Column(name="TASK_TIMEUNIT")
	private String taskTimeunit;

	@Column(name="TASK_TIMEVALUE")
	private BigDecimal taskTimevalue;

	@Column(name="TASK_TRIGGERVALUE")
	private BigDecimal taskTriggervalue;

	//bi-directional many-to-one association to com.example.taller1.model.FetTaskinstance
	@OneToMany(mappedBy="task")
	private List<FetTaskinstance> fetTaskinstances;

	//bi-directional many-to-one association to com.example.taller1.model.Actionn
	@ManyToOne
	@JoinColumn(name="ACT_ACT_ID")
	private Actionn actionn;

	//bi-directional many-to-one association to com.example.taller1.model.Tasktype
	@ManyToOne
	private Tasktype tasktype;

	//bi-directional many-to-one association to com.example.taller1.model.Timerconfig
	@OneToMany(mappedBy="task")
	private List<Timerconfig> timerconfigs;

	public Task() {
	}

	public long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskTimeunit() {
		return this.taskTimeunit;
	}

	public void setTaskTimeunit(String taskTimeunit) {
		this.taskTimeunit = taskTimeunit;
	}

	public BigDecimal getTaskTimevalue() {
		return this.taskTimevalue;
	}

	public void setTaskTimevalue(BigDecimal taskTimevalue) {
		this.taskTimevalue = taskTimevalue;
	}

	public BigDecimal getTaskTriggervalue() {
		return this.taskTriggervalue;
	}

	public void setTaskTriggervalue(BigDecimal taskTriggervalue) {
		this.taskTriggervalue = taskTriggervalue;
	}

	public List<FetTaskinstance> getFetTaskinstances() {
		return this.fetTaskinstances;
	}

	public void setFetTaskinstances(List<FetTaskinstance> fetTaskinstances) {
		this.fetTaskinstances = fetTaskinstances;
	}

	public FetTaskinstance addFetTaskinstance(FetTaskinstance fetTaskinstance) {
		getFetTaskinstances().add(fetTaskinstance);
		fetTaskinstance.setTask(this);

		return fetTaskinstance;
	}

	public FetTaskinstance removeFetTaskinstance(FetTaskinstance fetTaskinstance) {
		getFetTaskinstances().remove(fetTaskinstance);
		fetTaskinstance.setTask(null);

		return fetTaskinstance;
	}

	public Actionn getActionn() {
		return this.actionn;
	}

	public void setActionn(Actionn actionn) {
		this.actionn = actionn;
	}

	public Tasktype getTasktype() {
		return this.tasktype;
	}

	public void setTasktype(Tasktype tasktype) {
		this.tasktype = tasktype;
	}

	public List<Timerconfig> getTimerconfigs() {
		return this.timerconfigs;
	}

	public void setTimerconfigs(List<Timerconfig> timerconfigs) {
		this.timerconfigs = timerconfigs;
	}

	public Timerconfig addTimerconfig(Timerconfig timerconfig) {
		getTimerconfigs().add(timerconfig);
		timerconfig.setTask(this);

		return timerconfig;
	}

	public Timerconfig removeTimerconfig(Timerconfig timerconfig) {
		getTimerconfigs().remove(timerconfig);
		timerconfig.setTask(null);

		return timerconfig;
	}

}