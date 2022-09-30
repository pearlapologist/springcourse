package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String byePage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname, Model model) {
        model.addAttribute("msg", "Bye, " + name + " " + surname);
        // System.out.println("Bye, "+name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam("a") int a, @RequestParam("b") int b,
                       @RequestParam("action") String action, Model model
    ) {
        double res;
        switch (action) {
            case "multiplication":
                res = a * b;
                break;
            case "division":
                res = a / (double) b;
                break;
            case "substraction":
                res = a - b;
                break;
            case "addition":
                res = a + b;
                break;
            default:
                res = 0;
                break;
        }
        model.addAttribute("result", res);
        return "first/calculator";
    }
}
