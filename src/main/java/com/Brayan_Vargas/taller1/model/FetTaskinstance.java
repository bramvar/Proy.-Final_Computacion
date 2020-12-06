package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FET_TASKINSTANCE database table.
 * 
 */
@Entity
@Table(name="FET_TASKINSTANCE")
@NamedQuery(name="com.example.taller1.model.FetTaskinstance.findAll", query="SELECT f FROM FetTaskinstance f")
public class FetTaskinstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FET_TASKINSTANCE_TASKINSID_GENERATOR", sequenceName="FET_TASKINSTANCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FET_TASKINSTANCE_TASKINSID_GENERATOR")
	@Column(name="TASKINS_ID")
	private long taskinsId;

	@Temporal(TemporalType.DATE)
	@Column(name="TASKINS_EXECUTIONDATE")
	private Date taskinsExecutiondate;

	@Column(name="TASKINS_TARGETTYPE")
	private String taskinsTargettype;

	@Column(name="TASKINS_TARGETVALUE")
	private BigDecimal taskinsTargetvalue;

	//bi-directional many-to-one association to com.example.taller1.model.Task
	@ManyToOne
	private Task task;

	public FetTaskinstance() {
	}

	public long getTaskinsId() {
		return this.taskinsId;
	}

	public void setTaskinsId(long taskinsId) {
		this.taskinsId = taskinsId;
	}

	public Date getTaskinsExecutiondate() {
		return this.taskinsExecutiondate;
	}

	public void setTaskinsExecutiondate(Date taskinsExecutiondate) {
		this.taskinsExecutiondate = taskinsExecutiondate;
	}

	public String getTaskinsTargettype() {
		return this.taskinsTargettype;
	}

	public void setTaskinsTargettype(String taskinsTargettype) {
		this.taskinsTargettype = taskinsTargettype;
	}

	public BigDecimal getTaskinsTargetvalue() {
		return this.taskinsTargetvalue;
	}

	public void setTaskinsTargetvalue(BigDecimal taskinsTargetvalue) {
		this.taskinsTargetvalue = taskinsTargetvalue;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}