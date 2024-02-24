package forum.accounting.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class RegisteredUser {
	@Setter
	String login;
	@Setter
    String firstName;
	@Setter
    String lastName;
    Set<String> roles;
	

}
