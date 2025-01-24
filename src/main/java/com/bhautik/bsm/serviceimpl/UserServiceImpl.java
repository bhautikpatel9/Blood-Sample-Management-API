package com.bhautik.bsm.serviceimpl;

import com.bhautik.bsm.entitys.Admin;
import com.bhautik.bsm.enums.UserRole;
import com.bhautik.bsm.exception.UserNotFoundByIdException;
import com.bhautik.bsm.repository.AdminRepository;
import com.bhautik.bsm.repository.UserRepository;
import com.bhautik.bsm.requestdto.UserRequest;
import com.bhautik.bsm.responsedto.UserResponse;
import com.bhautik.bsm.entitys.User;
import com.bhautik.bsm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepositoty;

    @Autowired
    private final AdminRepository adminRepository;

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .age(user.getAge())
                        .userRole(user.getUserRole())
                        .availableCity(user.getAvailableCity())
                        .bloodGroup(user.getBloodGroup())
                        .gender(user.getGender())
                        .lastDonatedAt(user.getLastDonatedAt())

                        .build();
    }

    private User mapToUser(UserRequest userRequest, User user) {
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setAge(userRequest.getAge());
        user.setGender(userRequest.getGender());
        user.setBloodGroup(userRequest.getBloodGroup());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setAvailableCity(userRequest.getAvailableCity());

        return user;
    }


    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = this.mapToUser(userRequest, new User());
        user.setUserRole(UserRole.USER);
        user  = userRepositoty.save(user);
        return this.mapToUserResponse(user);

    }

    @Override
    public UserResponse findUserById(int userId) {
        Optional<User> optional = userRepositoty.findById(userId);

        if(optional.isEmpty())
            throw new UserNotFoundByIdException("Failed to find User");
        return this.mapToUserResponse(optional.get());
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, int userId) {
        Optional<User> optional = userRepositoty.findById(userId);
        if(optional.isEmpty())
            throw new UserNotFoundByIdException("Failed to Update the user");

        User user = this.mapToUser(userRequest, optional.get());
        userRepositoty.save(user);

        return this.mapToUserResponse(user);
    }

    @Override
    public UserResponse promoteToAdmin(UserRequest userRequest, int userId) {
        Optional<User> optional = userRepositoty.findById(userId);
        if (optional.isEmpty())
            throw new UserNotFoundByIdException("Failed to Update the user");

        User user = userRepositoty.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        user.setUserRole(UserRole.ADMIN);
        user=userRepositoty.save(user);
        Admin admin = Admin.builder()
                .user(user)
                .build();
        return this.mapToUserResponse(user);
    }


}