package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.CustomerDTO;
import lk.easy.car_rental.entity.Customer;
import lk.easy.car_rental.repo.CustomerRepo;
import lk.easy.car_rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) throws RuntimeException {
        if (customerRepo.existsById(customerDTO.getNic())) throw new RuntimeException("Customer Already Exits..!");
        customerDTO.getUser().setRole("Customer");
        customerRepo.save(mapper.map(customerDTO, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws RuntimeException {
        return mapper.map(customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void deleteCustomer(String nic) throws RuntimeException {

        if (!customerRepo.existsById(nic)) throw new RuntimeException("Invalid Customer..!");
        customerRepo.deleteById(nic);

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) throws RuntimeException {
        if (customerRepo.existsById(customerDTO.getNic()))throw new RuntimeException("Invalid Customer..!");
        Customer customer = mapper.map(customerDTO, Customer.class);
        Customer customer1 = customerRepo.findById(customerDTO.getNic()).get();
        customer.setLicenseImage(customer1.getLicenseImage());
        customer.setNicImage(customer1.getNicImage());
        customer.getUser().setRole("Customer");
        customerRepo.save(customer);
    }

    @Override
    public Long countCustomers() throws RuntimeException {
        return customerRepo.countCustomerByNic();
    }
}
