package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import peaksoft.entities.User;
import peaksoft.repos.UserRepo;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities());
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
