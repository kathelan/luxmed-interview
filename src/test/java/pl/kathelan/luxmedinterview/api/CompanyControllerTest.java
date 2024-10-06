package pl.kathelan.luxmedinterview.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import pl.kathelan.luxmedinterview.entities.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CompanyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateAndFindAllCompanies() {
        Company company = new Company();
        company.setName("Test Company");

        Department department = new Department();
        department.setName("Development");

        Team team = new Team();
        team.setName("Backend Team");

        Project project = new Project();
        project.setName("Project Alpha");

        Manager manager = new Manager();
        manager.setName("John Doe");
        manager.setContactInfo("john.doe@example.com");

        project.setManager(manager);
        team.setProject(project);
        department.setTeams(List.of(team));
        company.setDepartments(List.of(department));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Company> request = new HttpEntity<>(company, headers);
        ResponseEntity<Company> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/companies", HttpMethod.POST, request, Company.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        ResponseEntity<Company[]> getAllResponse = restTemplate.exchange(
                "http://localhost:" + port + "/api/companies", HttpMethod.GET, null, Company[].class);

        assertThat(getAllResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getAllResponse.getBody()).isNotEmpty();
        assertThat(getAllResponse.getBody()[0].getDepartments()).isNotEmpty();
        assertThat(getAllResponse.getBody()[0].getDepartments().getFirst().getTeams()).isNotEmpty();
        assertThat(getAllResponse.getBody()[0].getDepartments().getFirst().getTeams().getFirst().getProject()).isNotNull();
        assertThat(getAllResponse.getBody()[0].getDepartments().getFirst().getTeams().getFirst().getProject().getManager().getName()).isEqualTo("John Doe");
    }
}
