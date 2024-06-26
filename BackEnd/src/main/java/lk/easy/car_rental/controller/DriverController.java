package lk.easy.car_rental.controller;

import lk.easy.car_rental.dto.DriverDTO;
import lk.easy.car_rental.dto.UserDTO;
import lk.easy.car_rental.service.DriverService;
import lk.easy.car_rental.service.RentService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin

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

    @GetMapping(path = "/available")
    public ResponseUtil availableDrivers() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.countAvailableDrivers());

    }

    @GetMapping(path = "/reserved")
    public ResponseUtil reservedDrivers() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.countReservedDrivers());

    }

    @GetMapping
    public ResponseUtil getCurrentDriver() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.getDriver());

    }

    @GetMapping(params = {"nic"})
    public ResponseUtil getDriverSchedule(String nic) {

        return new ResponseUtil("OK", "Successfully Loaded..!", rentService.getDriverSchedule(nic));

    }

    @DeleteMapping
    public ResponseUtil deleteDriver(String nic){

        driverService.deleteDriver(nic);
        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

}
