package project.picom.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TrancheHoraire {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Range(min = 0, max = 23)
	private int debut;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "trancheHoraires")
	@JsonIgnore
	@ToString.Exclude
	private List<Annonce> annonces;

	public TrancheHoraire(int debut) {
		this.debut = debut;
	}
}
