package com.rhm.demo.contollers;
import com.rhm.demo.models.Song;
import com.rhm.demo.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class SongsApi {
    private final SongService songService;

    public SongsApi(SongService bookService, SongService songService){
        this.songService = songService;

    }



    @GetMapping("/")
    public String home() {

        return "home";
    }
    @GetMapping("/songs")
    public String index(Model model) {
        List<Song> songs = songService.allSong();
        for (Song var : songs)
        {
            System.out.println(var.getTitle());
        }
        model.addAttribute("songs", songs);
        return "index";
    }
    @GetMapping("/songs/byorder")
    public String byOrder(Model model) {
        List<Song> songs = songService.findTop10ByOrderByRatingDesc();
        for (Song var : songs)
        {
            System.out.println(var.getTitle());
        }
        model.addAttribute("songs", songs);
        return "index3";
    }
    @RequestMapping(value="/songs/search", method=RequestMethod.POST)
    public String Searchindex(Model model, @RequestParam(value="st") String st ) {
        List<Song> songs = songService.findByTitleContaining(st);
        for (Song var : songs)
        {
            System.out.println(var.getTitle());
        }
        model.addAttribute("songs", songs);
        return "index2";
    }


    @RequestMapping("/song/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "show";
    }

    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }


    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/edit";
    }
    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit";
        } else {
            songService.updateSong(song);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
           return "/songs/new";
        } else {
            songService.createSong(song);


            return "redirect:/songs";
        }
    }

    @GetMapping("/songs/new")
    public String newbook(@ModelAttribute("song") Song song) {

        return "new";
    }
}


















