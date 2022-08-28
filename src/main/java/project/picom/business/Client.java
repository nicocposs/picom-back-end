package project.picom.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import project.picom.validators.ContactNumberConstraint;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Utilisateur {
	@ContactNumberConstraint
	private String numeroDeTelephone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<Annonce> annonces;
	
	public Client(String nom, String prenom, String email, String motDePasse, String numeroDeTelephone){
		this.nom = nom;
		this.prenom	= prenom;
		this.email = email;
		this.motDePasse	= motDePasse;
		this.numeroDeTelephone = numeroDeTelephone;
		this.role = "client";
	}
}
