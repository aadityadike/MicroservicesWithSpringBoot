package com.aditya.fraud.Controller;

import com.aditya.fraud.Service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customer_id}")
    public FraudCheckResponse isFraudster(@PathVariable("customer_id") Integer Customer_id) {
        boolean isFradulentCustomer = fraudCheckService.isFradulentCustomer(Customer_id);
        log.info("fraud check request for customer{}", Customer_id);
        return new FraudCheckResponse(isFradulentCustomer);
    }
}
