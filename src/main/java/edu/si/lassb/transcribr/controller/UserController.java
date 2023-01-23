package edu.si.lassb.transcribr.controller;

import edu.si.lassb.transcribr.entity.User;
import edu.si.lassb.transcribr.pojo.UserSearchRequestModel;
import edu.si.lassb.transcribr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * Handles requests to /user/* routes.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a user using the user's ID.
     *
     * @param id the user's ID
     * @return the user
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.of(userService.findById(id));
    }

    /**
     * Searches for a user using:
     * <ul>
     *     <li>id</li>
     *     <li>email</li>
     *     <li>username</li>
     * </ul>
     *
     * @param userSearchRequestModel representation of the JSON request body
     * @return the user
     */
    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserBySearch(@RequestBody UserSearchRequestModel userSearchRequestModel) {
        return ResponseEntity.of(userService.search(userSearchRequestModel));
    }

    /**
     * Creates a new user.
     *
     * @param user the user data
     * @return the user
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

}
