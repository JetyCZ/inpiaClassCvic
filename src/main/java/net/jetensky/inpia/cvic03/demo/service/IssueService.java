package net.jetensky.inpia.cvic03.demo.service;

import net.jetensky.inpia.cvic03.demo.dao.IssueRepository;
import net.jetensky.inpia.cvic03.demo.dto.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class IssueService {

    @Autowired IssueRepository issueRepository;

    private List<Issue> records = new ArrayList<>();

    public void add(Issue issue) {
        records.add(issue);
    }

    public List<Issue> findAll() {
        return records;
    }

    @Transactional
    public void deleteUsersIssues(Long assigneeId) {
        issueRepository.deleteByAssigneeId(assigneeId);
    }
}
