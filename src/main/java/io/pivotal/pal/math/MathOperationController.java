package io.pivotal.pal.math;

import org.springframework.core.convert.ConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class MathOperationController {
    DecimalFormat twoDecimals = new DecimalFormat("0.00");

    @GetMapping("/add/{firstValue}/{secondValue}")
    public ResponseEntity<String> addition(@PathVariable String firstValue, @PathVariable String secondValue) {
        try {
            double xNumber = Double.valueOf(firstValue);
            double yNumber = Double.valueOf(secondValue);
            return new ResponseEntity<>(twoDecimals.format(xNumber + yNumber), HttpStatus.OK);
        }
        catch (NumberFormatException exception)
        {
            return new ResponseEntity<>("INVALID", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sub/{firstValue}/{secondValue}")
    public ResponseEntity<String> subtraction(@PathVariable String firstValue, @PathVariable String secondValue) {
        try {
            double xNumber = Double.valueOf(firstValue);
            double yNumber = Double.valueOf(secondValue);
            return new ResponseEntity<>(twoDecimals.format(xNumber - yNumber), HttpStatus.OK);
        }
        catch (NumberFormatException exception)
        {
            return new ResponseEntity<>("INVALID", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mul/{firstValue}/{secondValue}")
    public ResponseEntity<String> multiplication(@PathVariable String firstValue, @PathVariable String secondValue) {
        try {
            double xNumber = Double.valueOf(firstValue);
            double yNumber = Double.valueOf(secondValue);
            return new ResponseEntity<>(twoDecimals.format(xNumber * yNumber), HttpStatus.OK);
        }
        catch (NumberFormatException exception)
        {
            return new ResponseEntity<>("INVALID", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/div/{firstValue}/{secondValue}")
    public ResponseEntity<String> division(@PathVariable String firstValue, @PathVariable String secondValue) {
        try {
            double xNumber = Double.valueOf(firstValue);
            double yNumber = Double.valueOf(secondValue);
            return new ResponseEntity<>(twoDecimals.format(xNumber / yNumber), HttpStatus.OK);
        }
        catch (NumberFormatException exception)
        {
            return new ResponseEntity<>("INVALID", HttpStatus.BAD_REQUEST);
        }
    }
}
