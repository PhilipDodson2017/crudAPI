package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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