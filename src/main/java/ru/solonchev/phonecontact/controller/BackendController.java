package ru.solonchev.phonecontact.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.solonchev.phonecontact.dto.request.UpdateSaveUserDto;
import ru.solonchev.phonecontact.service.UserService;

@RestController
@RequestMapping("/phone-contact")
@RequiredArgsConstructor
public class BackendController {
    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<?> addNewUser(@RequestBody UpdateSaveUserDto request) {
        userService.addNewUser(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable Integer userId,
            @RequestBody UpdateSaveUserDto request) {
        userService.updateUser(userId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
