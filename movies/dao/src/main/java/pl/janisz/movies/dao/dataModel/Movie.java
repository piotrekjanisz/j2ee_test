package pl.janisz.movies.dao.dataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@AllArgsConstructor @NoArgsConstructor
public class Movie extends PersistentObject {
	
	@Column(name = "name", nullable = false)
	@Getter @Setter 
	private String name;
	
}
