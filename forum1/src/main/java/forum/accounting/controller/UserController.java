package forum.accounting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import forum.accounting.dao.AccountInterface;
import forum.accounting.dao.RepositoryUserInterface;
import forum.accounting.dto.AuthHeader;
import forum.accounting.dto.RegUserDto;
import forum.accounting.dto.RegisteredUser;
import forum.accounting.dto.RoleDto;
import forum.accounting.dto.UpdateUserDto;
import forum.accounting.dto.UserDto;
import forum.dao.ClientInterface;
import forum.dao.NewPostDto;
import forum.dto.Comment;
import forum.dto.PeriodDto;
import forum.dto.PostDto;
import forum.dto.UpdateDto;

@RestController
public class UserController{
	
	String baseUrl= "/account";
	
	@Autowired
	AccountInterface accountInterface;

	@PostMapping("/account/register")
	public RegisteredUser registerUser(@RequestBody RegUserDto regUserDto) {
		
		return accountInterface.registerUser(regUserDto);
	}

	@GetMapping("/account/login")
  //  @PreAuthorize("hasAuthority('USER')")
    public UserDto loginUser() {
        return null;
    }
 
//    @GetMapping("/admin/adminProfile")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String adminProfile() {
//        return "Welcome to Admin Profile";
//    }
	
	

	@DeleteMapping("/account/user/{user}")
	public UserDto deleteUser(@PathVariable("user") String user) {
		
		return accountInterface.deleteUser(user);
	}

	@PutMapping("/account/user/{user}")
	public UserDto updateUser(@PathVariable("user") String user,@RequestBody UpdateUserDto updateUserDto) {
		
		return accountInterface.updateUser(user, updateUserDto);
	}

	@PutMapping("/account/user/{user}/role/{role}")
	public RoleDto addRole(@PathVariable("user") String user,@PathVariable("role") String role) {
		
		return accountInterface.addRole(user, role);
	}

	@DeleteMapping("/account/user/{user}/role/{role}")
	public RoleDto deleteRoles(@PathVariable("user") String user,@PathVariable("role") String role) {
		
		return accountInterface.deleteRoles(user, role);
	}

	@PutMapping("/account/password")
	public void changePassword(String login,String newPassword) {
	
		accountInterface.changePassword(baseUrl, baseUrl);
		
	}

	@GetMapping("/account/user/{user}")
	public UserDto getUser(@PathVariable("user") String user) {
		
		return accountInterface.getUser(user);
	}


}
