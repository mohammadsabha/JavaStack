package com.sabha.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.sabha.demo.models.LoginUser;
import com.sabha.demo.models.User;
import com.sabha.demo.repositories.UserRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // hashPassword
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception or rethrow it
            e.printStackTrace();
            return null;
        }
    }
    
    // bytesToHex
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    // passwordMatches
    private boolean passwordMatches(String enteredPassword, String storedPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(enteredPassword.getBytes(StandardCharsets.UTF_8));
            String enteredPasswordHash = bytesToHex(encodedHash);
            
            return storedPassword.equals(enteredPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception or rethrow it
            e.printStackTrace();
            return false;
        }
    }
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // Check if the BindingResult has errors
        if (result.hasErrors()) {
            return null;
        }
        
        // Reject if email is taken (present in the database)
        Optional<User> existingUserOptional = userRepository.findByEmail(newUser.getEmail());
        if (existingUserOptional.isPresent()) {
            // Email is already taken
            result.rejectValue("email", "error.emailTaken", "Email is already taken");
            return null;
        }
        
        // Reject if password doesn't match confirmation
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "error.passwordMismatch", "Passwords do not match");
            return null;
        }
        
        // Hash and set password
        String hashedPassword = hashPassword(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        
        // Save user to the database
        User savedUser = userRepository.save(newUser);
        
        return savedUser;
    }

    
    public User login(LoginUser newLoginObject, BindingResult result) {
        // Check if the BindingResult has errors
        if (result.hasErrors()) {
            return null;
        }
        
        // Find user in the DB by email
        Optional<User> userOptional = userRepository.findByEmail(newLoginObject.getEmail());
        if (userOptional.isEmpty()) {
            // User not found
            result.rejectValue("email", "error.userNotFound", "User not found");
            return null;
        }
        
        User user = userOptional.get();
        
        // Check if BCrypt password matches
        String enteredPassword = newLoginObject.getPassword();
        if (!passwordMatches(enteredPassword, user.getPassword())) {
            // Password doesn't match
            result.rejectValue("password", "error.invalidPassword", "Invalid password");
            return null;
        }
        
        // Return the user object
        return user;
    }
    // Find Id for current user
    public User findUserById(Long id) {
    	Optional<User> thisUser = userRepository.findById(id);

    	if(thisUser.isPresent()) {
			return thisUser.get();
			} else {
			return null;
    	}
	}
}

