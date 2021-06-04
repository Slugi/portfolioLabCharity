package pl.coderslab.charity.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entiy.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {
@Query(nativeQuery = true, value="select sum(quantity) from donation")
Optional<Integer> quantitySum();
}
