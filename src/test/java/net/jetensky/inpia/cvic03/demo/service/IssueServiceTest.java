package net.jetensky.inpia.cvic03.demo.service;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IssueServiceTest {
    @Test
    public void testAdd() {
        IssueService issueService = new IssueService();
        issueService.add(new Issue());
        issueService.add(new Issue());
        List<Issue> result = issueService.findAll();
        Assert.assertEquals(2, result.size());
    }
}
