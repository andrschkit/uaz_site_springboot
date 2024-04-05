package org.example.controllers;

import org.example.domain.MediaPost;
import org.example.services.MediaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.example.StaticString.*;

@Controller
@RequestMapping({URL_POST})
public class MediaPostController {
    private final MediaService mediaService;

    public MediaPostController(MediaService mediaService) {
        this.mediaService = mediaService;
    }
    @GetMapping
    public String editor(Model model) {
        model.addAttribute("post", new MediaPost());
        return "editor";
    }
    @PostMapping
    public String save(
            @Valid @ModelAttribute(name = "post") MediaPost post,
            Model model){
        model.addAttribute("post", post);
        mediaService.save(post);
        return "redirect:"+URL_MEDIA;
    }
}
