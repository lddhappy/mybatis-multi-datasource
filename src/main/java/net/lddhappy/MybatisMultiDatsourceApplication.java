package net.lddhappy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisMultiDatsourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMultiDatsourceApplication.class, args);
        try {
            System.in.read();
        } catch (Exception ex) {

        }
    }
}
