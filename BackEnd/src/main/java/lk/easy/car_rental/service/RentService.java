package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.RentDetailDTO;

import java.util.List;

public interface RentService {
    public List<RentDetailDTO> getDriverSchedule(String nic) throws RuntimeException;
}
