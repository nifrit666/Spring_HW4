package ru.geekbrains.ProjectHW4Spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.ProjectHW4Spring.Domain.Input;

@Controller
public class MyController {

    @GetMapping("/")
    public String home(Model model) {
        String message1 = "Урок 4. Spring MVC. Использование шаблонизатора Thymeleaf";
        String message2 = "Список пользователей из базы данных: http://localhost:8080/task2";
        String message3 = "Вывод страницы с результатом: http://localhost:8080/task3";
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("message3", message3);
        return "home";
    }

    @GetMapping("/task2")
    public String task2(Model model) {
        model.addAttribute("name", "Марлон");
        model.addAttribute("lastName", "Брандо");
        return "task2Page";
    }

    @GetMapping("/task3")
    public String form(Model model) {
        model.addAttribute("input", new Input());
        return "task3";
    }

    @PostMapping("/task3")
    public String formSubmit(@RequestParam String input, Model model) {
        model.addAttribute("input", input);
        return "result";
    }
}

