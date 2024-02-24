package forum.accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegUserDto {
	
	String login;
    String password;
    String firstName;
    String lastName;

}
