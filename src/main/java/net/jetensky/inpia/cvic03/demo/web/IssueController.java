package net.jetensky.inpia.cvic03.demo.web;

import net.jetensky.inpia.cvic03.demo.dto.Issue;
import net.jetensky.inpia.cvic03.demo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IssueController {
    @Autowired
    IssueService issueService;

    @RequestMapping("/")
    @ResponseBody
    public String index(@RequestParam(defaultValue = "Pavel") String name) {
        return "Hello World " + name;
    }

    @RequestMapping(method = RequestMethod.GET, value="/issuereportform")
    public String issueReportForm(Model model) {
        Issue issue = new Issue();
        issue.setUrl("www.seznam.cz");
        issue.setDescription("blabla");
        model.addAttribute("issue", issue);
        return "issues/reportform";
    }

    @PostMapping("/issuereportform")
    public String issueReportFormSubmitted(Issue issue, Model model) {
        issueService.add(issue);
        return "redirect:/issues";
    }

    @GetMapping("/issues")
    public String issues(Model model) {
        model.addAttribute("issues", issueService.findAll());
        return "issues/issuelist";
    }

}
