package net.jetensky.inpia.cvic03.demo.service;

import net.jetensky.inpia.cvic03.demo.dao.IssueRepository;
import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import net.jetensky.inpia.cvic03.demo.testutil.Creator;
import net.jetensky.inpia.cvic03.demo.testutil.IssueTestDataFactory;
import net.jetensky.inpia.cvic03.demo.testutil.UserTestDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List

import static net.jetensky.inpia.cvic03.demo.testutil.Creator.save
import static net.jetensky.inpia.cvic03.demo.testutil.Creator.saveMore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueServiceTestGroovy {

    @Autowired
    IssueService issueService;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    Creator creator;


    @Test
    void testDeleteUsersIssues() {
        User assignee = save(new User())
        saveMore(
                new Issue(assignee: assignee),
                new Issue(assignee: assignee))

        Assertions.assertEquals(2, issueRepository.findAll().size());

        issueService.deleteUsersIssues(assignee.id);
        Assertions.assertEquals(0, issueRepository.findAll().size());
    }
}
