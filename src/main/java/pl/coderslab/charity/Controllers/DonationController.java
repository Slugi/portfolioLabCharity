package pl.coderslab.charity.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.coderslab.charity.Service.CategoryService;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;

@Controller
@AllArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
}
