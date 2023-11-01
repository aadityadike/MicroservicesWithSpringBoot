package com.aditya.fraud.Service;

import com.aditya.fraud.Repository.FraudRepository;
import com.aditya.fraud.model.FraudCheckHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudRepository fraudRepository;

    public boolean isFradulentCustomer(Integer customerId) {
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .createdAt(LocalDateTime.now())
                        .customerId(customerId)
                        .isFarudster(false)
                        .build()
        );
        return false;
    }
}
