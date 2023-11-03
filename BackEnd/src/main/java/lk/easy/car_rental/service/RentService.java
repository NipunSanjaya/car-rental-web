package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.CustomerDTO;
import lk.easy.car_rental.dto.RentDTO;
import lk.easy.car_rental.dto.RentDetailDTO;

import java.util.List;

public interface RentService {
    public List<RentDetailDTO> getDriverSchedule(String nic) throws RuntimeException;

    public void requestRent(RentDTO rentDTO) throws RuntimeException;

    public String generateNewRentId() throws RuntimeException;

    public CustomerDTO getCustomerByUsername(String username) throws RuntimeException;

    public void acceptRentRequest(String rentId, String option) throws RuntimeException;

    public RentDTO getRentByRentId(String rentId) throws RuntimeException;

    public List<RentDTO> getRentByNic(String nic) throws RuntimeException;

    public List<RentDTO> getAllRents() throws RuntimeException;
}
