package real_spring.distributionService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

@Configuration
@ComponentScan
@EnableScheduling
public class Config {

    @Bean
    public Map<Integer,MailGenerator> map(List<MailGenerator> generators){
        return generators.stream().collect(toMap(MailGenerator::getMailCode, Function.identity()));
    }
}
