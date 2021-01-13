package com.rhm.demo.repositories;

import com.rhm.demo.models.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> findAll();

    void deleteById(Long id);
    List<Song> findByTitleContaining(String search);
    List<Song> findTop10ByOrderByRatingDesc();




}