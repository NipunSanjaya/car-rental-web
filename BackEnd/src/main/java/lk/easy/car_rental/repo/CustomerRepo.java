package lk.easy.car_rental.repo;

import lk.easy.car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT COUNT(nic) FROM Customer", nativeQuery = true)
    Long countCustomerByNic() throws RuntimeException;

    @Query(value = "SELECT * FROM Customer WHERE user_username=?", nativeQuery = true)
    Customer getCustomerByUsername(String username);
}
