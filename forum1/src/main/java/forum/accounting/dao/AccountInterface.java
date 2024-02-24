package forum.accounting.dao;

import forum.accounting.dto.AuthHeader;
import forum.accounting.dto.RegUserDto;
import forum.accounting.dto.RegisteredUser;
import forum.accounting.dto.RoleDto;
import forum.accounting.dto.UpdateUserDto;
import forum.accounting.dto.UserDto;

public interface AccountInterface {
	
	RegisteredUser registerUser(RegUserDto regUserDto);
	
	UserDto loginUser(String token);
	
	UserDto deleteUser(String user);
	
	UserDto updateUser(String user,UpdateUserDto updateUserDto);
	
	RoleDto addRole(String user,String role);
	
	RoleDto deleteRoles(String user,String role);
	
	void changePassword(String login,String newPassword);
	
	UserDto getUser(String user);

}
