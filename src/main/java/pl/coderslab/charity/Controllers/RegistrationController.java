package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.charity.Entiy.User;
import pl.coderslab.charity.Service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class RegistrationController {
  private final UserService userService;

  @GetMapping("/register")
  public String registerUser(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/register")
  public String register(User user, HttpServletRequest req)
      throws IOException {
    String schema = req.getScheme();
    String serverName = req.getServerName();
    int serverPort = req.getServerPort();
    String shemaPort;

    if (("http".equals(schema) && serverPort == 80)
        || ("https".equals(schema) && serverPort == 443)) {
      shemaPort = "";
    } else {
      shemaPort = ":" + serverPort;
    }
      userService.registerUser(user, schema + "://" + serverName + shemaPort);
      return "redirect:/login";

  }
}
