package com.bootcamp.be_java_hisp_w25_g14.T0003;


import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserRepoTest {

    private UserRepoImp userRepoImp = new UserRepoImp();

    @Test
    void listOrderTest() throws Exception{

        //arrange
        List<User> userList = loadUsersList();

        //act
        List<User> listOrder = userRepoImp.listSellersFollowers(1,"name_asc");

        //assert
        assertEquals(userList.get(1).getUserName(), listOrder.get(0).getUserName());
        assertEquals(userList.get(3).getUserName(), listOrder.get(1).getUserName());

    }

    @Test
    void exceptionOrderTest() throws Exception{

        //act & assert
        Assertions.assertThrows(NotFoundException.class,
                () -> {userRepoImp.listSellersFollowers(4,"name_asc");});

    }

    private List<User> loadUsersList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        userList.add(new User(2, "jac", true, List.of(1), List.of(1, 5)));
        userList.add(new User(3, "hector", true, List.of(), List.of(1, 4, 5)));
        userList.add(new User(4, "rosa", false, List.of(1, 3), List.of()));
        userList.add(new User(5, "cristina", false, List.of(2, 3), List.of()));
        userList.add(new User(6, "alex", false, List.of(), List.of()));

        return userList;
    }

}
