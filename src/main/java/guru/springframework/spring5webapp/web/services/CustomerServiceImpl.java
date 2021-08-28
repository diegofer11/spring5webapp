package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.web.model.CustomerDto;
import guru.springframework.spring5webapp.web.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("producto de prueba")
                .build();
    }
}
