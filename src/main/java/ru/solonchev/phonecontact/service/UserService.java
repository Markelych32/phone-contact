package ru.solonchev.phonecontact.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.solonchev.phonecontact.dto.request.UpdateSaveUserDto;
import ru.solonchev.phonecontact.dto.response.UserInfoDto;
import ru.solonchev.phonecontact.exception.UserNotFoundException;
import ru.solonchev.phonecontact.model.User;
import ru.solonchev.phonecontact.repository.UserRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private UserInfoDto fromEntityToUserDto(User user) {
        return new UserInfoDto(
                String.valueOf(user.getId()),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone()
        );
    }

    private User fromDtoToUser(UpdateSaveUserDto userDto) {
        return User.builder()
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .phone(userDto.phone())
                .build();
    }

    private void updateInfoOfUser(User user, UpdateSaveUserDto dto) {
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setPhone(dto.phone());
    }

    public List<UserInfoDto> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(this::fromEntityToUserDto)
                .toList();
    }

    public void addNewUser(UpdateSaveUserDto request) {
        userRepository.save(fromDtoToUser(request));
    }

    public void updateUser(Integer userId, UpdateSaveUserDto request) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        updateInfoOfUser(user, request);
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
