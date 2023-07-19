package bank.spring_security.service;

import bank.spring_security.models.ERoles;
import bank.spring_security.models.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByRoleName (ERoles roleName);
}
