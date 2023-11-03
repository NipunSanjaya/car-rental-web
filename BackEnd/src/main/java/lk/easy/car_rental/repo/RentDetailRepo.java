package lk.easy.car_rental.repo;

import lk.easy.car_rental.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentDetailRepo extends JpaRepository<RentDetail, String> {
    public List<RentDetail> getRentDetailByNic(String nic);

    public void deleteRentDetailByRegNum(String rentId);
}
