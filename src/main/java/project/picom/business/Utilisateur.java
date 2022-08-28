package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Utilisateur {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Veuillez remplir le champs Nom")
	protected String nom;
	@NotBlank(message = "Veuillez remplir le champs Prénom")
	protected String prenom;
	@Email(message = "Veuillez entrer un email valide")
	@NotBlank(message = "Veuillez remplir le champs Email")
	protected String email;
	@Length(min = 8, message = "Veuillez entrer un mot de passe de 8 caractère minimum")
	protected String motDePasse;
}
