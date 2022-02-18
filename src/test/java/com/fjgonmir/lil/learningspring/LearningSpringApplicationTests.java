package com.fjgonmir.lil.learningspring;

import com.fjgonmir.lil.learningspring.controller.RoomController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LearningSpringApplicationTests {

    @Autowired
    private RoomController roomController;

    @Test
    void contextLoads() throws Exception {
        assertThat(this.roomController).isNotNull();
    }
}
