package net.jetensky.inpia.cvic03.demo.service

import net.jetensky.inpia.cvic03.demo.dao.IssueRepository
import net.jetensky.inpia.cvic03.demo.dao.testdata.Creator
import net.jetensky.inpia.cvic03.demo.dao.testdata.IssueTestDataFactory
import net.jetensky.inpia.cvic03.demo.dto.Issue
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

import javax.transaction.Transactional

@SpringBootTest
@Transactional
class IssueServiceSpockTest extends Specification{
    @Autowired Creator creator
    @Autowired IssueRepository issueRepository
    @Autowired IssueService issueService

    void deleteUsersIssues() {
        when:
            Issue issue = Creator.save(new Issue());
            def assigneeId = issue.getAssignee().getId();
        then:
            issueRepository.findByAssigneeId(assigneeId).size() == 1

        when:
            issueService.deleteUsersIssues(assigneeId);
        then:
            issueRepository.findByAssigneeId(assigneeId).size() == 0

    }


}
