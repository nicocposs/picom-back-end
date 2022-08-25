package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Administrateur extends Utilisateur {
	
	public Administrateur(String nom, String prenom, String email, String motDePasse){
		this.nom = nom;
		this.prenom	= prenom;
		this.email = email;
		this.motDePasse	= motDePasse;
	}

	public boolean ajouterTarif() {
		//TODO Ajouter la méthode
		return true;
	};

}
