package forum.accounting.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class RoleDto {
	
	String login;
    Set<String> roles = new HashSet<String>();
    
	
    
    
	

}
