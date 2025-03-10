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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api") // Common Prefix
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    // ✅ Register New User
    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse = userService.registerUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User Created", userResponse);
    }

    // ✅ Find User by ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId){
        UserResponse response = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.OK, "User Found", response);
    }

    // ✅ Update User
    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable int userId){
        UserResponse response = userService.updateUser(userRequest, userId);
        return responseBuilder.success(HttpStatus.OK, "User Updated", response);
    }

    // ✅ Delete User
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int userId){
        userService.deleteUserById(userId);
        return responseBuilder.success(HttpStatus.OK, "User Deleted", "User deleted successfully");
    }

    // ✅ Find All Users
    @GetMapping("/users")
    public ResponseEntity<ResponseStructure<List<UserResponse>>> findAllUsers(){
        List<UserResponse> users = userService.findAllUsers();
        return responseBuilder.success(HttpStatus.OK, "Users Found", users);
    }

    // ✅ Find User by Email
    @GetMapping("/users/email/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserByEmail(@PathVariable String email){
        UserResponse response = userService.findUserByEmail(email);
        return responseBuilder.success(HttpStatus.OK, "User Found", response);
    }

    // ✅ Promote User to Admin
    @PutMapping("/admin/promote/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> promoteUserById(@PathVariable int userId){
        UserResponse response = userService.promoteUserById(userId);
        return responseBuilder.success(HttpStatus.OK, "User Promoted to Admin", response);
    }

    // ✅ Register New Admin
    @PostMapping("/admin")
    public ResponseEntity<ResponseStructure<AdminResponse>> registerAdmin(@RequestBody UserRequest userRequest){
        AdminResponse adminResponse = userService.registerUserAdmin(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "Admin Created", adminResponse);
    }
}
