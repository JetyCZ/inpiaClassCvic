package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.testutil.IssueTestDataFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(IssueTestDataFactory.class)
public class IssueRepositoryTest {

    @Autowired
    IssueRepository issueRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    IssueTestDataFactory issueTestDataFactory;

    @Test
    public void testAdd() {
        Assertions.assertEquals(0,
                issueRepository.findAll().size());

        issueTestDataFactory.save();

        Assertions.assertEquals(1,
                issueRepository.findAll().size());
    }


}
