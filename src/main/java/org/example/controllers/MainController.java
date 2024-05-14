package org.example.controllers;

import org.example.domain.MediaPost;
import org.example.services.MediaService;
import org.example.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.StaticString.*;

@Controller
public class MainController {
    private final MessageService messageService;
    private final MediaService mediaService;

    public MainController(MessageService messageService, MediaService mediaService) {

        this.messageService = messageService;
        this.mediaService = mediaService;
    }

    @GetMapping(URL_MAIN_PAGE)
    public String mainPage(Model model) {
        return "index";
    }
    @GetMapping(URL_ABOUT)
    public String aboutPage(Model model) {
        return "about";
    }
    @GetMapping(URL_SERVICES)
    public String servicesPage(Model model) {
        return "services";
    }
    @GetMapping(URL_PROJECTS_REPAIR)
    public String projectsRepairPage(Model model) {
        return "objects_repair";
    }
    @GetMapping(URL_PROJECTS_EXPLOITATION)
    public String projectsExploitationPage(Model model) {
        return "objects_exploitation";
    }
    @GetMapping(URL_LICENSES)
    public String licensesPage(Model model) {
        return "licenses";
    }
    @GetMapping(URL_NEWS)
    public String mediaPage(Model model) {
        List<MediaPost> postList = new ArrayList<>();
        postList= mediaService.findAllPosts();
        model.addAttribute("posts",
                postList);
        return "news";
    }
    @GetMapping(URL_MEDIA_CENTER)
    public String mediaCenterPage(Model model) {
        return "mediacenter";
    }
    @GetMapping(URL_CONTACTS)
    public String contactsPage(Model model) {
        return "contacts";
    }

    //articles
    @GetMapping(URL_SERVICES_TECHNICAL_SERVICE)
    public String technicalServicePage(Model model) {
        return "services/technical_service";
    }
    @GetMapping(URL_SERVICES_TECHNICAL_EVENTS)
    public String technicalEventsPage(Model model) {
        return "services/technical_events";
    }
    @GetMapping(URL_SERVICES_EXPLOITATION)
    public String exploitationPage(Model model) {
        return "services/exploitation";
    }
    @GetMapping(URL_SERVICES_CLEANING)
    public String cleaningPage(Model model) {
        return "services/cleaning";
    }
    @GetMapping(URL_SERVICES_BUILDING)
    public String buildingPage(Model model) {
        return "services/building";
    }
    @GetMapping(URL_HISTORY)
    public String historyPage(Model model) {
        return "history";
    }
    @GetMapping(URL_PROJECT_ORDINKA)
    public String projectOrdinkaPage(Model model) {
        return "projects/ordinka";
    }
    @GetMapping(URL_PROJECT_KITAY)
    public String projectKitayPage(Model model) {
        return "projects/kitay";
    }
    @GetMapping(URL_PROJECT_VDNH)
    public String projectVdnhPage(Model model) {
        return "projects/vdnh";
    }
    @GetMapping(URL_PROJECT_MONETKA)
    public String projectMonetkaPage(Model model) {
        return "projects/monetka";
    }

}
