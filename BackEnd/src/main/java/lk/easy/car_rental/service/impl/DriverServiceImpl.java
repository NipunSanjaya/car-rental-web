package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.DriverDTO;
import lk.easy.car_rental.entity.Driver;
import lk.easy.car_rental.repo.DriverRepo;
import lk.easy.car_rental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) throws RuntimeException {
        Driver driver = mapper.map(driverDTO, Driver.class);

        if (driverRepo.existsById(driverDTO.getNic())) throw new RuntimeException("Customer Already Exits..!");


        driver.setAvailabilityStatus("YES");
        driver.getUser().setRole("Driver");

        driverRepo.save(driver);
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) throws RuntimeException {

        Driver driver = mapper.map(driverDTO, Driver.class);

        if (!driverRepo.existsById(driverDTO.getNic())) throw new RuntimeException("Invalid Driver..!");

        Driver driver1 = driverRepo.findById(driverDTO.getNic()).get();

        driver.setLicenseImage(driver1.getLicenseImage());

        driver.setAvailabilityStatus("YES");
        driver.getUser().setRole("Driver");

        driverRepo.save(driver);
    }
}
