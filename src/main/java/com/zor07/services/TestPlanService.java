package com.zor07.services;

import com.zor07.domain.TestPlan;
import com.zor07.repositories.TestPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPlanService implements DomainService<TestPlan> {
    private TestPlanRepository testPlanRepository;

    @Autowired
    public void setTestPlanRepository(TestPlanRepository testPlanRepository){
        this.testPlanRepository = testPlanRepository;
    }

    @Override
    public Iterable<TestPlan> listAll() {
        return testPlanRepository.findAll();
    }

    @Override
    public TestPlan getById(Integer id) {
        return testPlanRepository.findOne(id);
    }

    @Override
    public TestPlan save(TestPlan obj) {
        obj.calcStatus();
        return testPlanRepository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        testPlanRepository.delete(id);
    }

}
