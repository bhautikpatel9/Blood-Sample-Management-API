package com.bhautik.bsm.serviceimpl;

import com.bhautik.bsm.entitys.Admin;
import com.bhautik.bsm.enums.UserRole;
import com.bhautik.bsm.exception.UserNotFoundByIdException;
import com.bhautik.bsm.repository.AdminRepository;
import com.bhautik.bsm.repository.UserRepository;
import com.bhautik.bsm.requestdto.UserRequest;
import com.bhautik.bsm.responsedto.AdminResponse;
import com.bhautik.bsm.responsedto.UserResponse;
import com.bhautik.bsm.entitys.User;
import com.bhautik.bsm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return this.mapToUserResponse(user);
    }

    @Override
    public UserResponse findUserById(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isEmpty())
            throw new UserNotFoundByIdException("Failed to find User");
        return this.mapToUserResponse(optional.get());
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isEmpty())
            throw new UserNotFoundByIdException("Failed to Update the user");

        User user = this.mapToUser(userRequest, optional.get());
        userRepository.save(user);

        return this.mapToUserResponse(user);
    }

    @Override
    public UserResponse promoteUserById(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isEmpty()) {
            throw new UserNotFoundByIdException("Failed to update");
        }
        User user = optional.get();
        user.setUserRole(UserRole.ADMIN);
        userRepository.save(user);

        Admin admin = new Admin();
        admin.setUser(user);
        adminRepository.save(admin);

        return this.mapToUserResponse(user);
    }

    @Override
    public AdminResponse registerUserAdmin(UserRequest userRequest) {
        User user = new User();
        user.setUserRole(UserRole.ADMIN);
        user = this.mapToUser(userRequest, user);

        user = userRepository.save(user);
        UserResponse userResponse = this.mapToUserResponse(user);

        Admin admin = new Admin();
        admin.setUser(user);
        adminRepository.save(admin);

        return AdminResponse.builder()
                .userResponse(userResponse)
                .adminId(admin.getAdminId())
                .adminType(admin.getAdminType())
                .build();
    }

    // ✅ FIXED deleteUserById()
    @Override
    public void deleteUserById(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundByIdException("User not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }

    // ✅ FIXED findAllUsers()
    @Override
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUserResponse).toList();
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        return null;
    }

//    // ✅ FIXED findUserByEmail()
//    @Override
//    public UserResponse findUserByEmail(String email) {
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        if (optionalUser.isEmpty()) {
//            throw new UserNotFoundByIdException("User not found with Email: " + email);
//        }
//        return this.mapToUserResponse(optionalUser.get());
//    }
}
