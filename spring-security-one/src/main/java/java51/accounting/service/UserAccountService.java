package java51.accounting.service;

import java51.accounting.dto.RolesDto;
import java51.accounting.dto.UserDto;
import java51.accounting.dto.UserEditDto;
import java51.accounting.dto.UserRegisterDto;

public interface UserAccountService {

	UserDto register(UserRegisterDto userRegisterDto);

	UserDto getUser(String login);

	UserDto removeUser(String login);

	UserDto updateUser(String login, UserEditDto userEditDto);

	RolesDto changeRolesList(String login, String role, boolean isAddRole);

	void changePassword(String login, String newPassword);

}
