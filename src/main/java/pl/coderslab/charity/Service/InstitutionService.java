package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entiy.Institution;
import pl.coderslab.charity.Repository.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InstitutionService {
  private final InstitutionRepository institutionRepo;

  public List<Institution> institutionList() {
    return institutionRepo.findAll();
  }
}
