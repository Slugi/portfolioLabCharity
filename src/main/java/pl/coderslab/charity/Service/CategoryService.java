package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Repository.CategoryRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;
}
