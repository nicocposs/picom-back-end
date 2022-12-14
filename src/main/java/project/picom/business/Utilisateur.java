package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.picom.validators.MailConstraint;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Utilisateur {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Veuillez remplir le champ Nom")
	protected String nom;
	@NotBlank(message = "Veuillez remplir le champ Prénom")
	protected String prenom;
	@MailConstraint
	@NotBlank(message = "Veuillez remplir le champ Email")
	protected String email;
	@Length(min = 8, message = "Veuillez entrer un mot de passe de 8 caractère minimum")
	protected String motDePasse;
	protected String role;
}
