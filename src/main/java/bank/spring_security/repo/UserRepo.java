package bank.spring_security.repo;

import bank.spring_security.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo  extends JpaRepository<Users, Integer> {
   Optional<Users> findByUserName (String userName);
    boolean existsByUserName ( String userName);
    boolean existsByEmail (String email);

}
