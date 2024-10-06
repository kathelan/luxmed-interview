package pl.kathelan.luxmedinterview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kathelan.luxmedinterview.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

