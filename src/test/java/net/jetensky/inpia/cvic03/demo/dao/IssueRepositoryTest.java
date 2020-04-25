package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.dao.testdata.UserTestDataFactory;
import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(UserTestDataFactory.class)
public class IssueRepositoryTest {

    @Autowired
    IssueRepository issueRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTestDataFactory userTestDataFactory;

    @Test
    public void testAdd() {
        Assertions.assertEquals(0,
                issueRepository.findAll().size());
        Issue issue = new Issue();
        issue.setUrl("www.seznam.cz");

        User user = userTestDataFactory.create();
        issue.setAssignee(user);
        issueRepository.save(issue);
        Assertions.assertEquals(1,
                issueRepository.findAll().size());
    }

}
