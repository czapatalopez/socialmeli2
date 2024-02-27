package com.bootcamp.be_java_hisp_w25_g14;

import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import com.bootcamp.be_java_hisp_w25_g14.service.IUserService;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.internal.configuration.GlobalConfiguration.validate;

@ExtendWith(MockitoExtension.class)

public class T0001 {
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
    @Test
    void followUserNoExists(){
        //Arrange
        Integer userId=10;
        Integer userIdToFollow=3;

        //Act Assert
        assertThrows(NotFoundException.class, () -> userService.addFollowe(userId,userIdToFollow));
    }

}
