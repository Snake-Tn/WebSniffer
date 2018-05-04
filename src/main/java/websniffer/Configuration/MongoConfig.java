package websniffer.Configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    public @Bean MongoClient mongoClient() {
        return new MongoClient("192.168.80.2");
    }
}
