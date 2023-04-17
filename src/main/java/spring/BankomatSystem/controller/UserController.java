package spring.BankomatSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.BankomatSystem.entity.User;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.UserDto;
import spring.BankomatSystem.repository.UserRepository;
import spring.BankomatSystem.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<?> getUsers(){
        List<User> users = userService.getUsersService();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public HttpEntity<?> addUser(@RequestBody UserDto userDto){
        ApiResponse apiResponse = userService.addUserService(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteUser(@PathVariable Integer id){
        ApiResponse apiResponse = userService.deleteUserService(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
