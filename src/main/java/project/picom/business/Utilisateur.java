package project.picom.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Utilisateur {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Email
	private String email;
	@Length(min = 8)
	private String motDePasse;
}
