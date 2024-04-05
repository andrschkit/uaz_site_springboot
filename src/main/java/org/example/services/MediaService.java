package org.example.services;

import org.example.domain.MediaPost;
import org.example.repositories.MediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {
    private MediaRepo repo;

    public MediaService(MediaRepo repo) {
        this.repo = repo;
    }

    public void save(MediaPost media) {
        repo.save(media);
    }

    public List<MediaPost> findAllPosts() {
        return repo.findAll();
    }
}
