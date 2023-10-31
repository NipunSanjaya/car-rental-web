package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.DriverDTO;

public interface DriverService {

    public void saveDriver(DriverDTO driverDTO) throws RuntimeException;
}
