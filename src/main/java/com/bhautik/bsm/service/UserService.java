package com.bhautik.bsm.service;
import com.bhautik.bsm.requestdto.UserRequest;
import com.bhautik.bsm.responsedto.AdminResponse;
import com.bhautik.bsm.responsedto.UserResponse;

import java.util.List;

public interface UserService {
   UserResponse registerUser(UserRequest userRequest);

   UserResponse findUserById(int userId);

   UserResponse updateUser(UserRequest userRequest, int userId);

   UserResponse promoteUserById(int userId);

   AdminResponse registerUserAdmin(UserRequest userRequest);

   void deleteUserById(int userId);  // 🆕 Delete User

   List<UserResponse> findAllUsers();  // 🆕 Get All Users

   UserResponse findUserByEmail(String email);
}