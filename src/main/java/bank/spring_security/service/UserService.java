package bank.spring_security.service;

import bank.spring_security.models.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> findByUserName (String userName);
    boolean existsByUserName ( String userName);
    boolean existsByEmail (String email);

    Users addOrUpdate(Users user);


}
