package br.com.o2junior.springdto;

import br.com.o2junior.springdto.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest extends SpringDtoApplicationTests {

    private MockMvc mockMvc;
    /* TODO
        Escrever os testes para cada um dos endpoints do UserControle
     */

    @Autowired
    private UserController userController;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


}
