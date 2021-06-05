package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entiy.Token;
import pl.coderslab.charity.Entiy.User;
import pl.coderslab.charity.Repository.TokenRepository;
import pl.coderslab.charity.Repository.UserRepository;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserService {

  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;
  private final TokenRepository tokenRepo;
  private final MailService mailService;

  public void registerUser(User user, String url) {
    user.setUsername(user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);
    sendToken(user, url);
  }

  private void sendToken(User user, String url) {
    String tokenValue = UUID.randomUUID().toString();
    String verifyMessage = "Kliknij w podany link, aby potwierdzić rejestrację";
    Token token = new Token();
    token.setTokenValue(tokenValue);
    token.setUser(user);
    tokenRepo.save(token);
    String activationURL = String.format("%s/token?value=%s", url, tokenValue);
    try {
      mailService.sendMail(
          user.getEmail(),
          "Potwierdzenie rejestracji!",
              String.format("%s\n%s", verifyMessage, activationURL),
          false);
    } catch (MessagingException e) {
      log.error("Error email sending", e);
    }
  }

  public void activate(User user) {
    user.setEnabled(true);
    userRepo.save(user);
  }
}
