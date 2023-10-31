package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.CustomerDTO;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO) throws RuntimeException;
}
