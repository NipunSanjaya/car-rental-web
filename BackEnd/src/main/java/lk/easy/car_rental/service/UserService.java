package lk.easy.car_rental.service;

import lk.easy.car_rental.dto.UserDTO;

public interface UserService {
    public UserDTO getUser(String username, String password) throws RuntimeException;
}
