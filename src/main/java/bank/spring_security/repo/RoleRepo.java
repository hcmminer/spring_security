package bank.spring_security.repo;

import bank.spring_security.models.ERoles;
import bank.spring_security.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName (ERoles roleName);
}
