package top.glimpse.lanbitou.data;

import top.glimpse.lanbitou.domain.Note;

/**
 * Created by joyce on 16-5-11.
 */
public interface NoteRepository {
    boolean addNote(Note note);
    Note get(int id);
}
