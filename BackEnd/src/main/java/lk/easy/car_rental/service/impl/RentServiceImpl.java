package lk.easy.car_rental.service.impl;

import lk.easy.car_rental.dto.RentDetailDTO;
import lk.easy.car_rental.repo.*;
import lk.easy.car_rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo rentRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    RentDetailRepo rentDetailRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public List<RentDetailDTO> getDriverSchedule(String nic) throws RuntimeException {
        return mapper.map(rentDetailRepo.getRentDetailByNic(nic), new TypeToken<ArrayList<RentDetailDTO>>() {
        }.getType());
    }
}
