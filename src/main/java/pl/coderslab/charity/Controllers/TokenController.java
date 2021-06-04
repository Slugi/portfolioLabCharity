package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.Entiy.Token;
import pl.coderslab.charity.Entiy.User;
import pl.coderslab.charity.Repository.TokenRepository;
import pl.coderslab.charity.Service.UserService;


@Controller
@AllArgsConstructor
public class TokenController {
    private final UserService userService;
    private final TokenRepository tokenRepo;

    @GetMapping("/token")
    public String token(@RequestParam String value) {

        Token byValue =
                tokenRepo
                        .findTokenByTokenValue(value)
                        .orElseThrow(
                                () ->
                                        new RuntimeException(
                                                "Nie prawidłowa wartość, kliknij w przesłany link. Nie zmieniaj go!"));
        User user = byValue.getUser();
        userService.activate(user);

        return "redirect:/login";
    }
}
