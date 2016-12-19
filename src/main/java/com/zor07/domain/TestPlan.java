package com.zor07.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class TestPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String testPlanId;

    private String description;

    @OneToMany(mappedBy = "testPlan", cascade = CascadeType.ALL)
    private Set<TestCase> testCases;

    private Integer testCasesQty;
    private Integer testCasesPassed;
    private Integer testCasesFailed;

    public TestPlan() {
    }

    public String getTestPlanId() {
        return testPlanId;
    }

    public void setTestPlanId(String testPlanId) {
        this.testPlanId = testPlanId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCase> testCases) {
        this.testCases = testCases;
    }

    public Integer getTestCasesQty() {
        return testCasesQty;
    }

    public void setTestCasesQty(Integer testCasesQty) {
        this.testCasesQty = testCasesQty;
    }

    public Integer getTestCasesPassed() {
        return testCasesPassed;
    }

    public void setTestCasesPassed(Integer testCasesPassed) {
        this.testCasesPassed = testCasesPassed;
    }

    public Integer getTestCasesFailed() {
        return testCasesFailed;
    }

    public void setTestCasesFailed(Integer testCasesFailed) {
        this.testCasesFailed = testCasesFailed;
    }

    public void calcStatus(){
        Integer qty = 0,
                qtyPassed = 0,
                qtyFailed = 0;
        if (getTestCases() != null) {
            qty = testCases.size();
            for (TestCase testCase : getTestCases()){
                if (testCase.getStatus() == TestCase.Status.PASSED)
                    qtyPassed++;
                if (testCase.getStatus() == TestCase.Status.FAILED)
                    qtyFailed++;
            }
        }
        testCasesQty = qty;
        testCasesPassed = qtyPassed;
        testCasesFailed = qtyFailed;
    }
}
