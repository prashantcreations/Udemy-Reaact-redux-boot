package com.example.demo.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name="project_task")
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="_id")
	private Integer id;
	@Column(updatable = false, unique = true)
	private String projectSequence;
	@NotBlank(message = "please add project summary") 
	@Column(name="_summary")
	private String summary;
	private String acceptanceCriteria;
	@Column(name="_status")
	private String status;
	@Column(name="_priority")
	private Integer priority;
    @JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name="_duedate")
	private Date dueDate;
	
	//onetomany wiht backlog 
	
	@Column(updatable = false)
	private String projectIdentification;
	private Date create_At;
	private Date update_At;  
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "backlog_id" ,nullable = false , updatable = false)
	@JsonIgnore
	private BackLog backlog;//it should be same as we give in backlog 
	
	

	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectSequence() {
		return projectSequence;
	}

	public void setProjectSequence(String projectSequence) {
		this.projectSequence = projectSequence;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getProjectIdentification() {
		return projectIdentification;
	}

	public void setProjectIdentification(String projectIdentification) {
		this.projectIdentification = projectIdentification;
	}

	public Date getCreate_At() {
		return create_At;
	}

	public void setCreate_At(Date create_At) {
		this.create_At = create_At;
	}

	public Date getUpdate_At() {
		return update_At;
	}

	public void setUpdate_At(Date update_At) {
		this.update_At = update_At;
	}

	@PrePersist
	protected void onCreate() 
	{
		this.create_At = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.update_At = new Date();
	}

	public BackLog getBacklog() {
		return backlog;
	}

	public void setBacklog(BackLog backlog) {
		this.backlog = backlog;
	}

	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", projectSequence=" + projectSequence + ", summary=" + summary
				+ ", acceptanceCriteria=" + acceptanceCriteria + ", status=" + status + ", priority=" + priority
				+ ", dueDate=" + dueDate + ", projectIdentification=" + projectIdentification + ", create_At="
				+ create_At + ", update_At=" + update_At + "]";
	}
}