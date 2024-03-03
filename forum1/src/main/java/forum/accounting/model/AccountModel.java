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
    Set<Roles> roles;
    
    public AccountModel() {
    	
    	roles = new HashSet<Roles>();
    	addRole("admin");
    	
    }
   public AccountModel(String login, String password, String firstName, String lastName) {
	super();
	this.login = login;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
} 
    
	
    public boolean addRole(String role) {
		
    	return roles.add(Roles.valueOf(role.toUpperCase()));
	}
	
public boolean deleteRole(String role) {
		
    	return roles.remove(Roles.valueOf(role.toUpperCase()));
	}




	

}
