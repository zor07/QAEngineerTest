package com.zor07;

import com.zor07.domain.TestCase;
import com.zor07.domain.TestPlan;
import com.zor07.repositories.TestCaseRepository;
import com.zor07.repositories.TestPlanRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositoryTest {
    private TestCaseRepository testCaseRepository;
    private TestPlanRepository testPlanRepository;
    private TestCase testCase;
    private TestPlan testPlan;

    /*
     * TestCase
     * ID
     * TestPlan ID
     * Description
     * Steps
     * ExpectedResult
     * ActualResult
     * Passed
     */
    @Autowired
    public void setTestCaseRepository(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Autowired
    public void setTestPlanRepository(TestPlanRepository testPlanRepository) {
        this.testPlanRepository = testPlanRepository;
    }

    @Before
    public void setTestCaseAndTestPlan(){
       initialize();
    }

    public void initialize(){
        //setup TestCase
        testPlan = new TestPlan();

        Set<TestCase> testCases = new HashSet<TestCase>(){
            {
                for (int i = 0; i < 10; i++) {
                    //setup TestCase

                    TestCase tc = new TestCase();
                    tc.setTestPlan(testPlan);
                    tc.setDescription("description" + i);
                    tc.setSteps("1+2+3+4");
                    tc.setExpectedResult("Expected Result " + i);
                    tc.setActualResult("Actual Result " + i);

                    if (i == 0) testCase = tc;
                }
            }
        };

        testPlan.setDescription("Test Plan Description");
        testPlan.setTestCases(testCases);
    }

    @After
    public void erase(){
        testCase = null;
        testPlan = null;
    }

    @Test
    public void testSaveTestPlan(){
        //save testPlan, verify has ID value after save
        assertNull(testPlan.getId()); //null before save
        testPlanRepository.save(testPlan);
        assertNotNull(testPlan.getId()); //not null after save
    }

    @Test
    public void testSaveTestCase(){
        //save testCase, verify has ID value after save
        assertNull(testCase.getId()); //null before save
        testPlanRepository.save(testPlan); // if not save testPlan, then TransientObjectException will be thrown, as testPlan has not id yet
        testCaseRepository.save(testCase);
        assertNotNull(testCase.getId()); //not null after save
    }

    @Test
    public void testGetTestPlan(){
        testPlanRepository.save(testPlan);
        TestPlan fetchedTestPlan = testPlanRepository.findOne(testPlan.getId());
        assertNotNull(fetchedTestPlan);
        assertEquals(fetchedTestPlan.getId(), testPlan.getId());
        assertEquals(fetchedTestPlan.getDescription(), testPlan.getDescription());
    }

    @Test
    public void testGetTestCase(){
        testPlanRepository.save(testPlan);
        testCaseRepository.save(testCase);

        TestCase fetchedTestCase = testCaseRepository.findOne(testCase.getId());
        assertNotNull(fetchedTestCase);
        assertEquals(fetchedTestCase.getId(), testCase.getId());
        assertEquals(fetchedTestCase.getDescription(), testCase.getDescription());
    }

    @Test
    public void testUpdateTestPlan(){
        testPlanRepository.save(testPlan);
        TestPlan fetchedTestPlan = testPlanRepository.findOne(testPlan.getId());
        fetchedTestPlan.setDescription("New Description");
        testPlanRepository.save(fetchedTestPlan);

        TestPlan updated = testPlanRepository.findOne(fetchedTestPlan.getId());
        assertEquals(fetchedTestPlan.getDescription(), updated.getDescription());

    }

    @Test
    public void testUpdateTestCase(){
        testPlanRepository.save(testPlan);
        testCaseRepository.save(testCase);
        TestCase fetchedTestCase = testCaseRepository.findOne(testCase.getId());
        fetchedTestCase.setDescription("New Description");
        testCaseRepository.save(fetchedTestCase);

        TestCase updated = testCaseRepository.findOne(fetchedTestCase.getId());
        assertEquals(fetchedTestCase.getDescription(), updated.getDescription());
    }




}
