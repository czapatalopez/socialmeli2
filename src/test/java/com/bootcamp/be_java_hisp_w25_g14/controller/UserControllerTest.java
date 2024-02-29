package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    private UserServiceImp userServiceImp;

    @InjectMocks
    UserController userController;



}
