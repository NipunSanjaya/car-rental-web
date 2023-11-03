package lk.easy.car_rental.controller;

import lk.easy.car_rental.dto.RentDTO;
import lk.easy.car_rental.service.RentService;
import lk.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping
    public ResponseUtil rentRequest(@RequestBody RentDTO rentDTO) {

        rentService.requestRent(rentDTO);
        return new ResponseUtil("OK", "Successfully Requested..!", "");

    }

    @GetMapping
    public ResponseUtil generateNewRentId() {

        return new ResponseUtil("OK", "Successfully Requested..!", rentService.generateNewRentId());

    }

    @GetMapping(params = "username")
    public ResponseUtil getCustomer(@RequestParam String username) {

        return new ResponseUtil("OK", "Successfully Loaded..!", rentService.getCustomerByUsername(username));

    }


}