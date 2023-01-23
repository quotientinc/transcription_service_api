package edu.si.lassb.transcribr.service;

import edu.si.lassb.transcribr.entity.User;
import edu.si.lassb.transcribr.pojo.UserSearchRequestModel;
import edu.si.lassb.transcribr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class providing user business logic.
 */
@Service(value = "user_service")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Finds a user by ID.
     *
     * @param id the user's ID
     * @return the user
     */
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * Finds a user by email address.
     *
     * @param email the user's email address
     * @return the user
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Finds a user by username.
     *
     * @param username the user's username
     * @return the user
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Searches for a user using:
     *
     * <ul>
     *     <li>id</li>
     *     <li>email</li>
     *     <li>username</li>
     * </ul>
     *
     * @param userSearchRequestModel representation of the JSON request body
     * @return the user
     */
    public Optional<User> search(UserSearchRequestModel userSearchRequestModel) {
        return userRepository.findByIdAndEmailAndUsername(
                userSearchRequestModel.getId(),
                userSearchRequestModel.getEmail(),
                userSearchRequestModel.getUsername()
        );
    }

    /**
     * Saves a user.
     *
     * @param user
     * @return the user
     */
    public User save(User user) {
        return userRepository.save(user);
    }

}
