package forum.accounting.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Document(collection = "accounts")
@EqualsAndHashCode(of = "login")
@NoArgsConstructor
public class AccountModel {
	
	@Id
	@Setter
	String login;
	@Setter
	String password;
	@Setter
    String firstName;
	@Setter
    String lastName;	
    Set<String> roles = new HashSet<String>(Arrays.asList("USER"));
    
	
    public boolean addRole(String role) {
		
    	return roles.add(role);
	}
	
public boolean deleteRole(String role) {
		
    	return roles.remove(role);
	}
	

}
