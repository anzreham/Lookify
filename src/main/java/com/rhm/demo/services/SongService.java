package com.rhm.demo.services;

import com.rhm.demo.models.Song;
import com.rhm.demo.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public
class SongService {
    private final SongRepository songRepository;


    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // returns all the Song
    public List<Song> allSong() {
        return songRepository.findAll();
    }

    public List<Song> findByTitleContaining(String st) {
        return songRepository.findByTitleContaining(st);
    }

    public List<Song> findTop10ByOrderByRatingDesc() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }
    // creates a Song
    public Song createSong(Song b) {
        return songRepository.save(b);
    }
    // retrieves a Song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
     // delete Song
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    //update Song//
    public Song updateSong(Song b) {
        return songRepository.save(b);
    }
}
