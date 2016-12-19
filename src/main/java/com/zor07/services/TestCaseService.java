package com.zor07.services;

import com.zor07.domain.TestCase;
import com.zor07.domain.TestPlan;
import com.zor07.repositories.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class TestCaseService implements DomainService<TestCase> {
    private TestCaseRepository testCaseRepository;

    @Autowired
    public void setTestCaseRepository(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public Iterable<TestCase> listAll() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase getById(Integer id) {
        return testCaseRepository.findOne(id);
    }

    @Override
    public TestCase save(TestCase obj) {
        obj.calcStatus();
        return testCaseRepository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        testCaseRepository.delete(id);
    }

    public List<TestCase> listByTestPlan(TestPlan testPlan){

        LinkedList<TestCase> testCases = new LinkedList<>(testCaseRepository.findAll());

        Iterator<TestCase> iterator = testCases.iterator();

        while (iterator.hasNext()){
            TestCase testCase = iterator.next();
            if (!testCase.getTestPlan().getId().equals(testPlan.getId())) iterator.remove();
        }

        return testCases;
    }


}
