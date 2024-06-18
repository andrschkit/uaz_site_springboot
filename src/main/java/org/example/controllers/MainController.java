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
        return "projects_repair";
    }
    @GetMapping(URL_PROJECTS_EXPLOITATION)
    public String projectsExploitationPage(Model model) {
        return "projects_exploitation";
    }
    @GetMapping(URL_LICENSES)
    public String licensesPage(Model model) {
        return "licenses";
    }
    @GetMapping(URL_CERTIFICATES)
    public String certificatesPage(Model model) {
        return "certificates";
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
    //about
    @GetMapping(URL_ABOUT_HISTORY)
    public String aboutHistoryPage(Model model) {
        return "about/history";
    }
    @GetMapping(URL_ABOUT_ADVANTAGE)
    public String aboutAdvantagePage(Model model) {
        return "about/advantage";
    }
    @GetMapping(URL_ABOUT_DOCUMENTS)
    public String aboutDocumentsPage(Model model) {
        return "about/documents";
    }
    @GetMapping(URL_ABOUT_OHRANA_TRUDA)
    public String aboutOhranaTrudaPage(Model model) {
        return "about/ohrana_truda";
    }
    @GetMapping(URL_ABOUT_PROVIDERS)
    public String aboutProvidersPage(Model model) {
        return "about/providers";
    }
    @GetMapping(URL_ABOUT_QUALITY)
    public String aboutQualityPage(Model model) {
        return "about/quality";
    }
    @GetMapping(URL_ABOUT_SOCIAL)
    public String aboutSocialPage(Model model) {
        return "about/social";
    }
    @GetMapping(URL_ABOUT_VACANCIES)
    public String aboutVacanciesPage(Model model) { return "about/vacancies"; }
    //projects
    @GetMapping(URL_PROJECT_REPAIR_GORKIY_PARK)
    public String projectRepairGorkiyPark(Model model) {
        return "projects/repair/gorkiy_park";
    }
    @GetMapping(URL_PROJECT_REPAIR_CMT)
    public String projectRepairCMT(Model model) {
        return "projects/repair/cmt";
    }
    @GetMapping(URL_PROJECT_REPAIR_KALUZHSKAYA)
    public String projectRepairKaluzhkaya(Model model) {
        return "projects/repair/kaluzhskaya";
    }
    @GetMapping(URL_PROJECT_REPAIR_KITAI_SECOND_FLOOR)
    public String projectRepairKitaiSecondFloor(Model model) {
        return "projects/repair/kitai_second_floоr";
    }
    @GetMapping(URL_PROJECT_REPAIR_KITAI_DEMONTAZH)
    public String projectRepairKitaiDemontazh(Model model) {
        return "projects/repair/kitai_demontazh";
    }
    @GetMapping(URL_PROJECT_REPAIR_DEDAL)
    public String projectRepairDedal(Model model) {
        return "projects/repair/dedal";
    }
    @GetMapping(URL_PROJECT_REPAIR_REP)
    public String projectRepairRep(Model model) {
        return "projects/repair/rep";
    }
    @GetMapping(URL_PROJECT_REPAIR_NAGAT_UAZ)
    public String projectRepairNagatUaz(Model model) { return "projects/repair/nagat_uaz"; }
    @GetMapping(URL_PROJECT_REPAIR_TECHNOPARK)
    public String projectRepairTechnopark(Model model) { return "projects/repair/technopark"; }
    //projects exploitation
    @GetMapping(URL_PROJECT_REPAIR_KROVLIA)
    public String projectExploitationKrovlia(Model model) { return "projects/repair/krovlia"; }
    @GetMapping(URL_PROJECT_REPAIR_SPORT)
    public String projectExploitationSport(Model model) {
        return "projects/repair/sport";
    }
    @GetMapping(URL_PROJECT_REPAIR_HALL)
    public String projectExploitationHall(Model model) {
        return "projects/repair/hall";
    }
    @GetMapping(URL_PROJECT_REPAIR_MEDPUNKT)
    public String projectExploitationMedpunkt(Model model) {
        return "projects/repair/medpunkt";
    }
    @GetMapping(URL_PROJECT_REPAIR_FASAD)
    public String projectExploitationFasad(Model model) {
        return "projects/repair/fasad";
    }
    @GetMapping(URL_PROJECT_EXPLOITATION_KITAY)
    public String projectExploitationKitay(Model model) {
        return "projects/exploitation/kitay";
    }
    @GetMapping(URL_PROJECT_EXPLOITATION_VDNH)
    public String projectExploitationVdnh(Model model) {
        return "projects/exploitation/vdnh";
    }
    @GetMapping(URL_PROJECT_EXPLOITATION_ORDINKA)
    public String projectExploitationOrdinka(Model model) {
        return "projects/exploitation/ordinka";
    }


}
