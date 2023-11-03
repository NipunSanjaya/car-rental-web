package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.PaymentDTO;

public interface PaymentService {

    public void savePayment(PaymentDTO paymentDTO) throws RuntimeException;
}
