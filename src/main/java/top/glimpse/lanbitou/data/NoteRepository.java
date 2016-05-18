package top.glimpse.lanbitou.data;

import top.glimpse.lanbitou.domain.Note;

import java.util.List;

/**
 * Created by joyce on 16-5-11.
 */
public interface NoteRepository {
    boolean addNote(Note note);
    boolean updateNote(Note note);
    Note get(int id);
    List<Note> getAll();
    void postOne(Note note);
}