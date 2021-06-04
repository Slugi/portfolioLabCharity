package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;

@Controller
@AllArgsConstructor
public class HomeController {

  private final InstitutionService institutionService;
  private final DonationService donationService;

  @RequestMapping("/")
  public String homeAction(Model model) {
    model.addAttribute("institutions", institutionService.institutionList());
    model.addAttribute("quantity", donationService.sumOfQuantity());
    model.addAttribute("donationsSum", donationService.allDonationsSum());
    return "index";
  }
}
