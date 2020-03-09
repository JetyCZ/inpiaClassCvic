package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> findByEmail(String email) {
        List<User> users = jdbcTemplate.query(
"select * from user where email=?",
(rs, i) -> {
    User u = new User();
    u.setId(rs.getLong("id"));
    u.setEmail(rs.getString("email"));
    u.setPasswordHash(
        rs.getString("password_hash"));
    return u;
}, new Object[] {email});
        return users;
    }
}
