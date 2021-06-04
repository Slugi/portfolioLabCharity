package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entiy.Category;
import pl.coderslab.charity.Entiy.Donation;
import pl.coderslab.charity.Entiy.Institution;
import pl.coderslab.charity.Service.CategoryService;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/makedonation")
@AllArgsConstructor
public class DonationController {
  private final DonationService donationService;
  private final InstitutionService institutionService;
  private final CategoryService categoryService;

  @GetMapping
  public String donationForm(Model model) {
    Donation donation = new Donation();
    model.addAttribute("donation", donation);
    return "form";
  }

  @PostMapping
  public String procesDonationForm(@Valid Donation donation, BindingResult result) {
    if (result.hasErrors()) {
      return "form";
    }
    donationService.makeDonation(donation);
    return "form-confirmation";
  }

  @ModelAttribute("institutions")
  public List<Institution> institutions() {
    return institutionService.institutionList();
  }

  @ModelAttribute("categories")
  public List<Category> categories() {
    return categoryService.categoryList();
  }
}
