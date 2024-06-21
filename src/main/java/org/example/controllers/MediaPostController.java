package org.example.controllers;

import org.example.domain.MediaPost;
import org.example.services.MediaService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.example.StaticString.*;

//TODO нужно привести множество RequestParam
// к одному DTO в методах добавления и редактирования

@Controller
public class MediaPostController {
    private final MediaService mediaService;

    public MediaPostController(MediaService mediaService) {
        this.mediaService = mediaService;
    }
    @GetMapping(URL_ADD_POSTS)
    //@PreAuthorize("hasAnyRole('ADMIN_GET')")
    public String editor(Model model) {
        model.addAttribute("singlePost", new MediaPost());
        return "postEditor/addPost";
    }
    @PostMapping(URL_ADD_POSTS)
    //@PreAuthorize("hasAnyRole('ADMIN_POST')")
    public String save(
            @RequestParam("titleImage") MultipartFile titleImage,
            @RequestParam("title") String title,
            @RequestParam("shortContent") String shortContent,
            @RequestParam("content") String content){
        try{
            mediaService.save(titleImage, title, shortContent, content);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        SecurityContextHolder.clearContext();
        return "redirect:"+URL_NEWS;
    }
    @GetMapping(URL_POST)
    public String singlePost(
            @RequestParam Long postId,
            Model model) {
        MediaPost singlePost=mediaService.findPostById(postId);
        model.addAttribute("singlePost", singlePost);
        return "postEditor/singlePost";
    }

    @GetMapping(URL_EDIT_POSTS)
    //@PreAuthorize("hasAnyRole('ADMIN_GET')")
    public String editPost(
            @RequestParam Long postId,
            Model model) {
        MediaPost singlePost=mediaService.findPostById(postId);
        model.addAttribute("singlePost", singlePost);
        return "postEditor/editPost";
    }
    @PostMapping(URL_EDIT_POSTS)
    //@PreAuthorize("hasAnyRole('ADMIN_GET')")
    public String saveEdit(
            @RequestParam("id") Long postId,
            @RequestParam("titleImage") MultipartFile title_image,
            @RequestParam("title") String title,
            @RequestParam("shortContent") String short_content,
            @RequestParam("content") String content,
            Model model){
        mediaService.saveEdit(postId, title_image, title, short_content, content);
        SecurityContextHolder.clearContext();
        return "redirect:"+URL_NEWS;
    }

}
