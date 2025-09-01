package ru.hbm.krovotarot;

import org.springframework.boot.SpringApplication;

public class TestKrovoTarotApplication {

    public static void main(String[] args) {
        SpringApplication.from(KrovoTarotApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
