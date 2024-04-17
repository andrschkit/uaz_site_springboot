package org.example.repositories;

import org.example.domain.MediaPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepo extends JpaRepository<MediaPost, Long> {
    List<MediaPost> findAllByOrderByCreateDateDesc();
    //  Optional<MediaPost> findByIdentificationNumber(String identificationNumber);

}