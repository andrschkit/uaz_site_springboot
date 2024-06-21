package org.example.services;

import org.example.domain.MediaPost;
import org.example.exceptions.NotFoundException;
import org.example.repositories.MediaRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static org.example.StaticString.NOT_FOUND_EXCEPTION_POST;

@Service
public class MediaService {
    private final MediaRepo repo;

    public MediaService(MediaRepo repo) {
        this.repo = repo;
    }

    public void save(MultipartFile titleImage, String title, String short_content, String content) throws IOException {
        MediaPost p = new MediaPost(title, content, titleImage, short_content);
        repo.save(p);
    }

    public void saveEdit(Long post_id, MultipartFile titleImage, String title, String short_content, String content) {
        MediaPost p = findPostById(post_id);
        if(!titleImage.isEmpty())
            try {
                p.setTitleImage(titleImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        p.setShortContent(short_content);
        p.setTitle(title);
        p.setContent(content);
        repo.save(p);
    }
    public void findEdit(Long postId, MultipartFile titleImage, String title, String shortContent, String content) {
        MediaPost p = findPostById(postId);
    }
    public MediaPost findPostById(Long postId) {
        return repo.findById(postId).orElseThrow(() -> new NotFoundException( NOT_FOUND_EXCEPTION_POST,
                    postId.toString()));
    }
    public List<MediaPost> findAllPosts() {
        return repo.findAllByOrderByCreateDateDesc();
    }
}
