package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.web.model.CustomerDto;
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

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        //TODO crear registro en mongo
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //TODO implementar
    }
}
