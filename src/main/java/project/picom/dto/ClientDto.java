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
    
    @NotBlank
    String nom;

    @NotBlank
	String prenom;

	@Email
	String email;

	@Length(min = 8)
	String motDePasse;

    @ContactNumberConstraint
	String numeroDeTelephone;


}
