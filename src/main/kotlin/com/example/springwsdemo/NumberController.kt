package com.example.springwsdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class NumberController(private val numberConversionClient: NumberConversionClient) {
    @GetMapping("/tax/{input}/{taxRate}")
    fun convert(@PathVariable input: String, @PathVariable taxRate: String): String {
        val inputNumber = BigDecimal(input).setScale(2)
        val taxRateNumber = BigDecimal(taxRate).setScale(2)
        val inputWords = numberConversionClient.convert(inputNumber)
        val wordsWithTax = numberConversionClient.convert(
            inputNumber + inputNumber * taxRateNumber / BigDecimal(100))
        return "$inputWords plus $taxRate% tax is $wordsWithTax"
    }
}