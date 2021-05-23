package pl.coderslab.charity.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Repository.InstitutionRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepo;
}
