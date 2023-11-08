package org.example.controllers;

import org.example.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.domain.Message;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Optional;

import static org.example.StaticString.*;
import static org.example.controllers.ControllerUtils.getPreviousPageByRequest;

@Controller
public class MainController {
    private final MessageService messageService;

    public MainController(MessageService messageService) {

        this.messageService = messageService;
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
    public String add(
            HttpServletRequest request,
            @Valid @ModelAttribute Message message,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return getPreviousPageByRequest(request).orElse("/"); //else go to home page
        } else {
            messageService.save(message);
            return "redirect:/";
        }
        /*Iterable<Message> messages = messageService.findAll();

        model.addAttribute("messages", messages);*/
    }

}
