package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.domain.Message;
import org.example.services.MessageRepo;

import static org.example.StaticString.*;
@Controller
public class MainController {
    private final MessageRepo messageRepo;

    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

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

    @PostMapping("/add")
    public String add( @RequestParam String name, @RequestParam String phone_number,
                      @RequestParam String mail, @RequestParam String msg, Model model) {
        Message message = new Message(name, phone_number, mail, msg);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);

        return "index";
    }

}
