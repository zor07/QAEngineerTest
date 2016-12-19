package com.zor07.services.appium;

import com.zor07.domain.TestCase;
import com.zor07.domain.TestPlan;
import com.zor07.services.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Iterator;

@Service
public class AppiumTest extends AppiumSetup{

    private TestCaseService testCaseService;

    @Autowired
    public void setTestCaseService(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    public void runTestPlan(TestPlan testPlan){
        HashSet<TestCase> testCases = new HashSet<>(testPlan.getTestCases());
        Iterator<TestCase> iterator = testCases.iterator();
        while (iterator.hasNext()){
            TestCase testCase = iterator.next();
            runTestCase(testCase);
        }

    }

    public void runTestCase(TestCase testCase){
        try {
            prepareAndroidForAppium();
            String[] steps = testCase.getSteps().replaceAll(" ", "").split("");
            for (String step : steps){
                controls.get(step).click();
            }
            testCase.setActualResult(controls.get("result").getText());
            testCaseService.save(testCase);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }

}
