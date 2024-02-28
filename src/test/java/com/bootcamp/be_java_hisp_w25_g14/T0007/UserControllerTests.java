package com.bootcamp.be_java_hisp_w25_g14.T0007;

import com.bootcamp.be_java_hisp_w25_g14.controller.UserController;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {
    @Mock
    UserServiceImp userService;

    @InjectMocks
    UserController userController;

    @Test
    void testGetUserFollowersCount() {
        // Mocking the behavior of UserService to return a specific UserFollowersCountDto
        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUser_id(1);
        userFollowersCountDto.setUser_name("testUser");
        userFollowersCountDto.setFollowers_count(10);

        // Configure the behavior of UserService mock to return the UserFollowersCountDto
        when(userService.getUserFollowersCount(1)).thenReturn(userFollowersCountDto);

        // Calling the controller method
        ResponseEntity<?> response = userController.getUserFollowersCount(1);

        // Verifying that UserService was called with the correct argument
        verify(userService).getUserFollowersCount(1);

        // Verifying that the response status is HttpStatus.OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verifying that the response body contains the expected UserFollowersCountDto
        assertEquals(userFollowersCountDto, response.getBody());
    }


}
