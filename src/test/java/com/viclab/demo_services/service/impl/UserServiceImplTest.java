package com.viclab.demo_services.service.impl;

import com.viclab.demo_services.entity.User;
import com.viclab.demo_services.exception.ResourceNotFoundException;
import com.viclab.demo_services.payload.UserDTO;
import com.viclab.demo_services.dao.UserRepository;
import com.viclab.demo_services.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostgreSqlUserServiceImpl userServiceImpl;  // 让 Mockito 创建实现类实例


    private UserService userService;

    private User sampleUser;
    private UserDTO expectedUserDTO;

    @BeforeEach
    void setUp() {
        userService = userServiceImpl;


        // Setup sample user

        sampleUser = new User();
        sampleUser.setId(1L);
        sampleUser.setName("John Doe");
        sampleUser.setEmail("john@example.com");
        sampleUser.setPhone("1234567890");
        sampleUser.setStatus("ACTIVE");

        // Setup expected DTO
        expectedUserDTO = new UserDTO();
        expectedUserDTO.setId(1L);
        expectedUserDTO.setName("John Doe");
        expectedUserDTO.setEmail("john@example.com");
        expectedUserDTO.setPhone("1234567890");
        expectedUserDTO.setStatus("ACTIVE");
    }

    @Test
    @DisplayName("Should create a new user and return saved UserDTO")
    void createUser_shouldSaveUserAndReturnDTO () {
        UserDTO requestDTO = new UserDTO();
        requestDTO.setName("Alice");
        requestDTO.setEmail("alice@example.com");
        requestDTO.setPhone("1234567890");
        requestDTO.setStatus("ACTIVE");

        User savedUser = new User();
        savedUser.setId(100L);
        savedUser.setName("Alice");
        savedUser.setEmail("alice@example.com");
        savedUser.setPhone("1234567890");
        savedUser.setStatus("ACTIVE");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDTO result = userService.createUser(requestDTO);

        assertNotNull(result);
        assertEquals(100L, result.getId());
        assertEquals("Alice", result.getName());
        assertEquals("alice@example.com", result.getEmail());
        assertEquals("1234567890", result.getPhone());
        assertEquals("ACTIVE", result.getStatus());

        verify(userRepository,times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when repository save fails")
    void createUser_whenRepositoryThrowsException_shouldPropagate() {
        // Arrange
        UserDTO requestDTO = new UserDTO();
        requestDTO.setName("Bob");
        requestDTO.setEmail("bob@example.com");
        requestDTO.setPhone("9876543210");
        requestDTO.setStatus("ACTIVE");

        when(userRepository.save(any(User.class)))
                .thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> userService.createUser(requestDTO)
        );

        assertTrue(exception.getMessage().contains("Database error"));

        // Verify repository interaction
        verify(userRepository, times(1)).save(any(User.class));
    }



    @Test
    @DisplayName("Should return user DTO when user exists")
    void getUserById_whenUserExists_shouldReturnUserDTO() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(sampleUser));

        // Act
        UserDTO result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(expectedUserDTO.getId(), result.getId());
        assertEquals(expectedUserDTO.getName(), result.getName());
        assertEquals(expectedUserDTO.getEmail(), result.getEmail());
        assertEquals(expectedUserDTO.getPhone(), result.getPhone());
        assertEquals(expectedUserDTO.getStatus(), result.getStatus());
        
        // Verify repository interaction
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when user does not exist")
    void getUserById_whenUserDoesNotExist_shouldThrowException() {
        // Arrange
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(
            ResourceNotFoundException.class,
            () -> userService.getUserById(999L)
        );

        // Verify exception message
        assertTrue(exception.getMessage().contains("User"));
        assertTrue(exception.getMessage().contains("id"));
        assertTrue(exception.getMessage().contains("999"));

        // Verify repository interaction
        verify(userRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Should handle null user data gracefully")
    void getUserById_whenUserHasNullFields_shouldHandleGracefully() {
        // Arrange
        User userWithNullFields = new User();
        userWithNullFields.setId(2L);
        // Other fields are null
        
        when(userRepository.findById(2L)).thenReturn(Optional.of(userWithNullFields));

        // Act
        UserDTO result = userService.getUserById(2L);

        // Assert
        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertNull(result.getName());
        assertNull(result.getEmail());
        assertNull(result.getPhone());
        assertNull(result.getStatus());

        // Verify repository interaction
        verify(userRepository, times(1)).findById(2L);
    }
} 