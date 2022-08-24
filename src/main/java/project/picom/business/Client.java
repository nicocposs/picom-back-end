package project.picom.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Client extends Utilisateur {
	@Pattern(regexp = "/^(+33\\s[1-9]{8})|(0[1-9]\\s{8})$/")
	private String numeroDeTelephone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<Annonce> annonces;
	
	public boolean ajouterAnnonce() {
		//TODO Ajouter la méthode
		return true;
	}

}