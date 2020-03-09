package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private UserRepository userRepository;

    @Test

    public void test() {
        Assert.assertEquals(
        	issueRepository.findAll().size(), 0);
        Issue issue = new Issue();
        issue.setUrl("url");
        User user = new User();
        user.setEmail("pavel.jetensky@seznam.cz");
        user.setPasswordHash("passwordHash");
        userRepository.save(user);

        issue.setUser(user);
        issueRepository.save(issue);
        Assert.assertEquals(
        	issueRepository.findAll().size(), 1);
    }
}