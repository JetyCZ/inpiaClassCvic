package net.jetensky.inpia.cvic03.demo.testutil;

import net.jetensky.inpia.cvic03.demo.dao.IssueRepository;
import net.jetensky.inpia.cvic03.demo.dao.UserRepository;
import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssueTestDataFactory {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTestDataFactory userTestDataFactory;

    public Issue save() {
        User assignee = userTestDataFactory.create();
        return save(assignee);
    }


    public Issue save(User assignee) {
        Issue issue = new Issue();
        issue.setUrl("www.seznam.cz");
        issue.setAssignee(assignee);
        return issueRepository.save(issue);
    }
}
