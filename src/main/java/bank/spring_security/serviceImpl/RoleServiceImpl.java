package bank.spring_security.serviceImpl;

import bank.spring_security.models.ERoles;
import bank.spring_security.models.Roles;
import bank.spring_security.repo.RoleRepo;
import bank.spring_security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Optional<Roles> findByRoleName(ERoles roleName) {
        return roleRepo.findByRoleName(roleName);
    }


}
