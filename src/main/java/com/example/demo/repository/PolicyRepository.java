package com.example.demo.repository;

import com.example.demo.model.Policy;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    Policy findByPolicyNumber(String policyNumber);

    List<Policy> findByUser(User user);
}
