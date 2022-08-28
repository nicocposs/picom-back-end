package project.picom.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import project.picom.validators.ContactNumberConstraint;


@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ClientDto {
    
    @NotBlank(message = "Veuillez remplir le champs Nom")
    String nom;

    @NotBlank(message = "Veuillez remplir le champs Prénom")
	String prenom;

	@Email(message = "Veuillez entrer un email valide")
	String email;

	@Length(min = 8, message = "Veuillez entrer un mot de passe à 8 caractères minimum")
	String motDePasse;

    @ContactNumberConstraint (message = "Veuillez entrer un contact")
	String numeroDeTelephone;


}
