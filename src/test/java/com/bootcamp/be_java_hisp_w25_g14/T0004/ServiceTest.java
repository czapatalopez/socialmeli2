package com.bootcamp.be_java_hisp_w25_g14.T0004;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    IUserRepo userRepo;

    @InjectMocks
    UserServiceImp userServiceImp;

    @Test
    void listSellersFollowersTest(){
        //Arrange
        int id=1;
        String order="name_desc";
        Optional<User> user = Optional.of(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        List<User> listUsersDesc = List.of(
                new User(4,"rosa",false,List.of(1,3),List.of()),
                new User(2,"jacob",true,List.of(1),List.of(1,5)));

        FollowedListResponseDto listExpected = new FollowedListResponseDto(
                user.get().getUserId(),
                user.get().getUserName(),
                List.of(new UserDataDto(4,"rosa"), new UserDataDto(2,"jacob"))
        );

        when(userRepo.findUserById(1)).thenReturn(user);
        when(userRepo.listSellersFollowers(1,"name_desc")).thenReturn(listUsersDesc);
        //Act
        FollowedListResponseDto listActual = userServiceImp.listSellersFollowers(id,order);

        assertEquals(listActual,listExpected);
    }

    @Test
    void listSellersFollowersNotFoundTest(){
        //Arrange
        int id=1;
        String order="name_desc";
        Optional<User> user = Optional.of(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        List<User> listUsersDesc = List.of(
                new User(4,"rosa",false,List.of(1,3),List.of()),
                new User(2,"jacob",true,List.of(1),List.of(1,5)));

        FollowedListResponseDto listExpected = new FollowedListResponseDto(
                user.get().getUserId(),
                user.get().getUserName(),
                List.of(new UserDataDto(4,"rosa"), new UserDataDto(2,"jacob"))
        );

        when(userRepo.findUserById(1)).thenReturn(user);
        when(userRepo.listSellersFollowers(1,"name_desc")).thenReturn(listUsersDesc);
        //Act
        FollowedListResponseDto listActual = userServiceImp.listSellersFollowers(id,order);

        assertEquals(listActual,listExpected);
    }
}
