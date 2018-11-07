package application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SBApplication.class)
@WebAppConfiguration
public class InterestRateApiTest {

	private MockMvc mockMvc;
	private HttpHeaders httpHeaders;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {

		httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void invokeInterestRateGetRequestShouldBeSuccess() throws Exception {

		String url = "/interest-rates";

		mockMvc.perform(get(url)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.interestRates[0].type", Matchers.equalTo("30")))
				.andExpect(jsonPath("$.interestRates[0].rate", Matchers.equalTo(5.0)))
				.andExpect(jsonPath("$.interestRates[1].type", Matchers.equalTo("15")))
				.andExpect(jsonPath("$.interestRates[1].rate", Matchers.equalTo(3.5)));
	}
}
