package net.jetensky.inpia.cvic03.demo.dao.testdata;

import net.jetensky.inpia.cvic03.demo.dao.IssueRepository;
import net.jetensky.inpia.cvic03.demo.dao.testdata.UserTestDataFactory;
import net.jetensky.inpia.cvic03.demo.dto.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssueTestDataFactory {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserTestDataFactory userTestDataFactory;

    public Issue create() {
        Issue issue = new Issue();
        issue.setAssignee(userTestDataFactory.create());
        issue.setUrl("www.seznam.cz");
        issue.setDescription("test description");
        issueRepository.save(issue);
        return issue;
    }
}
