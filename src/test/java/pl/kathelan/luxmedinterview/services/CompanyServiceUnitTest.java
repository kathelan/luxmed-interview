package pl.kathelan.luxmedinterview.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kathelan.luxmedinterview.entities.Company;
import pl.kathelan.luxmedinterview.repositories.CompanyRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceUnitTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;


    @Test
    void testSaveCompany() {
        Company company = new Company();
        company.setName("Test Company");

        when(companyRepository.save(any(Company.class))).thenReturn(company);

        Company savedCompany = companyService.save(company);

        assertEquals("Test Company", savedCompany.getName());
        verify(companyRepository, times(1)).save(company);
    }
}
