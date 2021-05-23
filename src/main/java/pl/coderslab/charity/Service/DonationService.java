package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Repository.DonationRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DonationService {
    private final DonationRepository donationRepo;
}