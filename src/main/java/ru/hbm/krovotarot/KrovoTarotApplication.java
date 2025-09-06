package ru.hbm.krovotarot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@OpenAPIDefinition(
        info = @Info(
                title = "Гадание по картам Таро от KrovaKorova",
                version = "1.0.0",
                description = "Сервис предаставляет возможность гадать по 1 и 3м картам Таро",
                contact = @Contact(
                        name = "Vitaliy Kalashnikov",
                        email = "mymailfordev@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                )
        )
)
@EnableRetry
@SpringBootApplication
public class KrovoTarotApplication {
    public static void main(String[] args) {
        SpringApplication.run(KrovoTarotApplication.class, args);
    }
}
