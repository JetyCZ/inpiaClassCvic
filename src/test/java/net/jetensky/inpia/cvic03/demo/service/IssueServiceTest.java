package net.jetensky.inpia.cvic03.demo.service;

import net.jetensky.inpia.cvic03.demo.dao.IssueRepository;
import net.jetensky.inpia.cvic03.demo.dao.testdata.Creator;
import net.jetensky.inpia.cvic03.demo.dao.testdata.IssueTestDataFactory;
import net.jetensky.inpia.cvic03.demo.dto.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
// @Import(IssueTestDataFactory.class)
public class IssueServiceTest {
    @Autowired
    Creator creator;

    @Autowired
    IssueTestDataFactory issueTestDataFactory;

    @Autowired
    IssueService issueService;

    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void testAdd() {
        issueService.add(new Issue());
        issueService.add(new Issue());
        List<Issue> result = issueService.findAll();
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void deleteUsersIssues() {
        Issue issue = issueTestDataFactory.create();

        Long assigneeId = issue.getAssignee().getId();

        Assertions.assertEquals(1, issueRepository.findByAssigneeId(assigneeId).size());
        issueService.deleteUsersIssues(assigneeId);
        Assertions.assertEquals(0, issueRepository.findByAssigneeId(assigneeId).size());

    }

    @Test
    public void deleteUsersIssuesCreator() {
        Issue issue = (Issue) Creator.save(new Issue());

        Long assigneeId = issue.getAssignee().getId();

        Assertions.assertEquals(1, issueRepository.findByAssigneeId(assigneeId).size());
        issueService.deleteUsersIssues(assigneeId);
        Assertions.assertEquals(0, issueRepository.findByAssigneeId(assigneeId).size());


    }

}
