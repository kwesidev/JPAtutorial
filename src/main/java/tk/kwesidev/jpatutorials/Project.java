package tk.kwesidev.jpatutorials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@ManyToMany(mappedBy = "projects")
	private List<Developer> developers = new ArrayList<>();

	public Project() {

	}

	public Project(String title) {
		this.title = title;

	}
	public void setTitle(String title) {
		this.title = title;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public String getTitle() {

		return this.title;
	}
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object object) {
		Project project = (Project) object;
		if (this == object) {
			return true;
		}

		else if (!(object instanceof Developer))
			return false;

		else if (id == project.id)
			return true;

		else
			return false;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

}
