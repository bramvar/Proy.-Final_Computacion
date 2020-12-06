package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TASKTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Tasktype.findAll", query="SELECT t FROM Tasktype t")
public class Tasktype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASKTYPE_TASKTYPEID_GENERATOR", sequenceName="TASKTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKTYPE_TASKTYPEID_GENERATOR")
	@Column(name="TASKTYPE_ID")
	private long tasktypeId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="TASKTYPE_NAME")
	private String tasktypeName;

	//bi-directional many-to-one association to com.example.taller1.model.Task
	@OneToMany(mappedBy="tasktype")
	private List<Task> tasks;

	public Tasktype() {
	}

	public long getTasktypeId() {
		return this.tasktypeId;
	}

	public void setTasktypeId(long tasktypeId) {
		this.tasktypeId = tasktypeId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getTasktypeName() {
		return this.tasktypeName;
	}

	public void setTasktypeName(String tasktypeName) {
		this.tasktypeName = tasktypeName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setTasktype(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setTasktype(null);

		return task;
	}

}