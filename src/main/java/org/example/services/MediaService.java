package org.example.services;

import org.example.domain.MediaPost;
import org.example.repositories.MediaRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class MediaService {
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

    public List<MediaPost> findAllPosts() {
        return repo.findAll();
    }
}
