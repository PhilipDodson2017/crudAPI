package com.example.demo.controller;



import java.util.ArrayList;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    public CustomerController customerController;

    @Mock
    public CustomerRepository customerRepository;

    @Test
    public void testSayHello()  {

        customerController.sayHello();

    }

    @Test
    public void testGetAllCustomersCustomer() {

        Mockito.when(customerRepository.findAll()).thenReturn(new ArrayList<Customer>());

        customerController.getAllCustomers();

    }

    // @Test
    // public void testCreateCustomer() {

    //     Customer customer = new Customer(
    //         1L,
    //         "John",
    //         "A.",
    //         "Doe",
    //         "john.doe@example.com",
    //         "123-456-7890"
    //     );
        

    //     Mockito.when(customerController.createCustomer(Mockito.any())).thenReturn(ResponseEntity.ok(customer));

    //     customerController.getAllCustomers();
    // }
}