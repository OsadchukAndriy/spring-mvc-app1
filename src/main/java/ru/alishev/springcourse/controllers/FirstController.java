package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
//        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double sum;
        if (action.equals("addition")) {
            sum = a + b;
        } else if (action.equals("division")) {
            sum = a / (double) b;
        } else if (action.equals("subtraction")) {
            sum = a - b;
        } else if (action.equals("multiplication")) {
            sum = a * b;
        } else sum = 0;

        model.addAttribute("summa", "Sum = " + sum);

        return "first/calculator";

    }
}
