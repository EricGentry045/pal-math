package test.pivotal.pal.math;

import io.pivotal.pal.math.MathInterface;
import io.pivotal.pal.math.MathOperation;
import io.pivotal.pal.math.MathOperationController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MathOperationControllerTest {
    private MathOperationController mathOperationController;
    private MathInterface mathInterface;
    DecimalFormat twoDecimals = new DecimalFormat("0.00");

    @Before
    public void setUp() throws Exception {
        mathOperationController = new MathOperationController();
        mathInterface = mock(MathInterface.class);
    }

    @Test
    public void testAddition() throws Exception {
        String xNumber = "10";
        String yNumber = "5";

        Double result = Double.valueOf(xNumber) + Double.valueOf(yNumber);

        doReturn(result)
                .when(mathInterface)
                .addition();

        ResponseEntity response = mathOperationController.addition(xNumber, yNumber);

        assertThat(response.getBody()).isEqualTo(twoDecimals.format(result));
    }


    @Test
    public void testSubtraction() throws Exception {
        String xNumber = "10";
        String yNumber = "5";

        Double result = Double.valueOf(xNumber) - Double.valueOf(yNumber);

        doReturn(result)
                .when(mathInterface)
                .subtraction();

        ResponseEntity response = mathOperationController.subtraction(xNumber, yNumber);

        assertThat(response.getBody()).isEqualTo(twoDecimals.format(result));
    }


    @Test
    public void testMultiplication() throws Exception {
        String xNumber = "10";
        String yNumber = "5";
        Double result = Double.valueOf(xNumber) * Double.valueOf(yNumber);

        doReturn(result)
                .when(mathInterface)
                .multiplication();

        ResponseEntity response = mathOperationController.multiplication(xNumber, yNumber);

        assertThat(response.getBody()).isEqualTo(twoDecimals.format(result));
    }


    @Test
    public void testDivision() throws Exception {
        String xNumber = "10";
        String yNumber = "5";
        Double result = Double.valueOf(xNumber) / Double.valueOf(yNumber);

        doReturn(result)
                .when(mathInterface)
                .division();

        ResponseEntity response = mathOperationController.division(xNumber, yNumber);

        assertThat(response.getBody()).isEqualTo(twoDecimals.format(result));
    }

    @Test
    public void testAdditionInvalid() throws Exception {
        String xNumber = "5";
        String yNumber = "cat";
        double fakeResult = 0L;

        doReturn(fakeResult)
                .when(mathInterface)
                .division();

        ResponseEntity response = mathOperationController.addition(xNumber, yNumber);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("INVALID");
    }

    @Test
    public void testSubtractInvalid() throws Exception {
        String xNumber = "5";
        String yNumber = "cat";
        double fakeResult = 0L;

        doReturn(fakeResult)
                .when(mathInterface)
                .division();

        ResponseEntity response = mathOperationController.subtraction(xNumber, yNumber);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("INVALID");
    }

    @Test
    public void testMultiplicationInvalid() throws Exception {
        String xNumber = "5";
        String yNumber = "cat";
        double fakeResult = 0L;

        doReturn(fakeResult)
                .when(mathInterface)
                .division();

        ResponseEntity response = mathOperationController.multiplication(xNumber, yNumber);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("INVALID");
    }

    @Test
    public void testDivisionInvalid() throws Exception {
        String xNumber = "5";
        String yNumber = "cat";
        double fakeResult = 0L;

        doReturn(fakeResult)
                .when(mathInterface)
                .division();

        ResponseEntity response = mathOperationController.division(xNumber, yNumber);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("INVALID");
    }
}
