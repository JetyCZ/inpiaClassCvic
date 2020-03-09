package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
