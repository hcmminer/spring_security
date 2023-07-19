package bank.spring_security.serviceImpl;

import bank.spring_security.models.Users;
import bank.spring_security.repo.UserRepo;
import bank.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Optional<Users> findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepo.existsByUserName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public Users addOrUpdate(Users user) {
        return userRepo.save(user);
    }
}
