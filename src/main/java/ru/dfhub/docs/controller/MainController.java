package ru.dfhub.docs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dfhub.docs.service.PageManager;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private PageManager pageManager;

    @GetMapping("/page/{path}")
    public String page(@PathVariable String path, Model model) {
        try {
            model.addAttribute("content", pageManager.getContent(path + ".md"));
        } catch (IOException e) {
            model.addAttribute("content", "Page not found!"); // TODO: Replace with 404-page
        }
        return "template";
    }
}
