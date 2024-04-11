package org.example.controllers;

import org.example.domain.MediaPost;
import org.example.services.MediaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;

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
            @RequestParam("title_image") MultipartFile title_image,
            @RequestParam("title") String title,
            @RequestParam("short_content") String short_content,
            @RequestParam("content") String content,
            Model model){
        mediaService.save(title_image, title, short_content, content);
        return "redirect:"+URL_MEDIA;
    }
}
