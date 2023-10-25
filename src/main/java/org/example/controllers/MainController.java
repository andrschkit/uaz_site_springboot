package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static org.example.StaticString.*;
@Controller
public class MainController {
    @GetMapping(URL_MAIN_PAGE)
    public String mainPage(Model model) {
        return "/index";
    }

    @GetMapping(URL_PROJECTS)
    public String projectsPage(Model model) {
        return "/projects";
    }
    @GetMapping(URL_PROVIDERS)
    public String providersPage(Model model) {
        return "/providers";
    }
    @GetMapping(URL_VACANCIES)
    public String vacanciesPage(Model model) {
        return "/vacancies";
    }
    @GetMapping(URL_MEDIA)
    public String mediaPage(Model model) {
        return "/media";
    }
    @GetMapping(URL_HISTORY)
    public String historyPage(Model model) {
        return "/history";
    }
    @GetMapping(URL_PROJECT_ORDINKA)
    public String projectOrdinkaPage(Model model) {return "/projects/ordinka";}
    @GetMapping(URL_PROJECT_KITAY)
    public String projectKitayPage(Model model) {return "/projects/kitay";}
    @GetMapping(URL_PROJECT_VDNH)
    public String projectVdnhPage(Model model) {
        return "/projects/vdnh";
    }
    @GetMapping(URL_PROJECT_MONETKA)
    public String projectMonetkaPage(Model model) {
        return "/projects/monetka";
    }

}
