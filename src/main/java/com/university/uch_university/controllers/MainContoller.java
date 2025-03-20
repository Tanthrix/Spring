package com.university.uch_university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainContoller {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Maksim");
        return "homePage";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator,
                            Model model) {
        double result = switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> operand1 / operand2;
            case "*" -> operand1 * operand2;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("fromCurrency") String fromCurrency,
                          @RequestParam("toCurrency") String toCurrency,
                          @RequestParam("amount") double amount,
                          Model model) {

        String key = fromCurrency + "_" + toCurrency;

        double conversionRate = switch (key) {
            case "USD_EUR" -> 0.90;
            case "USD_RUB" -> 95.0;
            case "EUR_USD" -> 1.07;
            case "EUR_RUB" -> 106.0;
            case "RUB_USD" -> 0.009;
            case "RUB_EUR" -> 0.01;
            default -> 1.0;
        };

        double result = amount * conversionRate;

        model.addAttribute("result", result);
        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        model.addAttribute("amount", amount);

        return "conversionResult";
    }

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @GetMapping("/converter")
    public String converter(Model model) {
        model.addAttribute("currencies", new String[]{"USD", "EUR", "RUB"});
        return "converter";
    }
}
