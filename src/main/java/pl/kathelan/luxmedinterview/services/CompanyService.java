package pl.kathelan.luxmedinterview.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kathelan.luxmedinterview.entities.Company;
import pl.kathelan.luxmedinterview.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
