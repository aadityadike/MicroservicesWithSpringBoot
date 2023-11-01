package com.aditya.customer.Services;

import com.aditya.customer.Config.FraudCheckResponse;
import com.aditya.customer.model.CustomerRegistrationRequest;
import com.aditya.customer.Repository.CustomerRepository;
import com.aditya.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: CHECK IF EMAIL IS VALID

        // TODO: STORE CUSTOMER IN DATABASE
        customerRepository.saveAndFlush(customer);

        // TODO: CHECK IF CUSTOMER IS FRAUDSTER OR NOT
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
