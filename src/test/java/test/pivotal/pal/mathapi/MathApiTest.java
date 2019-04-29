package test.pivotal.pal.mathapi;

import com.jayway.jsonpath.DocumentContext;
import io.pivotal.pal.math.PalMathApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalMathApplication.class, webEnvironment = RANDOM_PORT)
public class MathApiTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final long xNumber = 10L;
    private final long yNumber = 5L;
    private final long additionResult = xNumber + yNumber;
    private final long subtractionResult = xNumber - yNumber;
    private final long multiplicationResult = xNumber * yNumber;
    private final long divisionResult = xNumber / yNumber;

    /*
     * successful tests for GET
     */
    @Test
    public void testAdditionViaGet() throws Exception {
        ResponseEntity<String> additionResponse = restTemplate.getForEntity("/add/" + xNumber + "/" + yNumber, String.class);

        assertThat(additionResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(additionResponse.getBody()).isEqualTo(additionResult);
    }

    @Test
    public void testSubtractionViaGet() throws Exception {
        ResponseEntity<String> subtractionResponse = restTemplate.getForEntity("/sub/" + xNumber + "/" + yNumber, String.class);

        assertThat(subtractionResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(subtractionResponse.getBody()).isEqualTo(subtractionResult);
    }

    @Test
    public void testMultiplicationViaGet() throws Exception {
        ResponseEntity<String> multiplicationResponse = restTemplate.getForEntity("/mul/" + xNumber + "/" + yNumber, String.class);

        assertThat(multiplicationResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(multiplicationResponse.getBody()).isEqualTo(multiplicationResult);
    }

    @Test
    public void testDivisionViaGet() throws Exception {
        ResponseEntity<String> divisionResponse = restTemplate.getForEntity("/div/" + xNumber + "/" + yNumber, String.class);

        assertThat(divisionResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(divisionResponse.getBody()).isEqualTo(divisionResult);
    }
}
