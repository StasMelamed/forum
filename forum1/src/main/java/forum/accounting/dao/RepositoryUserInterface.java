package forum.accounting.dao;

import org.springframework.data.repository.CrudRepository;

import forum.accounting.model.AccountModel;

public interface RepositoryUserInterface extends CrudRepository<AccountModel, String>{
	
	

}
