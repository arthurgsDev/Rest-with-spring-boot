package com.github.arthurgsdev.restwithspringboot.controllers;

import com.github.arthurgsdev.restwithspringboot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {
    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{firstNumber}/{secondNumber}")
    public Double sum(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {
        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(firstNumber) + convertToDouble(secondNumber);
    }

    // http://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{firstNumber}/{secondNumber}")
    public Double sub(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {
        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(firstNumber) - convertToDouble(secondNumber);
    }

    // http://localhost:8080/math/div/3/5
    @RequestMapping("/div/{firstNumber}/{secondNumber}")
    public Double div(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {

        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double numberOne = convertToDouble(firstNumber);
        Double numberTwo = convertToDouble(secondNumber);

        if (numberTwo == 0D) {
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        }

        return numberOne / numberTwo;
    }

    // http://localhost:8080/math/mul/3/5
    @RequestMapping("/mul/{firstNumber}/{secondNumber}")
    public Double multiplication(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {
        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(firstNumber) * convertToDouble(secondNumber);
    }

    // http://localhost:8080/math/average?numbers=10,20,30,40
    @GetMapping("/average")
    public Double average(@RequestParam("numbers") List<String> numbers) {

        Double sum = 0D;

        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new UnsupportedMathOperationException("Please set a numeric value!");
            }
            sum += convertToDouble(number);
        }

        if (numbers.isEmpty()) {
            return 0D;
        }

        return sum / numbers.size();
    }

    // http://localhost:8080/math/sqrt/49
    @GetMapping("/sqrt/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double mathNumber = convertToDouble(number);

        if (mathNumber < 0) {
            throw new UnsupportedMathOperationException("Square root of a negative number is not defined in real numbers!");
        }

        return Math.sqrt(mathNumber);
    }


    private Double convertToDouble(String strNumber) {
        String number = strNumber.replace(",", ".");

        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        String number;

        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        number = strNumber.replace(",", "."); // Converter padrão brasileiro para EUA: R$ 5,00 -> USD 5.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
