package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entiy.Donation;
import pl.coderslab.charity.Repository.DonationRepository;
import pl.coderslab.charity.Repository.UserRepository;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@Transactional
@AllArgsConstructor
public class DonationService {
  private final DonationRepository donationRepo;
  private final UserRepository userRepo;

  public int sumOfQuantity() {

    return donationRepo
        .quantitySum()
        .orElseThrow(() -> new RuntimeException("Nie można znaleźć informacji."));
  }

  public int allDonationsSum() {
    if (donationRepo.findAll().size() > 0) {
      return donationRepo.findAll().size();
    } else return 0;
  }

  public void makeDonation(Donation donation, Principal principal) {
    donation.setUser(
        userRepo
            .findByUsername(principal.getName())
            .orElseThrow(() -> new RuntimeException("Nie znaleziono użytkownika")));
    donationRepo.save(donation);
  }
}
