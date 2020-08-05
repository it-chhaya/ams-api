package com.chhaya.amsapi;



import com.chhaya.amsapi.rest.message.MessageProperties;
import com.chhaya.amsapi.rest.message.Resources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmsApiApplicationTests {

    @Autowired
    private MessageProperties messages;

    @Test
    void contextLoads() {
        String inserted = messages.inserted(Resources.USER.value());
        System.out.println("MSG INSERTED = " + inserted);
    }

}
