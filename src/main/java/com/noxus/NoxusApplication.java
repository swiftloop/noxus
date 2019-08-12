package com.noxus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;

/**
 * @author sorata
 * @date 2019-7-23 17:27:46
 */
@SpringBootApplication(exclude = {WebSocketServletAutoConfiguration.class})
public class NoxusApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoxusApplication.class, args);
    }

}
