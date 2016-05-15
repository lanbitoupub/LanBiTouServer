package top.glimpse.lanbitou.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.glimpse.lanbitou.domain.Note;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by joyce on 16-5-11.
 */
@Repository
public class NoteJdbcRepository implements NoteRepository{

    private static final String SELECT_NOTE_BY_ID = "select * from note where nid = ?";
    private JdbcOperations jdbcOperations;

    @Autowired
    public NoteJdbcRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public boolean addNote(Note note) {
        return false;
    }

    @Override
    public Note get(int id) {
        return jdbcOperations.queryForObject(
                SELECT_NOTE_BY_ID,
                new NoteRowMapper(), id);
    }

    private static class NoteRowMapper implements RowMapper<Note> {
        public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Note(
                    rs.getInt("nid"),
                    rs.getInt("uid"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("notebook"),
                    rs.getDate("created_at"));
        }
    }

}
