package top.glimpse.lanbitou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.glimpse.lanbitou.data.NoteRepository;
import top.glimpse.lanbitou.domain.Note;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @RequestMapping(value = "/get/{id}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Note get(@PathVariable int id) {
        return noteRepository.get(id);
    }
}
