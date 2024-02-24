package forum.accounting.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import forum.accounting.dao.AccountInterface;
import forum.accounting.dao.RepositoryUserInterface;
import forum.accounting.dto.AuthHeader;
import forum.accounting.dto.RegUserDto;
import forum.accounting.dto.RegisteredUser;
import forum.accounting.dto.RoleDto;
import forum.accounting.dto.UpdateUserDto;
import forum.accounting.dto.UserDto;
import forum.accounting.dto.UserExistsException;
import forum.accounting.dto.UserNotFoundException;
import forum.accounting.model.AccountModel;
import forum.dao.ClientInterface;
import forum.dao.NewPostDto;
import forum.dto.Comment;
import forum.dto.PeriodDto;
import forum.dto.PostDto;
import forum.dto.UpdateDto;

@Component
public class UserService implements AccountInterface {
	
	@Autowired
	RepositoryUserInterface repositoryUserInterface;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public RegisteredUser registerUser(RegUserDto regUserDto) {
		
		if(repositoryUserInterface.existsById(regUserDto.getLogin())) {
			throw new UserExistsException();
		}
		
		AccountModel accountModel = new AccountModel();
		
		accountModel.setFirstName(regUserDto.getFirstName());
		accountModel.setLastName(regUserDto.getLastName());
		accountModel.setLogin(regUserDto.getLogin());
		
		String password = BCrypt.hashpw(regUserDto.getPassword(), BCrypt.gensalt());
		
		accountModel.setPassword(password);
		
		repositoryUserInterface.save(accountModel);
		
		return modelMapper.map(accountModel, RegisteredUser.class);
	}

	@Override
	public UserDto loginUser(String login) {
		
		//boolean password = BCrypt.checkpw(authorization, repositoryUserInterface.findById(authorization))
		
		AccountModel accountModel = repositoryUserInterface.findById(login).orElseThrow(UserNotFoundException::new);
		
		return modelMapper.map(accountModel, UserDto.class);
	}

	@Override
	public UserDto deleteUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(String user, UpdateUserDto updateUserDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDto addRole(String user, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDto deleteRoles(String user, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(String login,String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto getUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
