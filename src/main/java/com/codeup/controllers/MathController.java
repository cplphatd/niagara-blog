package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by David on 2/7/17.
 */
@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNumbers (@PathVariable int num1, @PathVariable int num2) {
        return Integer.toString(num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtractNumbers (@PathVariable int num1, @PathVariable int num2) {
        return Integer.toString(num1 - num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNumbers (@PathVariable int num1, @PathVariable int num2) {
        return Integer.toString(num1 / num2);
    }

    @GetMapping("/multiply/{num1}/by/{num2}")
    @ResponseBody
    public String multiplyNumbers (@PathVariable int num1, @PathVariable int num2) {
        return Integer.toString(num1 * num2);
    }
}
