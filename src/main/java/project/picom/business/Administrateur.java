package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Administrateur extends Utilisateur {
	

	public boolean ajouterTarif() {
		//TODO Ajouter la méthode
		return true;
	};

}
