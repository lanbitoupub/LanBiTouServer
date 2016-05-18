package top.glimpse.lanbitou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import top.glimpse.lanbitou.data.NoteRepository;
import top.glimpse.lanbitou.domain.Note;


import java.util.List;

/**
 * Created by joyce on 16-5-11.
 */
@Controller
@RequestMapping(value = "/note")
public class NoteController {

    private NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping(value = "/getOne/{id}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Note get(@PathVariable int id) {
        return noteRepository.get(id);
    }

    @RequestMapping(value = "/getAll", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Note> getAll() {
        return noteRepository.getAll();
    }

    @RequestMapping(value = "/postOne", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String postOne(@RequestBody Note note) {
        noteRepository.postOne(note);
        return "posted";
    }
}