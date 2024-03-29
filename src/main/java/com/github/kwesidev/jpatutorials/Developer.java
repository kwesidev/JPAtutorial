package com.github.kwesidev.jpatutorials;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import lombok.Setter;
import lombok.Data;
import lombok.AccessLevel;

@Entity
@Table(name = "developers")
@Data
class Developer implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "first_name")

	private String firstName;
	
	@NotNull
	@Column(name = "last_name")

	private String lastName;

	@ManyToMany
	@JoinTable(name = "developer_projects", joinColumns = @JoinColumn(name = "developer_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	@Setter(AccessLevel.NONE)
	private List<Project> projects = new ArrayList<>();

	public Developer() {

	}
	public Developer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void addProject(Project project) {
		if (!(projects.contains(project))) {
			projects.add(project);
		}
	}
	public void removeProject(Project project) {
		if (projects.contains(project)) {
			projects.remove(project);
		}
	}
	public List<Project> getProjects() {
		return this.projects;
	}
	
}
