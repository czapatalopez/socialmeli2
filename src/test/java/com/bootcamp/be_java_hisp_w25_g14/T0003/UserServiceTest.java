package com.bootcamp.be_java_hisp_w25_g14.T0003;


import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImp userServiceImp;

    @Test
    @DisplayName("T0003 - Validate order")
    void validateAscOrderTest(){
        //Arrange
        int id = 1;
        String order = "name_as";
        //Act & Assert
        assertThrows(InvalidRequestException.class, ()->{
            this.userServiceImp.listSellersFollowers(id,order);
        });

    }

    @Test
    @DisplayName("T0003 - Validate order")
    void validateDescOrderTest(){
        //Arrange
        int id = 1;
        String order = "name_des";
        //Act & Assert
        assertThrows(InvalidRequestException.class, ()->{
            this.userServiceImp.listSellersFollowers(id,order);
        });

    }


}
