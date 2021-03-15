package com.myapp.trip.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

//import com.myapp.trip.model.User;

public class UserRepositoryTest {
	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
    @Test
    public void createMapBackedProjection() {
        User user = factory.createProjection(User.class);
        user.setId(1);
        assertEquals(user.getId(),1);
    }
    @Test
    public void createsProxyForSourceMap() {
        Map<String, Object> backingMap = new HashMap<>();
        backingMap.put("id",1);
        User user = factory.createProjection(User.class, backingMap);
        assertEquals(user.getId(),1);
    }
    interface User {
        int getId();
        void setId(int id);
    }

}
