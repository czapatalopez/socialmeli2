package com.bootcamp.be_java_hisp_w25_g14.T0001;

import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

public class RepositoryTest {

    UserRepoImp userRepoImp = new UserRepoImp();

    @Test
    void addFollowerOk(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=3;

        //Act Assert
        userRepoImp.addFollower(userId,userIdToFollow);

    }

    @Test
    void unableFollowItselfTest(){
        //Arrange
        Integer userId=3;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    void userNoExistsTest(){
        //Arrange
        Integer userId=10;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    void userFollowNoExistsTest(){
        //Arrange
        Integer userId=1;
        Integer userIdToFollow=30;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    void alreadyFollowTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=1;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }

    @Test
    void followNormalExceptionTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=4;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
}
