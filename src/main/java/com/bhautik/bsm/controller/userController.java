package com.bhautik.bsm.controller;

import com.bhautik.bsm.requestdto.UserRequest;
import com.bhautik.bsm.responsedto.AdminResponse;
import com.bhautik.bsm.responsedto.UserResponse;
import com.bhautik.bsm.service.UserService;
import com.bhautik.bsm.util.ResponseStructure;
import com.bhautik.bsm.util.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class userController {

    private final UserService userService;

    private final RestResponseBuilder responseBuilder;


    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse= userService.registerUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User Created", userResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId){
        UserResponse Response = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND, "User Found",Response);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable int userId){
        UserResponse Response = userService.updateUser(userRequest, userId);
        return responseBuilder.success(HttpStatus.OK, "User Updated",Response);
    }

    @PutMapping("/promote/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> promoteToAdmin(@RequestBody UserRequest userRequest, @PathVariable int userId){
        UserResponse Response = userService.promoteToAdmin(userRequest,userId);
        return responseBuilder.success(HttpStatus.ACCEPTED,"User promoted to admin seccessfull",Response);
    }

    private RequestEntity<ResponseStructure<AdminResponse>> registerAdmin(@RequestBody UserRequest userRequest){
        AdminResponse adminResponse= userService.registerUserAdmin(UserRequest userRequest );
        return responseBuilder.success(HttpStatus.CREATED, "User Created", adminResponse);
    }
}
