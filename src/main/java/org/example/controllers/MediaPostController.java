package org.example.controllers;

import org.example.domain.MediaPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.example.StaticString.*;

@Controller
@RequestMapping({URL_POST})
public class MediaPostController {
    @GetMapping()
    public String editor(Model model) {
        model.addAttribute("post", new MediaPost());
        return "editor";
    }
    @PostMapping
    public String save(MediaPost post, Model model){
        model.addAttribute("post", post);
        return "media";
    }
}
