package net.jetensky.inpia.cvic03.demo.dao

import net.jetensky.inpia.cvic03.demo.dto.Issue
import net.jetensky.inpia.cvic03.demo.dto.User
import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import javax.transaction.Transactional

@SpringBootTest
@Transactional
class IssueRepositorySpockTest extends spock.lang.Specification {

    @Autowired IssueRepository issueRepository
    @Autowired UserRepository userRepository
    void testFindAdd() {
        given:
            issueRepository.deleteAll()

        when:
            Issue issue = new Issue()
            issue.setUrl("www.seznam.cz")
            User user = new User()
            user.setEmail("pavel.jetensky@seznam.cz")
            user.setPasswordHash("sfasdfasdo")
            userRepository.save(user)
            issue.setAssignee(user)
            issueRepository.save(issue)


        then: "add should create issue in db"
            issueRepository.findAll().size() == 1

        /*
        when:
            // add new issue

        then:
            // in db there is one record

         */
    }
}
