package br.com.o2junior.springdto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDtoApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
class SpringDtoApplicationTests {

    @Test
    public void contextLoads() {
    }

}
