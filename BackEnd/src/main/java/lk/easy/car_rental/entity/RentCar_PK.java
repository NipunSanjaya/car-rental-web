package lk.easy.car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RentCar_PK implements Serializable {
    private String rentId;
    private String regNum;
}
