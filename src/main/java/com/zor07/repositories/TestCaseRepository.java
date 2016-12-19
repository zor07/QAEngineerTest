package com.zor07.repositories;

import com.zor07.domain.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Integer> {
}
