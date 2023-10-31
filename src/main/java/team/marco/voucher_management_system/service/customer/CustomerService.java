package team.marco.voucher_management_system.service.customer;

import org.springframework.stereotype.Service;
import team.marco.voucher_management_system.domain.customer.Customer;
import team.marco.voucher_management_system.repository.custromer.CustomerRepository;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomer(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }
}