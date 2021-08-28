package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
