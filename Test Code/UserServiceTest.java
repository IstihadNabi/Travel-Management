package com.istihad.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import com.istihad.repository.UserRepository;
import com.istihad.service.UserService;
import com.istihad.entity.User;

@RunWith(JUnit4.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private User user;
    private User user2;
    private UserService userService;

    @Before
    public void setup() throws Exception {
        userService = new UserService();
        userRepository = mock(UserRepository.class);
        userService.setReviewRepository(userRepository);
        ;
        user = new User();
        user.setId(1);
        user.setEmail("ab@gmail.com");
        user.setPassword("1234");

        user2 = new User();
        user2.setId(null);

        when(userRepository.findOne(user.getId())).thenReturn(user);
        when(userRepository.findOne(user2.getId())).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.save(user2)).thenReturn(null);

    }

    @Test
    public void testValidCreateUser() {

        assertEquals(user, userService.createUser(user));
    }

    @Test
    public void testInvalidCreateUser() {

        assertEquals(null, userService.createUser(user2));
    }

    @Test
    public void testValidLoginUser() {
        when(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(user);
        assertEquals(user, userService.loginUser(user));
    }

    @Test
    public void testInvalidLoginUser() {
        assertEquals(null, userService.loginUser(user2));
    }

    @Test
    public void testValidFindOne() {
        assertEquals(user, userService.findOne(user.getId()));
    }

    @Test
    public void testInValidFindOne() {
        assertEquals(null, userService.findOne(user2.getId()));
    }

}
