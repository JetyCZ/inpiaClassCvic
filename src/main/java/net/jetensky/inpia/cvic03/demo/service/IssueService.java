package net.jetensky.inpia.cvic03.demo.service;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class IssueService {

    private List<Issue> records = new ArrayList<>();

    public void add(Issue issue) {
        records.add(issue);
    }

    public List<Issue> findAll() {
        return records;
    }
}
