package pl.janisz.movies.dao.dataModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
public class PersistentObject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	@Getter @Setter private Long id;
	
	@Version
	@Column(name = "version")
	@Getter @Setter private int version;
}
