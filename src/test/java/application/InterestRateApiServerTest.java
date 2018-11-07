package application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gk.interest.rate.domain.InterestRatesResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InterestRateApiServerTest {
    @Autowired
    private TestRestTemplate server;

    @LocalServerPort
    private int port;
    
	@Test
	public void testInterestRateEndpointShouldReturnSuccess200() {
		// given a server with endpoint /interest-rates 
		
		// when we invoke /interest-rates
        String endpoint = "http://localhost:" + port + "/interest-rates";
        ResponseEntity<InterestRatesResponse> re = server.getForEntity(endpoint, InterestRatesResponse.class);

        // then
        assertEquals(200, re.getStatusCode().value());
        assertEquals(2, re.getBody().getInterestRates().size());
	}
}
