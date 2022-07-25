package com.github.kwesidev.jpatutorials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToMany(mappedBy = "projects")
	@Setter(AccessLevel.NONE)
	private List<Developer> developers = new ArrayList<>();

	public Project() {

	}

	public Project(String title) {
		this.title = title;

	}
}
