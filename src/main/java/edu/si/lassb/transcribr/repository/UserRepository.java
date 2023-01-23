package edu.si.lassb.transcribr.repository;

import edu.si.lassb.transcribr.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByIdAndEmailAndUsername(Integer Id, String email, String username);
}
