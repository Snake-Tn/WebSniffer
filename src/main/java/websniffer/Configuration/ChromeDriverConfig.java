package websniffer.Configuration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChromeDriverConfig {

    public @Bean
    ChromeDriver chromeDriver() {
        return new ChromeDriver(
                (new ChromeOptions()).addArguments("headless")
        );
    }
}
