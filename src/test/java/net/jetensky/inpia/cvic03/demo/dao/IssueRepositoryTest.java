package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueRepositoryTest {

    @Autowired
    IssueRepository issueRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testAdd() {
        Assertions.assertEquals(0,
                issueRepository.findAll().size());
        Issue issue = new Issue();
        issue.setUrl("www.seznam.cz");

        User user = new User();
        user.setEmail("pavel.jetensky@seznam.cz");
        user.setPasswordHash("sfasdfasdo");
        userRepository.save(user);
        issue.setAssignee(user);
        issueRepository.save(issue);
        Assertions.assertEquals(1,
                issueRepository.findAll().size());
    }
}
