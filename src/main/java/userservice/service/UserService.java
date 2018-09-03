package userservice.service;

import org.springframework.stereotype.Service;
import userservice.model.User;
import userservice.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Transactional()
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
    public User saveUser(String login, String password){
        return userRepository.save(new User(login, password));
    }
}
