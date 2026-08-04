package com.app.ecom_application.service;

import com.app.ecom_application.dto.AddressDto;
import com.app.ecom_application.dto.UserRequest;
import com.app.ecom_application.dto.UserResponse;
import com.app.ecom_application.models.Address;
import com.app.ecom_application.models.User;
import com.app.ecom_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserRequest userRequest) {
        User user = new User();
        updateUserFromRequest(user,userRequest);
        userRepository.save(user);
        return "User created!!!";
    }



    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUser(Long id) {
        return userRepository.findById(id).map(this::mapToUserResponse).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public Object updateUserInfo(Long id, User user) {
       User existingUser = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
       existingUser.setFirstName(user.getFirstName());
       existingUser.setLastName(user.getLastName());
       userRepository.save(existingUser);
       return null;
    }

    private void updateUserFromRequest(User user, UserRequest userRequest) {
        userRequest.setFirstName(user.getFirstName());
        userRequest.setLastName(user.getLastName());
        userRequest.setEmail(user.getEmail());
        userRequest.setPhone(user.getEmail());

        if(userRequest.getAddress() != null){
            Address address = new Address();
            address.setStreet(userRequest.getAddress().getStreet());
            address.setState(userRequest.getAddress().getState());
            address.setCountry(userRequest.getAddress().getCountry());
            address.setZipcode(userRequest.getAddress().getZipcode());

        }
    }

    private UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());

        if(user.getAddress() != null){
            AddressDto addressDto = new AddressDto();
            addressDto.setStreet(user.getAddress().getStreet());
            addressDto.setCity(user.getAddress().getCity());
            addressDto.setState(user.getAddress().getState());
            addressDto.setCountry(user.getAddress().getCountry());
            addressDto.setZipcode(user.getAddress().getZipcode());
        }
        return response;
    }
}
