package net.jetensky.inpia.cvic03.demo.dao.testdata;

import net.jetensky.inpia.cvic03.demo.dao.UserRepository;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTestDataFactory {

    @Autowired
    private UserRepository userRepository;

    public User create() {
        User user = new User();
        user.setEmail("pavel.jetensky@seznam.cz");
        user.setPasswordHash("sfasdfasdo");
        userRepository.save(user);
        return user;
    }
}
