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

public class UserDto {
    
    public UserDto(Long id, String email, String role) {
        this.role = role;
        this.id = id;
        this.email = email;
    }

    String role;

    Long id;

	String email;

}
