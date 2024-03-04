package com.example.springwsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class NumberController {

    private final NumberConversionClient numberConversionClient;

    public NumberController(NumberConversionClient numberConversionClient) {
        this.numberConversionClient = numberConversionClient;
    }

    @GetMapping("/number/{input}")
    String convert(@PathVariable String input) {
        return numberConversionClient.convert(new BigDecimal(input));
    }
}
