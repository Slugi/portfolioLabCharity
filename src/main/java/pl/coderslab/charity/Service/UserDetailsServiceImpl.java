package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entiy.User;
import pl.coderslab.charity.Repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      User user = userRepo.findByUsername(userName).get();
    System.out.println("dupa"+ user);
        return userRepo.findByUsername(userName).orElseThrow(()->new RuntimeException("Nie znaleziono użytkownika."));
    }
}
