package itmo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Se6BlpsLab1Application {

    public static void main(String[] args) {
        SpringApplication.run(Se6BlpsLab1Application.class, args);
    }

    @Bean
    public Queue myQueue() {
        return new Queue("queue", false);
    }
}
