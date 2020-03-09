package net.jetensky.inpia.cvic03.demo.web;

import net.jetensky.inpia.cvic03.demo.service.IssueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebMvcTest(IssueController.class)
public class IssueControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private IssueService issueService;
    @Test
    public void loginTest() throws Exception {
        Mockito.when(issueService.findAll())
                .thenReturn(new ArrayList<>());
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        mvc.perform(MockMvcRequestBuilders.get("/issues"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(
                        MockMvcResultMatchers.view()
                                .name("issues/issuelist"));
    }
 }