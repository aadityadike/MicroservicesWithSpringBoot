package com.aditya.fraud.Repository;

import com.aditya.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
