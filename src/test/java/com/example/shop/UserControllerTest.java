package com.example.shop;

import com.example.shop.controllers.UserController;
import com.example.shop.exceptions.EmailAlreadyExistsException;
import com.example.shop.exceptions.UsernameAlreadyExistsException;
import com.example.shop.model.User;
import com.example.shop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    public void testRegisterUser_Success() {
        // Create a User object
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Call the controller method
        String result = userController.registerUser(user);

        // Verify that the method returns the expected redirect URL
        assertEquals("redirect:/login?success", result);
    }

    @Test
    public void testRegisterUser_UsernameExists() {
        // Create a User object
        User user = new User();
        user.setUsername("existinguser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock the userService.registerUser method to throw a UsernameAlreadyExistsException
        doThrow(new UsernameAlreadyExistsException()).when(userService).registerUser(user);

        // Call the controller method
        String result = userController.registerUser(user);

        // Verify that the userService.registerUser method was called
        verify(userService, times(1)).registerUser(user);

        // Verify that the method returns the expected redirect URL for a username conflict
        assertEquals("redirect:/register?error=username", result);
    }

    @Test
    public void testRegisterUser_EmailExists() {
        // Create a User object
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("existing@example.com");
        user.setPassword("password");

        // Mock the userService.registerUser method to throw an EmailAlreadyExistsException
        doThrow(new EmailAlreadyExistsException()).when(userService).registerUser(user);

        // Call the controller method
        String result = userController.registerUser(user);

        // Verify that the userService.registerUser method was called
        verify(userService, times(1)).registerUser(user);

        // Verify that the method returns the expected redirect URL for an email conflict
        assertEquals("redirect:/register?error=email", result);
    }
}
