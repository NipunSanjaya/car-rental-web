package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.DriverDTO;
import lk.easy.car_rental.dto.DriverSpDTO;
import lk.easy.car_rental.entity.Driver;
import lk.easy.car_rental.repo.DriverRepo;
import lk.easy.car_rental.service.DriverService;
import lk.easy.car_rental.util.CurrentUserUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public DriverDTO getDriver() throws RuntimeException {
        return mapper.map(driverRepo.getDriverByUsername(CurrentUserUtil.currentUser.getUsername()), DriverDTO.class);

    }

    @Override
    public List<DriverDTO> getAllDrivers() throws RuntimeException {
        return mapper.map(driverRepo.findAll(), new TypeToken<ArrayList<DriverSpDTO>>() {
        }.getType());
    }

    @Override
    public Long countAvailableDrivers() throws RuntimeException {
        return driverRepo.countAvailableDrivers();
    }

    @Override
    public Long countReservedDrivers() throws RuntimeException {
        return driverRepo.countReservedDrivers();
    }

    @Override
    public void deleteDriver(String nic) throws RuntimeException {
        if (!driverRepo.existsById(nic)) throw new RuntimeException("Invalid Driver..!");
        driverRepo.deleteById(nic);
    }
}
