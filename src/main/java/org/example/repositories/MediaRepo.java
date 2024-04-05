package org.example.repositories;

import org.example.domain.MediaPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MediaRepo extends JpaRepository<MediaPost, Long> {
  //  Optional<MediaPost> findByIdentificationNumber(String identificationNumber);
}