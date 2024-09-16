//package com.example.shop;
//
//import com.example.shop.model.User;
//import com.example.shop.repositories.UserRepository;
//import com.example.shop.services.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testRegisterUser() {
//        User user = new User("testuser1", "testuser1@example.com", "password", "Test1", "User", "USER");
//        userService.registerUser(user);
//
//        User retrievedUser = userRepository.findByUsername("testuser1").orElse(null);
//        assertNotNull(retrievedUser);
//        assertEquals("testuser1", retrievedUser.getUsername());
//    }
//}
