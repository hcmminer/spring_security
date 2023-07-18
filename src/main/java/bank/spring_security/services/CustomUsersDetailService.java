package bank.spring_security.services;

import bank.spring_security.models.Users;
import bank.spring_security.repo.UserRepo;
import bank.spring_security.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUsersDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User Name Not Found");

        }
        return CustomUserDetails.mapUserToUserDetails(user);
    }
}
