package java51.accounting.dao;

import org.springframework.data.repository.CrudRepository;

import java51.accounting.model.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

}
