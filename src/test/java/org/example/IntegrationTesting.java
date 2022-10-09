package org.example;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class IntegrationTesting {
    public void testAPI(String url) {
        RestTemplate restTemplate = new RestTemplate();
        assertNotNull(restTemplate.getForEntity(url, String.class));
    }

    @DisplayName("Integration Test of Branches API")
    @Test
    public void testBranches() {
        testAPI("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches");
    }
    @DisplayName("Integration Test of Commits API")
    @Test
    public void testCommits() {
        testAPI("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches/1/commits");
    }
    @DisplayName("Integration Test of Repos API")
    @Test
    public void testRepos() {
        testAPI("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos");
    }
}