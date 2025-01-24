package com.bhautik.bsm.service;
import com.bhautik.bsm.requestdto.UserRequest;
import com.bhautik.bsm.responsedto.UserResponse;

public interface UserService {
   UserResponse registerUser(UserRequest userRequest);

   UserResponse findUserById(int userId);

   UserResponse updateUser(UserRequest userRequest, int userId);

   UserResponse promoteToAdmin(UserRequest userRequest, int userId);

}