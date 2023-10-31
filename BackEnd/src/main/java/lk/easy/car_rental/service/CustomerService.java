package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO) throws RuntimeException;

    public List<CustomerDTO> getAllCustomer() throws RuntimeException;
}
