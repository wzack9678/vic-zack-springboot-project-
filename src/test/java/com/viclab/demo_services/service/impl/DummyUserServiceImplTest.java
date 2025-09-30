package com.viclab.demo_services.service.impl;

import com.viclab.demo_services.payload.UserDTO;
import com.viclab.demo_services.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DummyUserServiceImplTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new DummyUserServiceImpl();
    }

    @Test
    @DisplayName("Should create a new user with correct ID and status")
    void createUser_shouldAssignIncrementalId_andReturnSavedUser () {
        UserDTO req = new UserDTO();
        req.setName("Alice");
        req.setEmail("alice@test.com");
        req.setPhone("123456");
        req.setStatus("ACTIVE");

        UserDTO saved = userService.createUser(req);
        assertNotNull(saved.getId());
        assertEquals("Alice", saved.getName());
        assertEquals("ACTIVE", saved.getStatus());
    }
    @Test
    @DisplayName("Should return at least one seeded user")
    void getAllUsers_shouldReturnAtLeastSeededUser() {
        List<UserDTO> users = userService.getAllUsers();
        assertTrue(users.size() >= 1);
    }

    @Test
    @DisplayName("Teacher Should create a new user with correct ID and status")
    void createUser_Teacher_shouldCreateNewUserWithCorrectIdAndStatus() {
        // Arrange
        UserDTO newUser = new UserDTO();
        newUser.setName("Jane Doe");
        newUser.setEmail("jane@example.com");
        newUser.setPhone("9876543210");

        // Act
        UserDTO createdUser = userService.createUser(newUser);

        // Assert
        assertNotNull(createdUser);
        assertEquals(2L, createdUser.getId()); // Since we have one user in constructor
        assertEquals("Jane Doe", createdUser.getName());
        assertEquals("jane@example.com", createdUser.getEmail());
        assertEquals("9876543210", createdUser.getPhone());
        assertEquals("ACTIVE", createdUser.getStatus());
    }

    @Test
    @DisplayName("Should increment ID for each new user")
    void createUser_shouldIncrementIdForEachNewUser() {
        // Arrange
        UserDTO user1 = new UserDTO();
        user1.setName("User 1");
        UserDTO user2 = new UserDTO();
        user2.setName("User 2");

        // Act
        UserDTO createdUser1 = userService.createUser(user1);
        UserDTO createdUser2 = userService.createUser(user2);

        // Assert
        assertEquals(2L, createdUser1.getId());
        assertEquals(3L, createdUser2.getId());
    }

    @Test
    @DisplayName("Should store user in the dummy users map")
    void createUser_shouldStoreUserInDummyUsersMap() {
        // Arrange
        UserDTO newUser = new UserDTO();
        newUser.setName("Test User");
        newUser.setEmail("test@example.com");

        // Act
        UserDTO createdUser = userService.createUser(newUser);
        UserDTO retrievedUser = userService.getUserById(createdUser.getId());

        // Assert
        assertNotNull(retrievedUser);
        assertEquals(createdUser.getId(), retrievedUser.getId());
        assertEquals(createdUser.getName(), retrievedUser.getName());
        assertEquals(createdUser.getEmail(), retrievedUser.getEmail());
    }
} 
