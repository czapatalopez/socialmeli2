package com.bootcamp.be_java_hisp_w25_g14.unitTest;

import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ServiceTest {
    @Mock
    private UserRepoImp userRepo;

    @InjectMocks
    private UserServiceImp userService;

    @Test
    void followOkTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=3;

        //Act
        userService.addFollowe(userId,userIdToFollow);
        verify(userRepo, atLeast(1)).addFollower(userId,userIdToFollow);
    }


}
