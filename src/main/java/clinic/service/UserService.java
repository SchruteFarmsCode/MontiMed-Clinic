package clinic.service;

import clinic.model.User;
import clinic.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        log.info("Registering new user: {}", user.getUsername());

        if (userRepository.existsByUsername(user.getUsername())) {
            log.error("User with username {} already exists", user.getUsername());
            throw new RuntimeException("User with username " + user.getUsername() + " already exists");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        User savedUser = userRepository.save(user);
        log.info("User registered successfully: {}", savedUser.getUsername());
        return savedUser;
    }
    public void deleteUser(Long id) {
        log.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User newUserDetails) {
        log.info("Updating user with ID: {}", id);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));

        existingUser.setUsername(newUserDetails.getUsername());
        existingUser.setEmail(newUserDetails.getEmail());
        existingUser.setFirstName(newUserDetails.getFirstName());
        existingUser.setLastName(newUserDetails.getLastName());

        return userRepository.save(existingUser);
    }

    public User getUserByUsername(String username) {
        log.info("Getting user by username: {}", username);
        return userRepository.findByUsername(username).orElseThrow(() -> {
            log.error("User with username {} not found", username);
            return new EntityNotFoundException("User with username " + username + " not found");
        });
    }
}

