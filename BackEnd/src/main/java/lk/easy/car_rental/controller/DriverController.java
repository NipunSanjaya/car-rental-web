package lk.easy.car_rental.controller;

import lk.easy.car_rental.dto.DriverDTO;
import lk.easy.car_rental.dto.UserDTO;
import lk.easy.car_rental.service.DriverService;
import lk.easy.car_rental.service.RentService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    RentService rentService;

    @PostMapping
    public ResponseUtil saveDriver(@RequestParam String username, @RequestParam String password, @ModelAttribute DriverDTO driverDTO) {

        driverDTO.setUser(new UserDTO(username, password, "Driver"));
        driverService.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Saved..!", "");

    }

    @PostMapping(path = "/update")
    public ResponseUtil updateDriver(@RequestParam String username, @RequestParam String password, @ModelAttribute DriverDTO driverDTO) {

        driverDTO.setUser(new UserDTO(username, password, "Driver"));
        driverService.updateDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Updated..!", "");

    }

    @GetMapping(path = "/all")
    public ResponseUtil getAll() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.getAllDrivers());

    }
}
