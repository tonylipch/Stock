package com.anton.stockexchanger.Service;

import com.anton.stockexchanger.dto.UserDto;
import com.anton.stockexchanger.entity.User;
import com.anton.stockexchanger.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDto addUser( UserDto user ) throws Exception {
        log.info("method :'Add user' has been invoked");

        Optional<User> found = userRepository.findByLogin(user.getLogin());

        if (found.isPresent()){

            throw new Exception("this user already exist");
        }

        User newUser = new User();
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        UserDto response = new UserDto();
        response.setLogin(user.getLogin());
        response.setPassword(user.getPassword());
        return response;
    }

    public User deleteUser (Long id) throws Exception {

        Optional<User> found = userRepository.findById(id);

        if (found.isPresent()){
            User currentUser = found.get();

            userRepository.deleteById(currentUser.getId());
            return  currentUser;

        }

        throw new Exception("User not found");

    }

    public UserDto updateUser (UserDto updUser, Long id) throws Exception {
        log.info("method: 'Update user' has been invoked");
        Optional<User> currentUser = userRepository.findById(id);

        if (userRepository.existsById(id)){

            log.info("User with id "+updUser.getLogin()+" updated");
            User user = new User();
            user.setLogin(user.getLogin());
            user.setPassword(user.getPassword());
            userRepository.save(user);
            UserDto response = new UserDto();
            response.setLogin(user.getLogin());
            response.setPassword(user.getPassword());
            return response;



        }
        log.warn("UserNotFoundException thrown...Delete Failed, User not found with id "+updUser.getLogin());
        throw new Exception("User not found with id "+updUser.getLogin());

    }

}
