package com.myapp.trip.tdd.servicetest;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;
//import java.util.Arrays;
//import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.myapp.trip.model.User;
import com.myapp.trip.repository.UserRepository;
import com.myapp.trip.service.UserService;
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
    private UserService service;
    @MockBean
    private UserRepository repository;
    @Test
    @DisplayName("Test UserImpl")
    public void testUserServiceImpl() {
        User mockuser = new User();
        mockuser.setId(1);
        doReturn(mockuser).when(repository).getById(1);
        User founduser = service.getById(1);
        assertNotNull(founduser);
        assertSame(1, founduser.getId());
    }
}
