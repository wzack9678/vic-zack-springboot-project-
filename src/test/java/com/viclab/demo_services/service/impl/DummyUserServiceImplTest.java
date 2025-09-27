package com.viclab.demo_services.service.impl;

import com.viclab.demo_services.payload.UserDTO;
import com.viclab.demo_services.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DummyUserServiceImplTest {
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
}
