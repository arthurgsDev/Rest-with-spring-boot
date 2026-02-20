package com.github.arthurgsdev.restwithspringboot.math;

import java.util.List;

public class SimpleMath {

    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double sub(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double div(Double firstNumber, Double secondNumber) {
        return firstNumber / secondNumber;
    }

    public Double multiplication(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public Double average(List<Double> numbers) {
        Double sum = 0D;

        for (Double number : numbers) {
            sum += number;
        }

        return sum / numbers.size();
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}