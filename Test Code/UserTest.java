package com.istihad.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import com.istihad.TravelWebAppApplication;
import com.istihad.entity.User;
import com.istihad.service.UserService;

@RunWith(JUnit4.class)
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1);
        user.setUserName("test");
        user.setEmail("test@gmail.com");
        user.setPassword("test12");
        user.setSessionId("testID");
    }

    @Test
    public void testGetId() {
        assertEquals("1", user.getId().toString());
    }

    @Test
    public void testGetUserName() {
        assertEquals("test", user.getUserName());
    }

    @Test
    public void testGetPassword() {
        assertEquals("test12", user.getPassword());
    }

    @Test
    public void testGetEmail() {
        assertEquals("test@gmail.com", user.getEmail());
    }

    @Test
    public void testGetSessionId() {
        assertEquals("testID", user.getSessionId());
    }
}
