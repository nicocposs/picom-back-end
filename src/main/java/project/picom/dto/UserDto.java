package project.picom.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;



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
