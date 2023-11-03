package lk.easy.car_rental.repo;

import lk.easy.car_rental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentRepo extends JpaRepository<Rent,String> {

    @Query(value = "SELECT rentId FROM Rent ORDER BY rentId  DESC LIMIT 1", nativeQuery = true)
    String getLastRentId();
}