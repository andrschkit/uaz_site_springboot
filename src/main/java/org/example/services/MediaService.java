package org.example.services;

import javassist.NotFoundException;
import org.example.domain.MediaPost;
import org.example.repositories.MediaRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {
    private static final String NOT_FOUND_EXCEPTION_PROPERTY = "" ;
    private MediaRepo repo;

    public MediaService(MediaRepo repo) {
        this.repo = repo;
    }

    public void save(MultipartFile title_image, String title, String short_content, String content) {
        MediaPost p = new MediaPost();
        try {
            p.setTitle_image(Base64.getEncoder().encodeToString(title_image.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p.setShort_content(short_content);
        p.setTitle(title);
        p.setContent(content);
        repo.save(p);
    }

    public void saveEdit(Long post_id, MultipartFile title_image, String title, String short_content, String content) {
        MediaPost p = findPropertyById(post_id);
        try {
            if(!title_image.isEmpty()) {
                p.setTitle_image(Base64.getEncoder().encodeToString(title_image.getBytes()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p.setShort_content(short_content);
        p.setTitle(title);
        p.setContent(content);
        repo.save(p);
    }
    public void findEdit(Long post_id, MultipartFile title_image, String title, String short_content, String content) {
        MediaPost p = findPropertyById(post_id);

    }
    public MediaPost findPropertyById(Long postId) {

        try {
            return repo.findById(postId).orElseThrow(() -> new NotFoundException(
                    postId.toString()));
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<MediaPost> findAllPosts() {
        return repo.findAllByOrderByCreateDateDesc();
    }
}
