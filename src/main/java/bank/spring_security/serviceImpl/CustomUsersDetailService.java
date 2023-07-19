package bank.spring_security.serviceImpl;

import bank.spring_security.models.Users;
import bank.spring_security.repo.UserRepo;
import bank.spring_security.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUsersDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username:" + username));
        return CustomUserDetails.mapUserToUserDetails(user);
    }
}
