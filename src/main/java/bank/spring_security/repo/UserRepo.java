package bank.spring_security.repo;

import bank.spring_security.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<Users, Integer> {
    Users findByUserName (String userName);
    boolean existsByUserName ( String userName);
    boolean existsByEmail (String email);

}
