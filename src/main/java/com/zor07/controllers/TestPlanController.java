package com.zor07.controllers;

import com.zor07.domain.TestPlan;
import com.zor07.services.TestPlanService;
import com.zor07.services.appium.AppiumTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestPlanController {
    private TestPlanService testPlanService;
    private AppiumTest appiumTest;

    @Autowired
    public void setTestPlanService(TestPlanService testPlanService) {
        this.testPlanService = testPlanService;
    }

    @Autowired
    public void setAppiumTest(AppiumTest appiumTest) {
        this.appiumTest = appiumTest;
    }

    @RequestMapping("testplan/{id}")
    public String showTestPlan(@PathVariable Integer id, Model model){
        model.addAttribute("testplan", testPlanService.getById(id));
        return "testplanshow";
    }

    @RequestMapping("testplan/new")
    public String newTestPlan(Model model){
        model.addAttribute("testplan", new TestPlan());
        return "testplanform";
    }

    @RequestMapping(value = "testplan", method = RequestMethod.POST)
    public String saveTestPlan(TestPlan testPlan){
        testPlanService.save(testPlan);
        return "redirect:/testplans";
    }

    @RequestMapping(value = "/testplans", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("testplans", testPlanService.listAll());
        return "testplans";
    }

    @RequestMapping("testplan/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("testplan", testPlanService.getById(id));
        return "testplanform";
    }

    @RequestMapping("testplan/delete/{id}")
    public String delete(@PathVariable Integer id){
        testPlanService.delete(id);
        return "redirect:/testplans";
    }

    @RequestMapping("/testplan/{testPlanId}/run")
    public String run(@PathVariable Integer testPlanId){
        TestPlan testPlan =  testPlanService.getById(testPlanId);
        appiumTest.runTestPlan(testPlan);
        testPlanService.save(testPlan); // to update qty-s
        return "redirect:/testplan/{testPlanId}/testcases";
    }
}
