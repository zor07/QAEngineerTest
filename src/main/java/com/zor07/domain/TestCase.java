package com.zor07.domain;

import javax.persistence.*;

@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "test_plan_id")
    private TestPlan testPlan;

    private String testCaseId;

    private String description;
    private String steps;
    private String expectedResult;
    private String actualResult;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        DIDNTRUN,
        PASSED,
        FAILED
    }

    public TestCase() {
    }

    public TestCase(TestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(TestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
        this.actualResult = null;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void calcStatus(){
        if (actualResult == null)
            setStatus(Status.DIDNTRUN);
        else if (actualResult.equals(expectedResult))
            setStatus(Status.PASSED);
        else
            setStatus(Status.FAILED);
    }
}
