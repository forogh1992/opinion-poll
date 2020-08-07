package com.forogh.opinionPoll.controller;

import com.forogh.opinionPoll.dto.UserDTO;
import com.forogh.opinionPoll.mapper.UserMapper;
import com.forogh.opinionPoll.model.User;
import com.forogh.opinionPoll.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping("/")
    public ResponseEntity<Void> add(@RequestBody UserDTO userDTO) {

        User user = userMapper.toUserEntity(userDTO);
        userService.register(user);
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(userMapper.toUserDTO(userService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@Valid UserDTO userDTO,
                                       @PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.update(id, userMapper.toUserEntity(userDTO)));
    }

    @GetMapping("/")
    public ResponseEntity<UserDTO> getByPhone(@RequestParam(value = "phoneNumber") String phoneNumber) {

        return ResponseEntity.ok(userMapper.toUserDTO(userService.getByPhoneNumber(phoneNumber)));
    }

    @PostMapping(value = "/{phoneNumber},{username}")
    public ResponseEntity<UserDTO> loginUser(@PathVariable String phoneNumber, @PathVariable String username) {
        return ResponseEntity.ok(userMapper.toUserDTO(userService.getUserByPhoneAndUsername(phoneNumber, username)));
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<UserDTO>> getAllUser(@PathVariable("page") int page, @PathVariable("size") int size) {
        return ResponseEntity.ok(userMapper.toUserDTO(userService.getAllWithPagination(page, size)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllData() {
        return ResponseEntity.ok(userMapper.toUserDTO(userService.getAllUser()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
