package top.glimpse.lanbitou.data;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * Created by Henvealf on 16-5-14.
 */
public class UserJdbcRepository implements UserRepository{

    private JdbcOperations jdbcOperations;

    public UserJdbcRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }
}
