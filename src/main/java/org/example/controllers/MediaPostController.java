package org.example.controllers;

import org.example.domain.MediaPost;
import org.example.services.MediaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.example.StaticString.*;

@Controller
public class MediaPostController {
    private final MediaService mediaService;

    public MediaPostController(MediaService mediaService) {
        this.mediaService = mediaService;
    }
    @GetMapping(URL_ADD_POSTS)
    public String editor(Model model) {
        model.addAttribute("singlePost", new MediaPost());
        return "addPost";
    }
    @PostMapping(URL_ADD_POSTS)
    public String save(
            @RequestParam("title_image") MultipartFile title_image,
            @RequestParam("title") String title,
            @RequestParam("short_content") String short_content,
            @RequestParam("content") String content){
        mediaService.save(title_image, title, short_content, content);
        return "redirect:"+URL_MEDIA;
    }
    @GetMapping(URL_POST)
    public String singlePost(
            @RequestParam Long postId,
            Model model) {
        MediaPost singlePost=mediaService.findPropertyById(postId);
        model.addAttribute("singlePost", singlePost);
        return "/singlePost";
    }
    @GetMapping(URL_EDIT_POSTS)
    public String editPost(
            @RequestParam Long postId,
            Model model) {
        MediaPost singlePost=mediaService.findPropertyById(postId);
        model.addAttribute("singlePost", singlePost);
        return "/editPost";
    }
    @PostMapping(URL_EDIT_POSTS)
    public String saveEdit(
            @RequestParam("id") Long postId,
            @RequestParam("title_image") MultipartFile title_image,
            @RequestParam("title") String title,
            @RequestParam("short_content") String short_content,
            @RequestParam("content") String content,
            Model model){
        mediaService.saveEdit(postId, title_image, title, short_content, content);
        return "redirect:"+URL_MEDIA;
    }

}
