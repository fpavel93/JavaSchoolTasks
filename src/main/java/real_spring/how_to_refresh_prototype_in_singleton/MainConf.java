package real_spring.how_to_refresh_prototype_in_singleton;

import design_patterns.heroesGame.RandomUtil;
import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

import java.awt.*;

import static design_patterns.heroesGame.RandomUtil.getRandomInRange;

@Configuration
@ComponentScan
public class MainConf {

    @Bean
    @Scope(value = "towSeconds", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color(){
        return new Color(getRandomInRange(0,255),getRandomInRange(0,255),getRandomInRange(0,255));
    }

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        while (true){
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(80);
        }
    }
}
