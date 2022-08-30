package project.picom.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Zone {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "zone")
	@Size(min = 4, max = 20)
	@JsonIgnore
	@ToString.Exclude
	private List<Arret> arrets;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "zones")
	@JsonIgnore
	@ToString.Exclude
	private List<Annonce> annonces;

	public Zone(String nom){
		this.nom = nom;
	}
}
