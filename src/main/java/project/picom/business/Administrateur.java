package project.picom.business;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
public class Administrateur extends Utilisateur {
	
	public Administrateur(String nom, String prenom, String email, String motDePasse){
		this.nom = nom;
		this.prenom	= prenom;
		this.email = email;
		this.motDePasse	= motDePasse;
		this.role = "admin";
	}
}
