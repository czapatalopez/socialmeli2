package com.bootcamp.be_java_hisp_w25_g14.T0007;


import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private IUserRepo userRepoMock;

    @InjectMocks
    UserServiceImp userService;


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user exists and is a seller with followers.
     *
     * <p>
     * This test ensures that when the user exists and is a seller with followers, the getUserFollowersCount method
     * returns a UserFollowersCountDto object with the correct user ID, user name, and followers count.
     * </p>
     */
    @Test
    public void testGetUserFollowersCount_UserExistsAndIsSeller() {
        // Create a simulated user who exists, is a seller, and has followers
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setIsSeller(true);
        List<Integer> followers = new ArrayList<>();
        followers.add(2);
        followers.add(3);
        user.setFollowers(followers);

        // Configure the behavior of the user repository mock
        when(userRepoMock.findUserById(1)).thenReturn(Optional.of(user));

        // Call the method of the service
        UserFollowersCountDto result = userService.getUserFollowersCount(1);

        // Verify that the expected result is obtained
        assertEquals(1, result.getUser_id());
        assertEquals("testUser", result.getUser_name());
        assertEquals(2, result.getFollowers_count());
    }


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user is not found.
     *
     * <p>
     * This test ensures that when the user is not found in the repository, the getUserFollowersCount method
     * throws a NotFoundException.
     * </p>
     */
    @Test
    public void testGetUserFollowersCount_UserNotFound() {
        // Configure the behavior of the user repository mock to return an empty Optional
        when(userRepoMock.findUserById(1)).thenReturn(Optional.empty());

        // Verify that a NotFoundException is thrown when the user is not found
        assertThrows(NotFoundException.class, () -> userService.getUserFollowersCount(1));
    }


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user is not a seller.
     *
     * <p>
     * This test ensures that when the user is not a seller, the getUserFollowersCount method
     * throws a FollowException.
     * </p>
     */
    @Test
    void testGetUserFollowersCount_UserNotSeller() {
        // Create a simulated user who is not a seller
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setIsSeller(false);

        // Configure the behavior of the user repository mock
        when(userRepoMock.findUserById(1)).thenReturn(Optional.of(user));

        // Verify that a FollowException is thrown when the user is not a seller
        assertThrows(FollowException.class, () -> userService.getUserFollowersCount(1));
    }


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user is a seller but does not have any followers.
     *
     * <p>
     * This test ensures that when the user is a seller but has no followers, the getUserFollowersCount method returns a UserFollowersCountDto
     * object with a followers count of 0.
     * </p>
     */
    @Test
    void testGetUserFollowersCount_DoesNotHaveFollowers() {
        // Create a simulated user who is a seller but has no followers
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setIsSeller(true);
        user.setFollowers(new ArrayList<>());

        // Configure the behavior of the user repository mock
        when(userRepoMock.findUserById(1)).thenReturn(Optional.of(user));

        // Call the method under test
        UserFollowersCountDto userFollowersCount = userService.getUserFollowersCount(1);

        // Verify that the returned UserFollowersCountDto has a followers count of 0
        assertEquals(0, userFollowersCount.getFollowers_count());

    }


}
