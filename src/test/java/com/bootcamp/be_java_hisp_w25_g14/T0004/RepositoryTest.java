package com.bootcamp.be_java_hisp_w25_g14.T0004;

import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    IUserRepo userRepo;
    @Test
    void listSellersFollowersAscTest(){
        int id=1;
        String order="name_asc";
        List<User> listSellersExpected = List.of(
                new User(2,"jacob",true,List.of(1),List.of(1,5)),
                new User(4,"rosa",false,List.of(1,3),List.of()));
        List<User> listSellers = userRepo.listSellersFollowers(id,order);
        assertEquals(listSellersExpected,listSellers);
    }

    @Test
    void listSellersFollowersDescTest(){
        int id=1;
        String order="name_desc";
        List<User> listSellersExpected = List.of(
                new User(4,"rosa",false,List.of(1,3),List.of()),
                new User(2,"jacob",true,List.of(1),List.of(1,5)));
        List<User> listSellers = userRepo.listSellersFollowers(id,order);
        assertEquals(listSellersExpected,listSellers);
    }

    @Test
    void listSellersFollowersNoUserTest(){
        int id=111;
        String order="name_desc";
        Assertions.assertThrows(NotFoundException.class,
        () -> {userRepo.listSellersFollowers(id,order);});
    }
}
