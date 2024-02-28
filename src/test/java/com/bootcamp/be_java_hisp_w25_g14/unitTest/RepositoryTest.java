package com.bootcamp.be_java_hisp_w25_g14.unitTest;

import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

public class RepositoryTest {

    UserRepoImp userRepoImp = new UserRepoImp();

    @Test
    void t0001addFollowerOk(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=3;

        //Act Assert
        userRepoImp.addFollower(userId,userIdToFollow);

    }

    @Test
    void t0001unableFollowItselfTest(){
        //Arrange
        Integer userId=3;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    void t0001userNoExistsTest(){
        //Arrange
        Integer userId=10;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    void t0001userFollowNoExistsTest(){
        //Arrange
        Integer userId=1;
        Integer userIdToFollow=30;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    void t0001alreadyFollowTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=1;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }

    @Test
    void t0001followNormalExceptionTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=4;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }


    @Test
    void t0002removeFollowerOk(){
        //Arrange
        Integer userId=2;
        Integer userIdToUnfollow=1;

        //Act Assert
        userRepoImp.removeFollow(userId,userIdToUnfollow);

    }

    @Test
    void t0002userIdNotExistsTest(){
        //Arrange
        Integer userId=12;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.removeFollow(userId,userIdToFollow));
    }
    @Test
    void t0002userIdToUnfollowNotExistsTest(){
        //Arrange
        Integer userId=1;
        Integer userIdToFollow=10;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.removeFollow(userId,userIdToFollow));
    }
    @Test
    void t0002dontFollowTest(){
        //Arrange
        Integer userId=3;
        Integer userIdToFollow=2;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.removeFollow(userId,userIdToFollow));
    }


}
