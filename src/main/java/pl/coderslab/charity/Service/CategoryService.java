package pl.coderslab.charity.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entiy.Category;
import pl.coderslab.charity.Repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;

    public List<Category> categoryList() {
        return categoryRepo.findAll();
    }
}
