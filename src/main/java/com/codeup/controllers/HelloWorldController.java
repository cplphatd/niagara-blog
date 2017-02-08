package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by David on 2/7/17.
 */
@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String homePage () {
        return "home";
    }

    @GetMapping("/contact")
    public String contactPage () {
        return "contact/form";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String saySomething () {
        return "Something";
    }

    @GetMapping("/date")
    public String showDate (Model model) {
        model.addAttribute("date", "Feb 7");

        List<String> birthdays = new ArrayList<>();

        birthdays.add("14 May");
        birthdays.add("22 July");
        birthdays.add("26 Nov");
        birthdays.add("14 Jan");
        birthdays.add("25 Jan");

        model.addAttribute("birthdays", birthdays);

        return "date";
    }

    @GetMapping("/roll-dice")
    public String rollDice () {
        return "/roll-dice/roll-dice";
    }

    @GetMapping("/roll-dice/{userGuess}")
    public String checkUserGuess (@PathVariable int userGuess, Model model) {
        int diceRoll = generateRandomNumber();

        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("userGuess", userGuess);

        if (userGuess == diceRoll) {
            model.addAttribute("matchMessage", "You guessed correctly!");
        } else {
            model.addAttribute("matchMessage", "Try again...");
        }

        return "/roll-dice/{userGuess}";
    }

    private int generateRandomNumber () {
        Random random = new Random();

        return random.nextInt(6) + 1;
    }
 }