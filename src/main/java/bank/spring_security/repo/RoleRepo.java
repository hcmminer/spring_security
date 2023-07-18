package bank.spring_security.repo;

import bank.spring_security.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName ( String roleName);
}
