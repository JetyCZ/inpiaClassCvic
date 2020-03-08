package net.jetensky.inpia.cvic03.demo;

import net.jetensky.inpia.cvic03.demo.web.IssueController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    IssueController issueController;


    @Test
    public void contextLoads() {
        assertNotNull(issueController);
    }
}