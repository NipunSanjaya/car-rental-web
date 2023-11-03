package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    public void savePayment(PaymentDTO paymentDTO) throws RuntimeException;

    public List<PaymentDTO> loadAllPayments() throws RuntimeException;
}
