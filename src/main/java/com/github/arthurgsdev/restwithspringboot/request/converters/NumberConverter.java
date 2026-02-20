package com.github.arthurgsdev.restwithspringboot.request.converters;

import com.github.arthurgsdev.restwithspringboot.exceptions.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) {
        String number = strNumber.replace(",", ".");

        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        String number;

        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        number = strNumber.replace(",", "."); // Converter padrão brasileiro para EUA: R$ 5,00 -> USD 5.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}