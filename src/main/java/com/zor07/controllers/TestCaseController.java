package com.zor07.controllers;

import com.zor07.domain.TestCase;
import com.zor07.domain.TestPlan;
import com.zor07.services.TestCaseService;
import com.zor07.services.TestPlanService;
import com.zor07.services.appium.AppiumTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestCaseController {
    private TestPlanService testPlanService;
    private TestCaseService testCaseService;
    private AppiumTest appiumTest;


    @Autowired
    public void setTestPlanService(TestPlanService testPlanService) {
        this.testPlanService = testPlanService;
    }

    @Autowired
    public void setTestCaseService(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @Autowired
    public void setAppiumTest(AppiumTest appiumTest) {
        this.appiumTest = appiumTest;
    }

    @RequestMapping("/testplan/{testPlanId}/testcase/{testCaseId}")
    public String showTestCase(@PathVariable Integer testPlanId, @PathVariable Integer testCaseId, Model model){
        model.addAttribute("testplan", testPlanService.getById(testPlanId));
        model.addAttribute("testcase", testCaseService.getById(testCaseId));
        return "testcaseshow";
    }

    @RequestMapping("/testplan/{testPlanId}/testcase/new")
    public String newTestCase(@PathVariable Integer testPlanId, Model model){
        TestPlan testPlan = testPlanService.getById(testPlanId);
        model.addAttribute("testcase", new TestCase(testPlan));
        model.addAttribute("testplan", testPlan);
        return "testcaseform";
    }


    @RequestMapping(value = "/testplan/{testPlanId}/testcases", method = RequestMethod.GET)
    public String list(@PathVariable Integer testPlanId, Model model){
        TestPlan testPlan = testPlanService.getById(testPlanId);
        model.addAttribute("testplan", testPlan);
        model.addAttribute("testcases", testCaseService.listByTestPlan(testPlan));
        return "testcases";
    }

    @RequestMapping(value = "/testplan/{testPlanID}/savetestcase", method = RequestMethod.POST)
    public String saveTestCase(@PathVariable Integer testPlanID, TestCase testCase){
        TestPlan testPlan = testPlanService.getById(testPlanID);
        testCase.setTestPlan(testPlan);
        testCaseService.save(testCase);
        testPlanService.save(testPlan); //to update qty-s
        return "redirect:/testplan/" + testCase.getTestPlan().getId() + "/testcases";
    }

    @RequestMapping("/testplan/{testPlanId}/testcase/edit/{testCaseId}")
    public String edit(@PathVariable Integer testPlanId, @PathVariable Integer testCaseId, Model model){
        model.addAttribute("testplan", testPlanService.getById(testPlanId));
        model.addAttribute("testcase", testCaseService.getById(testCaseId));
        return "testcaseform";
    }

    @RequestMapping("/testplan/{testPlanId}/testcase/delete/{testCaseId}")
    public String delete(@PathVariable Integer testPlanId, @PathVariable Integer testCaseId){

        testCaseService.delete(testCaseId);

        TestPlan testPlan = testPlanService.getById(testPlanId);
        testPlanService.save(testPlan); // to update qty-s
        return "redirect:/testplan/{testPlanId}/testcases";
    }

    @RequestMapping("/testplan/{testPlanId}/testcase/{testCaseId}/run")
    public String run(@PathVariable Integer testPlanId, @PathVariable Integer testCaseId){
        TestCase testCase = testCaseService.getById(testCaseId);
        appiumTest.runTestCase(testCase);

        TestPlan testPlan = testPlanService.getById(testPlanId);
        testPlanService.save(testPlan); // to update qty-s
        return "redirect:/testplan/{testPlanId}/testcases";
    }
}
