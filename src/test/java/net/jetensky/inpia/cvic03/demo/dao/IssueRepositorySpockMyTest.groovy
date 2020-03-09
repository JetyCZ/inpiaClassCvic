package net.jetensky.inpia.cvic03.demo.dao;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.dto.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class IssueRepositorySpockMyTest extends Specification {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private UserRepository userRepository;

    void "add"() {
        when:
        issueRepository.deleteAll()
        Issue issue = new Issue(url:"url")
        User user = new User(
                email:"pavel.jetensky@seznam.cz",
                passwordHash: "blabla")
        userRepository.save(user);
        issue.setUser(user);
        issueRepository.save(issue);

        then:
            issueRepository.findAll().size() == 1
    }
}